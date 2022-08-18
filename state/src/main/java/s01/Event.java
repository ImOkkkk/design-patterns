package s01;

/**
 * @author ImOkkkk
 * @date 2022/8/18 13:12
 * @since 1.0
 */
public enum Event {
  GOT_MUSHROOM(0),
  GOT_CAPE(1),
  GOT_FIRE(2),
  MET_MONSTER(3);
  private int value;
  private Event(int value) {
    this.value = value;
  }
  public int getValue() {
    return this.value;
  }
}
