package com.performance.model.reporter;

import com.performance.model.aggregator.Aggregator;
import com.performance.model.viewer.StatViewer;
import com.performance.pojo.bo.RequestInfo;
import com.performance.pojo.bo.RequestStat;
import com.performance.service.MetricsStorage;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ImOkkkk
 * @date 2022/7/8 11:42
 * @since 1.0
 */
public class EmailReporter {

  private static final Long DAY_HOURS_IN_SECONDS = 86400L;
  private MetricsStorage metricsStorage;
  private Aggregator aggregator;
  private StatViewer viewer;

  public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
    this.metricsStorage = metricsStorage;
    this.aggregator = aggregator;
    this.viewer = viewer;
  }

  public void startDailyReport() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    Date firstTime = calendar.getTime();
    Timer timer = new Timer();
    timer.schedule(
        new TimerTask() {
          @Override
          public void run() {
            long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;
            Map<String, List<RequestInfo>> requestInfos =
                metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
            Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
            viewer.output(stats, startTimeInMillis, endTimeInMillis);
          }
        },
        firstTime,
        DAY_HOURS_IN_SECONDS * 1000);
  }
}
