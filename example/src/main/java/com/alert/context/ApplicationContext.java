package com.alert.context;


import com.alert.domain.alert.Alert;
import com.alert.handler.ErrorAlertHandler;
import com.alert.handler.TimeOutHandler;
import com.alert.handler.TpsAlertHandler;
import com.alert.pojo.AlertRule;
import com.alert.pojo.Notification;

/**
 * 单例类，负责 Alert 的创建、组装（alertRule和notification 的依赖注入）、初始化（添加 handlers）工作
 *
 * @author ImOkkkk
 * @date 2022/6/2 14:16
 * @since 1.0
 */
public class ApplicationContext {
  private AlertRule alertRule;
  private Notification notification;
  private Alert alert;

  private void initializeBeans() {
    alertRule = new AlertRule();
    notification = new Notification();
    alert = new Alert();
    alert.addHandler(new TpsAlertHandler(alertRule, notification));
    alert.addHandler(new ErrorAlertHandler(alertRule, notification));
    // 改动三：注册 handler
    alert.addHandler(new TimeOutHandler(alertRule, notification));
  }

  public Alert getAlert() {
    return alert;
  }

  //饿汉式单例
  private static final ApplicationContext instance = new ApplicationContext();
  public ApplicationContext() {
    initializeBeans();
  }
  public static ApplicationContext getInstance(){
    return instance;
  }
}
