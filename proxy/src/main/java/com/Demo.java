package com;

import com.controller.IUserController;
import com.controller.UserController;
import com.controller.UserControllerProxy;
import com.controller.UserControllerProxy2;
import com.dynamic.MetricsCollectorProxy;
import com.dynamic.MetricsCollectorProxy2;

/**
 * @author ImOkkkk
 * @date 2022/7/29 9:28
 * @since 1.0
 */
public class Demo {
  public static void main(String[] args) {
    // 因为原始类和代理类实现相同的接口，是基于接口而非实现编程
    // 将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
//    IUserController userController = new UserControllerProxy(new UserController());
//    userController.login("111", "222");
//
//    UserController userController2 = new UserControllerProxy2();
//    userController2.login("111", "222");

//    MetricsCollectorProxy proxy = new MetricsCollectorProxy();
//    IUserController userController3 = (IUserController) proxy.createProxy(new UserController());
//    userController3.login("111", "222");

    MetricsCollectorProxy2 proxy2 = new MetricsCollectorProxy2();
    UserController userController4 = (UserController) proxy2.createProxy(new UserController());
    userController4.login("111", "222");
  }
}
