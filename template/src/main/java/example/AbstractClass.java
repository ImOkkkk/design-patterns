package example;

/**
 * @author ImOkkkk
 * @date 2022/8/12 13:58
 * @since 1.0
 */
public abstract class AbstractClass {
  public final void templateMethod() {
    // ...
    method1();
    // ...
    method2();
    // ...
  }

  protected abstract void method1();

  protected abstract void method2();
}
