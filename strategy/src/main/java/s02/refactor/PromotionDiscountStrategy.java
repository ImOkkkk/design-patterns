package s02.refactor;

import s02.Order;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:31
 * @since 1.0
 */
public class PromotionDiscountStrategy implements DiscountStrategy{

  @Override
  public double calDiscount(Order order) {
    return 0;
  }
}
