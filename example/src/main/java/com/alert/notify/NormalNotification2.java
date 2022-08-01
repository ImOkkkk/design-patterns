package com.alert.notify;

import com.alert.pojo.Notification2;
import com.alert.sender.MsgSender;

/**
 * @author ImOkkkk
 * @date 2022/8/1 9:57
 * @since 1.0
 */
public class NormalNotification2 extends Notification2 {
  public NormalNotification2(MsgSender msgSender){
    super(msgSender);
  }

  @Override
  public void notify(String message) {
    msgSender.send(message);
  }
}
