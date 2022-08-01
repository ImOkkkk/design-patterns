package com.alert.sender;

import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/8/1 9:53
 * @since 1.0
 */
public class EmailMsgSender implements MsgSender{
  private List<String> emailAddresses;

  public EmailMsgSender(List<String> emailAddresses) {
    this.emailAddresses = emailAddresses;
  }

  @Override
  public void send(String message) {

  }
}
