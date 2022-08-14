package callback;

/**
 * @author ImOkkkk
 * @date 2022/8/14 10:45
 * @since 1.0
 */
public class AClass {
  public static void main(String[] args) {
    BClass b = new BClass();
    b.process(
        new ICallback() { // 回调对象
          @Override
          public void methodToCallback() {
            System.out.println("Call back me.");
          }
        });
  }
}
