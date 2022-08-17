package c01.refactor02;

/**
 * @author ImOkkkk
 * @date 2022/8/16 16:52
 * @since 1.0
 */
public class HandlerChain {
  private Handler head = null;
  private Handler tail = null;

  public void addHandler(Handler handler){
    handler.setSuccessor(null);
    if(head == null){
      head = handler;
      tail = handler;
      return;
    }
    tail.setSuccessor(handler);
    tail = handler;
  }

  // 请求会被所有的处理器都处理一遍，不存在中途终止的情况。这种变体也有两种实现方式
  public void handle() {
    if(head != null){
      head.handle();
    }
  }

}
