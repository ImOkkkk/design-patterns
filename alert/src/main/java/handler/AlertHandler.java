package handler;

import pojo.AlertRule;
import pojo.ApiStatInfo;
import pojo.Notification;

/**
 * 引入handler的概念，将if判断逻辑分散在各个handler中
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
