package model.aggregator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pojo.bo.RequestInfo;
import pojo.bo.RequestStat;

/**
 * @author ImOkkkk
 * @date 2022/7/8 11:14
 * @since 1.0
 */
public class Aggregator {

    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;
        for (RequestInfo requestInfo : requestInfos) {
            ++count;
            double respTime = requestInfo.getResponseTime();
            maxRespTime = Math.max(respTime, maxRespTime);
            minRespTime = Math.min(respTime, minRespTime);
            sumRespTime += respTime;
        }
        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        long tps = (long) (count / durationInMillis * 1000);
        Collections.sort(
                requestInfos,
                new Comparator<RequestInfo>() {
                    @Override
                    public int compare(RequestInfo o1, RequestInfo o2) {
                        double diff = o1.getResponseTime() - o2.getResponseTime();
                        if (diff > 0.0) {
                            return 1;
                        } else if (diff < 0.0) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
        int index999 = (int) (count * 0.999);
        int index99 = (int) (count * 0.99);
        if (count != 0) {
            p999RespTime = requestInfos.get(index999).getResponseTime();
            p99RespTime = requestInfos.get(index99).getResponseTime();
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);
        return requestStat;
    }
}
