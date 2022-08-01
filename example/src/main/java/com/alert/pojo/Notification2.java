package com.alert.pojo;

import com.alert.sender.MsgSender;

/**
 * Notification类相当于抽象，MsgSender类相当于实现
 *
 * @author ImOkkkk
 * @date 2022/8/1 9:56
 * @since 1.0
 */
public abstract class Notification2 {
  protected MsgSender msgSender;

  public Notification2(MsgSender msgSender) {
    this.msgSender = msgSender;
  }

  public abstract void notify(String message);
}
