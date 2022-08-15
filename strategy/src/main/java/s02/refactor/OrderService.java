package s02.refactor;

import s02.Order;
import s02.Order.OrderType;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:34
 * @since 1.0
 */
public class OrderService {
  public double discount(Order order) {
    OrderType orderType = order.getType();
    DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(orderType);
    return discountStrategy.calDiscount(order);
  }

}
