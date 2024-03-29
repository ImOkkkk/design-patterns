package s02;

import s02.Order.OrderType;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:26
 * @since 1.0
 */
public class OrderService {

  public double discount(Order order) {
    double discount = 0.0;
    OrderType type = order.getType();
    if (type.equals(OrderType.NORMAL)) { // 普通订单
      // ...省略折扣计算算法代码
    } else if (type.equals(OrderType.GROUPON)) { // 团购订单
      // ...省略折扣计算算法代码
    } else if (type.equals(OrderType.PROMOTION)) { // 促销订单\
      // ...省略折扣计算算法代码
    }
    return discount;
  }
}
