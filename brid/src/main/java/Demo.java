import pojo.Sparrow;

/**
 * @author ImOkkkk
 * @date 2022/6/2 14:56
 * @since 1.0
 */

/** 利用组合(composition)、接口、委托(delegation)，替代继承 */
public class Demo {
  public static void main(String[] args) {
    Sparrow sparrow = new Sparrow();
    sparrow.fly();
  }
}
