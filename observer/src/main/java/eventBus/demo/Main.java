package eventBus.demo;

import com.google.common.collect.Lists;
import p2p.service.impl.NotificationServiceImpl;
import p2p.service.impl.PromotionServiceImpl;
import p2p.service.impl.UserServiceImpl;

/**
 * @author ImOkkkk
 * @date 2022/8/11 13:49
 * @since 1.0
 */
public class Main {
  public static void main(String[] args) {
    UserController userController = new UserController( new UserServiceImpl());
    userController.setRegObservers(
        Lists.newArrayList(
            new RegPromotionObserver(new PromotionServiceImpl()),
            new RegNotificationObserver(new NotificationServiceImpl())));
    userController.register("911", "123456");
  }
}
