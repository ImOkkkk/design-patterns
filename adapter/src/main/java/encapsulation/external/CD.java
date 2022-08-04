package encapsulation.external;

/**
 * 这个类来自外部sdk，我们无权修改它的代码
 *
 * @author ImOkkkk
 * @date 2022/8/2 13:10
 * @since 1.0
 */
public class CD {
  public static void staticFunction1() {
    // ...
  }

  public void uglyNamingFunction2() {
    // ...
  }

  public void tooManyParamsFunction3(String paramA, String paramB) {
    // ...
  }

  public void lowPerformanceFunction4() {
    // ...
  }
}
