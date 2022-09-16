package com.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ImOkkkk
 * @date 2022/9/15 17:25
 * @since 1.0
 */

// Publisher发送者
@Component
public class DemoPublisher {

  @Autowired private ApplicationContext applicationContext;

  public void publishEvent(DemoEvent event) {
    applicationContext.publishEvent(event);
  }
}
