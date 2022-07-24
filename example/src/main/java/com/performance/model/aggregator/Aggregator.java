package com.performance.model.aggregator;

import com.performance.pojo.bo.RequestInfo;
import com.performance.pojo.bo.RequestStat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author ImOkkkk
 * @date 2022/7/8 11:14
 * @since 1.0
 */
public class Aggregator {

    public Map<String, RequestStat> aggregate(
            Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes.size(), durationInMillis / 1000));
        return requestStat;
    }

    private double max(List<Double> dataset) {
        double maxRespTime = Double.MIN_VALUE;
        for (Double respTime : dataset) {
            maxRespTime = Math.max(respTime, maxRespTime);
        }
        return maxRespTime;
    }

    private double min(List<Double> dataset) {
        double minRespTime = Double.MAX_VALUE;
        for (Double respTime : dataset) {
            minRespTime = Math.min(respTime, minRespTime);
        }
        return minRespTime;
    }

    private double avg(List<Double> dataset) {
        double avgRespTime = -1;
        double sumRespTime = 0;
        long count = 0;
        for (Double respTime : dataset) {
            ++count;
            sumRespTime += respTime;
        }
        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        return avgRespTime;
    }

    private double tps(int count, double duration) {
        return count / duration;
    }

    private double percentile999(List<Double> dataset) {
        return dataset.get((int) percentile(dataset, 0.999));
    }

    private double percentile99(List<Double> dataset) {
        return dataset.get((int) percentile(dataset, 0.99));
    }

    private double percentile(List<Double> dataset, double ratio) {
        Collections.sort(
                dataset,
                new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        double diff = o1 - o2;
                        if (diff > 0.0) {
                            return 1;
                        } else if (diff < 0.0) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
        return (dataset.size() * ratio);
    }
}
