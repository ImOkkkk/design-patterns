package s01;

/**
 * @author ImOkkkk
 * @date 2022/8/18 11:32
 * @since 1.0
 */
public enum State {
  SMALL(0),
  SUPER(1),
  FIRE(2),
  CAPE(3);
  private int value;

  State(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
