package p2p.service.impl;

import p2p.service.NotificationService;

/**
 * @author ImOkkkk
 * @date 2022/8/11 13:54
 * @since 1.0
 */
public class NotificationServiceImpl implements NotificationService {

  @Override
  public void sendInboxMessage(Long userId, String message) {
    System.out.println(Thread.currentThread().getName() + ": send message to " + userId);
  }
}
