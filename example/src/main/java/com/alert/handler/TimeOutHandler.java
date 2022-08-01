package com.alert.handler;

import com.alert.common.NotificationEmergencyLevel;
import com.alert.pojo.AlertRule;
import com.alert.pojo.ApiStatInfo;
import com.alert.pojo.Notification;

/**
 * 改动二：添加新的 handler
 *
 * @author ImOkkkk
 * @date 2022/6/2 14:28
 * @since 1.0
 */
public class TimeOutHandler extends AlertHandler {

  public TimeOutHandler(AlertRule alertRule, Notification notification) {
    super(alertRule, notification);
  }

  @Override
  public void check(ApiStatInfo apiStatInfo) {
    if (apiStatInfo.getTimeoutCount()
        > alertRule.getMatchedRule(apiStatInfo.getApi()).getMAX_TIME_OUT()) {
      notification.notify(NotificationEmergencyLevel.SEVERE, "...");
    }
  }
}
