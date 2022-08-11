package p2p.eventBus;

import com.google.common.eventbus.Subscribe;
import p2p.service.NotificationService;

/**
 * @author ImOkkkk
 * @date 2022/8/11 11:19
 * @since 1.0
 */
public class RegNotificationObserver {

  private NotificationService notificationService;

  // 基于 EventBus，我们不需要定义 Observer 接口，任意类型的对象都可以注册到 EventBus 中，
  // 通过 @Subscribe 注解来标明类中哪个函数可以接收被观察者发送的消息。
  @Subscribe
  public void handleRegSuccess(long userId) {
    notificationService.sendInboxMessage(userId, "...");
  }
}
