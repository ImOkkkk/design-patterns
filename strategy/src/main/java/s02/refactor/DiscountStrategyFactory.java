package s02.refactor;

import java.util.HashMap;
import java.util.Map;
import s02.Order.OrderType;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:32
 * @since 1.0
 */
public class DiscountStrategyFactory {
  private static final Map<OrderType, DiscountStrategy> strategies = new HashMap();

  static {
    strategies.put(OrderType.NORMAL, new NormalDiscountStrategy());
    strategies.put(OrderType.GROUPON, new GrouponDiscountStrategy());
    strategies.put(OrderType.PROMOTION, new PromotionDiscountStrategy());
  }

  public static DiscountStrategy getDiscountStrategy(OrderType type) {
    return strategies.get(type);
  }

}
