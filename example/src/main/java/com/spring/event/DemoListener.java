package com.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ImOkkkk
 * @date 2022/9/15 17:23
 * @since 1.0
 */
// Listener监听者
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

  @Override
  public void onApplicationEvent(DemoEvent event) {
    String message = event.getMessage();
    System.out.println(message);
  }
}
