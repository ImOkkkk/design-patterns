package com.alert.sender;

import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/8/1 9:54
 * @since 1.0
 */
public class WechatMsgSender implements MsgSender{

  private List<String> wechatIds;

  public WechatMsgSender(List<String> wechatIds) {
    this.wechatIds = wechatIds;
  }

  @Override
  public void send(String message) {

  }
}
