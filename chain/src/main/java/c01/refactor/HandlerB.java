package c01.refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/16 15:45
 * @since 1.0
 */
public class HandlerB extends Handler{

  @Override
  protected boolean doHandle() {
    boolean handled = false;
    System.out.println("HandlerB");
    return handled;
  }
}
