package pojo;

import common.NotificationEmergencyLevel;

/**
 * 告警通知类，支持邮件、 短信、微信、手机等多种通知渠道
 *
 * @author ImOkkkk
 * @date 2022/6/2 13:34
 * @since 1.0
 */
public class Notification {

  public void notify(NotificationEmergencyLevel emergencyLevel, String msg) {
    System.out.println(emergencyLevel + ":" + msg);
  }
}
