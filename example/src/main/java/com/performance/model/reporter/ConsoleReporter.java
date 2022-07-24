package com.performance.model.reporter;

import com.performance.model.aggregator.Aggregator;
import com.performance.model.viewer.ConsoleViewer;
import com.performance.model.viewer.StatViewer;
import com.performance.service.MetricsStorage;
import com.performance.service.impl.RedisMetricsStorage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ImOkkkk
 * @date 2022/7/8 11:31
 * @since 1.0
 */
public class ConsoleReporter extends ScheduledReporter {
  private MetricsStorage metricsStorage;
  private Aggregator aggregator;
  private StatViewer viewer;
  private ScheduledExecutorService executor;

  // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
  public ConsoleReporter() {
    this(new RedisMetricsStorage(), new Aggregator(), new ConsoleViewer());
  }

  // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
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
            doStatAndReport(startTimeInMillis, endTimeInMillis);
          }
        },
        0,
        periodInSeconds,
        TimeUnit.SECONDS);
  }
}
