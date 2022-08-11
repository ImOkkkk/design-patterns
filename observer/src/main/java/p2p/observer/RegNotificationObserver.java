package p2p.observer;

import p2p.service.NotificationService;

/**
 * @author ImOkkkk
 * @date 2022/8/11 11:00
 * @since 1.0
 */
public class RegNotificationObserver implements RegObserver{

  private NotificationService notificationService;


  @Override
  public void handleRegSuccess(long userId) {
    notificationService.sendInboxMessage(userId, "Welcome...");
  }
}
