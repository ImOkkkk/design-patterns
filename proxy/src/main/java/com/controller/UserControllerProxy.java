package com.controller;

import com.performance.controller.MetricsCollector;
import com.performance.pojo.bo.RequestInfo;
import com.pojo.UserVo;

/**
 * 代理类和原始类需要实现相同的接口
 *
 * @author ImOkkkk
 * @date 2022/7/29 9:21
 * @since 1.0
 */
public class UserControllerProxy implements IUserController {

  private MetricsCollector metricsCollector;
  private UserController userController;

  public UserControllerProxy(UserController userController) {
    this.metricsCollector = new MetricsCollector();
    this.userController = userController;
  }

  @Override
  public UserVo login(String telephone, String password) {
    long startTimestamp = System.currentTimeMillis();
    // 委托
    UserVo userVo = userController.login(telephone, password);
    long endTimestamp = System.currentTimeMillis();

    long responseTime = endTimestamp - startTimestamp;
    RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
    metricsCollector.recordRequest(requestInfo);
    return userVo;
  }

  @Override
  public UserVo register(String telephone, String password) {
    long startTimestamp = System.currentTimeMillis();
    UserVo userVo = userController.register(telephone, password);
    long endTimeStamp = System.currentTimeMillis();
    long responseTime = endTimeStamp - startTimestamp;
    RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
    metricsCollector.recordRequest(requestInfo);
    return userVo;
  }
}
