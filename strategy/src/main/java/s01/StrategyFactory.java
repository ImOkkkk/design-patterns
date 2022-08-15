package s01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:11
 * @since 1.0
 */
public class StrategyFactory {

  private static final Map<String, Strategy> strategies = new HashMap<>();

  static {
    strategies.put("A", new ConcreteStrategyA());
    strategies.put("B", new ConcreteStrategyA());
  }

  public static Strategy getStrategy(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("type should not be empty.");
    }
    return strategies.get(type);
  }
}
