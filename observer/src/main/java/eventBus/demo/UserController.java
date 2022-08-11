package eventBus.demo;

import eventBus.AsyncEventBus;
import eventBus.EventBus;
import java.util.List;
import java.util.concurrent.Executors;
import p2p.service.UserService;

/**
 * @author ImOkkkk
 * @date 2022/8/11 11:16
 * @since 1.0
 */
public class UserController {

  private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;
  private UserService userService; // 依赖注入
  private EventBus eventBus;

  public UserController(UserService userService) {
    this.userService = userService;
    // eventBus = new EventBus(); // 同步阻塞模式
    eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
  }

  public void setRegObservers(List<Object> observers) {
    for (Object observer : observers) {
      eventBus.register(observer);
    }
  }

  public Long register(String telephone, String password) {
    Long userId = userService.register(telephone, password);
    eventBus.post(userId);
    return userId;
  }
}
