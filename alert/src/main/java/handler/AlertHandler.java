package handler;

import pojo.AlertRule;
import pojo.ApiStatInfo;
import pojo.Notification;

/**
 * @author ImOkkkk
 * @date 2022/6/2 13:30
 * @since 1.0
 */
public abstract class AlertHandler {

  protected AlertRule alertRule;

  protected Notification notification;

  public abstract void check(ApiStatInfo apiStatInfo);

  public AlertHandler(AlertRule alertRule, Notification notification) {
    this.alertRule = alertRule;
    this.notification = notification;
  }
}
