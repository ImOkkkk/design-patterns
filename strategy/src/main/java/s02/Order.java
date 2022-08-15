package s02;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:27
 * @since 1.0
 */
public class Order {

  private OrderType orderType;

  public OrderType getType() {
    return orderType;
  }

  public enum OrderType{
    NORMAL, GROUPON, PROMOTION;
  }

}
