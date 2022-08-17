package c01.refactor01;

/**
 * @author ImOkkkk
 * @date 2022/8/16 16:44
 * @since 1.0
 */
public class Demo {
  public static void main(String[] args) {
    HandlerChain chain = new HandlerChain();
    chain.addHandler(new HandlerA());
    chain.addHandler(new HandlerB());
    chain.handle();
  }
}
