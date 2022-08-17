package c01;

/**
 * @author ImOkkkk
 * @date 2022/8/16 14:34
 * @since 1.0
 */
public abstract class Handler {
  protected Handler successor = null;

  public void setSuccessor(Handler successor) {
    this.successor = successor;
  }

  public abstract void handle();
}
