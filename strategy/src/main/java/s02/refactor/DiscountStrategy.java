package s02.refactor;

import s02.Order;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:30
 * @since 1.0
 */
public interface DiscountStrategy {

  double calDiscount(Order order);

}
