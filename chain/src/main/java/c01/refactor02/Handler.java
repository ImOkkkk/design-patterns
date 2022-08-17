package c01.refactor02;

/**
 * @author ImOkkkk
 * @date 2022/8/16 16:49
 * @since 1.0
 */
public abstract class Handler {
  protected Handler successor = null;

  public void setSuccessor(Handler successor){
    this.successor = successor;
  }

  public final void handle(){
    doHandle();
    if(successor != null){
      successor.handle();
    }
  }

  protected abstract void doHandle();
}
