package com.alert;

import com.alert.context.ApplicationContext;
import com.alert.pojo.ApiStatInfo;

/**
 * @author ImOkkkk
 * @date 2022/6/2 14:23
 * @since 1.0
 */

/**
 * 对扩展开放、对修改关闭
 * 想添加新的告警逻辑，只需要基于扩展的方式创建新的handler类即可，不需要改动原来的check()函数的逻辑。而且，我们只需要为新的 handler类添加单元测试，老的单元测试都不会失败，也不用修改。
 */
public class Demo {
  public static void main(String[] args) {
    ApiStatInfo apiStatInfo = new ApiStatInfo();
    apiStatInfo.setApi("/api/get/");
    apiStatInfo.setRequestCount(100);
    apiStatInfo.setErrorCount(100);
    apiStatInfo.setDurationOfSeconds(10);
    apiStatInfo.setTimeoutCount(300);
    ApplicationContext.getInstance().getAlert().check(apiStatInfo);
  }
}
