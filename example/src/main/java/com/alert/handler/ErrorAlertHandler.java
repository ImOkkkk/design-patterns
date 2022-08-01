package com.alert.handler;

import com.alert.common.NotificationEmergencyLevel;
import com.alert.pojo.AlertRule;
import com.alert.pojo.ApiStatInfo;
import com.alert.pojo.Notification;

/**
 * @author ImOkkkk
 * @date 2022/6/2 14:14
 * @since 1.0
 */
public class ErrorAlertHandler extends AlertHandler {

  public ErrorAlertHandler(AlertRule alertRule, Notification notification) {
    super(alertRule, notification);
  }

  @Override
  public void check(ApiStatInfo apiStatInfo) {
    if (apiStatInfo.getErrorCount()
        > alertRule.getMatchedRule(apiStatInfo.getApi()).getMAX_ERROR()) {
      notification.notify(NotificationEmergencyLevel.SEVERE, "...");
    }
  }
}
