package c01;

/**
 * @author ImOkkkk
 * @date 2022/8/16 14:37
 * @since 1.0
 */
public class HandlerChain {
  private Handler head = null;
  private Handler tail = null;

  public void addHandler(Handler handler){
    handler.setSuccessor(null);
    if (head == null){
      head = handler;
      tail = handler;
      return;
    }
    tail.setSuccessor(handler);
    tail = handler;
  }

  public void handle() {
    if (head != null) {
      head.handle();
    }
  }

}
