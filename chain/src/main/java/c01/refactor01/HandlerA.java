package c01.refactor01;

/**
 * @author ImOkkkk
 * @date 2022/8/16 16:36
 * @since 1.0
 */
public class HandlerA implements IHandler{

  @Override
  public boolean handle() {
    boolean handled = false;
    System.out.println("HandlerA");
    return handled;
  }
}
