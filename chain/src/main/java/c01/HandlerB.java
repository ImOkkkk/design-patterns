package c01;

/**
 * @author ImOkkkk
 * @date 2022/8/16 14:36
 * @since 1.0
 */
public class HandlerB extends Handler{


  @Override
  public void handle() {
    boolean handled = false;
    System.out.println("HandlerB");
    if(!handled && successor != null){
      successor.handle();
    }
  }
}
