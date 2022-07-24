package com.performance.model.reporter;

import com.performance.model.aggregator.Aggregator;
import com.performance.model.viewer.EmailViewer;
import com.performance.model.viewer.StatViewer;
import com.performance.service.MetricsStorage;
import com.performance.service.impl.RedisMetricsStorage;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ImOkkkk
 * @date 2022/7/8 11:42
 * @since 1.0
 */
public class EmailReporter extends ScheduledReporter {

  private static final Long DAY_HOURS_IN_SECONDS = 86400L;
  private MetricsStorage metricsStorage;
  private Aggregator aggregator;
  private StatViewer viewer;

  // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
  public EmailReporter(List<String> emailToAddresses) {
    this(new RedisMetricsStorage(), new Aggregator(), new EmailViewer(emailToAddresses));
  }

  // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
  public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
    this.metricsStorage = metricsStorage;
    this.aggregator = aggregator;
    this.viewer = viewer;
  }

  public void startDailyReport() {
    Date firstTime = trimTimeFieldsToZeroOfNextDay(new Date());
    Timer timer = new Timer();
    timer.schedule(
        new TimerTask() {
          @Override
          public void run() {
            long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;
            doStatAndReport(startTimeInMillis, endTimeInMillis);
          }
        },
        firstTime,
        DAY_HOURS_IN_SECONDS * 1000);
  }

  protected Date trimTimeFieldsToZeroOfNextDay(Date date) {
    Calendar calendar = Calendar.getInstance(); // 这里可以获取当前时间
    calendar.setTime(date); // 重新设置时间
    calendar.add(Calendar.DATE, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }
}
