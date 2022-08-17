package c01.refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/16 15:39
 * @since 1.0
 */
public abstract class Handler {
  protected Handler successor = null;

  public void setSuccessor(Handler successor) {
    this.successor = successor;
  }
  // 模板模式，将调用 successor.handle() 的逻辑
  // 从具体的处理器类中剥离出来，放到抽象父类中。
  // 具体的处理器类只需要实现自己的业务逻辑
  public final void handle() {
    boolean handled = doHandle();
    if (successor != null && !handled) {
      successor.handle();
    }
  }

  protected abstract boolean doHandle();

}
