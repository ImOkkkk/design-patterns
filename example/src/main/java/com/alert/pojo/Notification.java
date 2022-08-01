package com.alert.pojo;

import com.alert.common.NotificationEmergencyLevel;
import java.util.List;

/**
 * 告警通知类，支持邮件、 短信、微信、手机等多种通知渠道
 *
 * @author ImOkkkk
 * @date 2022/6/2 13:34
 * @since 1.0
 */
public class Notification {
  private List<String> emailAddresses;
  private List<String> telephones;
  private List<String> wechatIds;

  public Notification() {}

  public void setEmailAddress(List<String> emailAddress) {
    this.emailAddresses = emailAddress;
  }

  public void setTelephones(List<String> telephones) {
    this.telephones = telephones;
  }

  public void setWechatIds(List<String> wechatIds) {
    this.wechatIds = wechatIds;
  }

  public void notify(NotificationEmergencyLevel level, String message) {
    if (level.equals(NotificationEmergencyLevel.SEVERE)) {
      // ...语音电话
    } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
      // ...发微信
    } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
      // ...发邮件
    } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
      // ...发邮件
    }
  }
}
