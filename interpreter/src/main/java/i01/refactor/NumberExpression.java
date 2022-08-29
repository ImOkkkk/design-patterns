package i01.refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/29 15:15
 * @since 1.0
 */
public class NumberExpression implements Expression {
  private long number;

  public NumberExpression(long number) {
    this.number = number;
  }

  public NumberExpression(String number) {
    this.number = Long.parseLong(number);
  }

  @Override
  public long interpret() {
    return this.number;
  }
}
