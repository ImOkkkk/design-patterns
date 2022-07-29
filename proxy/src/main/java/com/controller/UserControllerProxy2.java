package com.controller;

import com.performance.controller.MetricsCollector;
import com.performance.pojo.bo.RequestInfo;
import com.pojo.UserVo;

/**
 * 代理类继承原始类，然后扩展附加功能
 *
 * @author ImOkkkk
 * @date 2022/7/29 9:30
 * @since 1.0
 */
public class UserControllerProxy2 extends UserController {
  private MetricsCollector metricsCollector;

  public UserControllerProxy2() {
    this.metricsCollector = new MetricsCollector();
  }

  @Override
  public UserVo login(String telephone, String password) {
    long startTimestamp = System.currentTimeMillis();
    // 委托
    UserVo userVo = super.login(telephone, password);
    long endTimestamp = System.currentTimeMillis();

    long responseTime = endTimestamp - startTimestamp;
    RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
    metricsCollector.recordRequest(requestInfo);
    return userVo;

  }

  @Override
  public UserVo register(String telephone, String password) {
    long startTimestamp = System.currentTimeMillis();
    UserVo userVo = super.register(telephone, password);
    long endTimeStamp = System.currentTimeMillis();
    long responseTime = endTimeStamp - startTimestamp;
    RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
    metricsCollector.recordRequest(requestInfo);
    return userVo;
  }
}
