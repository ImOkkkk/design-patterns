package handler;

import common.NotificationEmergencyLevel;
import pojo.AlertRule;
import pojo.ApiStatInfo;
import pojo.Notification;

/**
 * @author ImOkkkk
 * @date 2022/6/2 14:06
 * @since 1.0
 */
public class TpsAlertHandler extends AlertHandler {

  public TpsAlertHandler(AlertRule alertRule, Notification notification) {
    super(alertRule, notification);
  }

  @Override
  public void check(ApiStatInfo apiStatInfo) {
    long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
    if (tps > alertRule.getMatchedRule(apiStatInfo.getApi()).getMAX_TPS()) {
      notification.notify(NotificationEmergencyLevel.URGENCY, "...");
    }
  }
}
