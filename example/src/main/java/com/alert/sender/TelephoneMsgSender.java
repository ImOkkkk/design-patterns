package com.alert.sender;

import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/8/1 9:52
 * @since 1.0
 */
public class TelephoneMsgSender implements MsgSender {

  private List<String> telephones;

  public TelephoneMsgSender(List<String> telephones) {
    this.telephones = telephones;
  }

  @Override
  public void send(String message) {}
}
