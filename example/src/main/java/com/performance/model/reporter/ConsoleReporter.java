package com.performance.model.reporter;

import com.performance.model.aggregator.Aggregator;
import com.performance.model.viewer.StatViewer;
import com.performance.pojo.bo.RequestInfo;
import com.performance.pojo.bo.RequestStat;
import com.performance.service.MetricsStorage;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ImOkkkk
 * @date 2022/7/8 11:31
 * @since 1.0
 */
public class ConsoleReporter {
  private MetricsStorage metricsStorage;
  private Aggregator aggregator;
  private StatViewer viewer;
  private ScheduledExecutorService executor;

  public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
    this.metricsStorage = metricsStorage;
    this.aggregator = aggregator;
    this.viewer = viewer;
    this.executor = Executors.newSingleThreadScheduledExecutor();
  }

  public void startRepeatedReport(long periodInSeconds, final long durationInSeconds) {
    executor.scheduleAtFixedRate(
        new Runnable() {
          @Override
          public void run() {
            // 第 1 个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
            long durationInMillis = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;
            Map<String, List<RequestInfo>> requestInfos =
                metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
            // 第2个代码逻辑：根据原始数据，计算得到统计数据；
            Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInSeconds);
            // 第 3 个代码逻辑：将统计数据显示到终端（命令行或邮件）；
            viewer.output(stats, startTimeInMillis, endTimeInMillis);
          }
        },
        0,
        periodInSeconds,
        TimeUnit.SECONDS);
  }
}
