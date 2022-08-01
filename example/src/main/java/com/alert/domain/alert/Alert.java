package com.alert.domain.alert;

import com.alert.handler.AlertHandler;
import java.util.ArrayList;
import java.util.List;
import com.alert.pojo.ApiStatInfo;

/**
 * @author ImOkkkk
 * @date 2022/6/2 13:30
 * @since 1.0
 */
public class Alert {

  private List<AlertHandler> alertHandlers = new ArrayList<>();

  public void addHandler(AlertHandler alertHandler) {
    this.alertHandlers.add(alertHandler);
  }

  public void check(ApiStatInfo apiStatInfo) {
    for (AlertHandler alertHandler : alertHandlers) {
      alertHandler.check(apiStatInfo);
    }
  }
}
