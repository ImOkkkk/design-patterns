package com.performance.model.reporter;

import com.performance.model.aggregator.Aggregator;
import com.performance.model.viewer.StatViewer;
import com.performance.pojo.bo.RequestInfo;
import com.performance.pojo.bo.RequestStat;
import com.performance.service.MetricsStorage;
import java.util.List;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/7/24 16:17
 * @since 1.0
 */
public class ScheduledReporter {
    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatViewer viewer;

    public ScheduledReporter(MetricsStorage metricsStorage,
        Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    public ScheduledReporter() {
    }

    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis){
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos =
            metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }
}
