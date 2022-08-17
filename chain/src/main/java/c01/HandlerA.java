package c01;

/**
 * @author ImOkkkk
 * @date 2022/8/16 14:35
 * @since 1.0
 */
public class HandlerA extends Handler{

  @Override
  public void handle() {
    boolean handled = false;
    // 不仅包含业务逻辑，还包含对下一个处理器的调用
    // 容易忘记在 handle() 函数中调用successor.handle()
    System.out.println("HandlerA");
    if( !handled && successor != null){
      successor.handle();
    }
  }
}
