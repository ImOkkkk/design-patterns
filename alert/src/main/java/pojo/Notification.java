package pojo;

import common.NotificationEmergencyLevel;

/**
 * @author ImOkkkk
 * @date 2022/6/2 13:34
 * @since 1.0
 */
public class Notification {

  public void notify(NotificationEmergencyLevel emergencyLevel, String msg) {
    System.out.println(emergencyLevel + ":" + msg);
  }
}
