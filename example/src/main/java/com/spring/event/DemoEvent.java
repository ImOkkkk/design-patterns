package com.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author ImOkkkk
 * @date 2022/9/15 17:21
 * @since 1.0
 */
//Event事件
public class DemoEvent extends ApplicationEvent {
  private String message;

  public DemoEvent(Object source, String message){
    super(source);
  }

  public String getMessage(){
    return this.message;
  }
}
