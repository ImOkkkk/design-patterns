package p2p.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import p2p.observer.RegObserver;
import p2p.service.PromotionService;
import p2p.service.UserService;

/**
 * @author ImOkkkk
 * @date 2022/8/11 10:57
 * @since 1.0
 */
public class UserController {
  private Executor executor;
  private UserService userService;

  // 当需要添加新的观察者的时候，比如，用户注册成功之后，推送用户注册信息给大数据
  // 征信系统，基于观察者模式的代码实现，UserController 类的 register() 函数完全不需要
  // 修改，只需要再添加一个实现了 RegObserver 接口的类，并且通过 setRegObservers()
  // 函数将它注册到 UserController 类中即可。

  private List<RegObserver> regObservers = new ArrayList<>();

  // 一次性设置好，之后也不可能动态的修改
  public void setRegObservers(List<RegObserver> observers) {
    regObservers.addAll(observers);
  }

  public Long register(String telephone, String password) {
    long userId = userService.register(telephone, password);
    // 同步阻塞
    //    for (RegObserver observer : regObservers) {
    //      observer.handleRegSuccess(userId);
    //    }
    // 异步非阻塞
    // 线程池、异步执行逻辑都耦合在了 register() 函数中，增加了这部分业务代码的维护成本
    for (RegObserver regObserver : regObservers) {
      executor.execute(new Runnable() {
        @Override
        public void run() {
          regObserver.handleRegSuccess(userId);
        }
      });
    }
    return userId;
  }

//  private PromotionService promotionService;
//
//  public Long register(String telephone, String password) {
//    // 省略输入参数的校验代码
//    // 省略userService.register()异常的try-catch代码
//
//    //注册
//    long userId = userService.register(telephone, password);
//    //发放体验金
//    promotionService.issueNewUserExperienceCash(userId);
//    return userId;
//  }
}
