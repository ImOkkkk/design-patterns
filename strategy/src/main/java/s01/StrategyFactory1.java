package s01;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:16
 * @since 1.0
 */
public class StrategyFactory1 {

  // 如果策略类是有状态的，根据业务场景的需要，每次从工厂方法中，获得的都是新创建的策略对象
  public static Strategy getStrategy(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("type should not be empty.");
    }
    if (type.equals("A")) {
      return new ConcreteStrategyA();
    } else if (type.equals("B")) {
      return new ConcreteStrategyB();
    }
    return null;
  }
}
