package s01;

/**
 * 分支逻辑法
 * if-else/switch-case，可读性和维护性都很差
 *
 * @author ImOkkkk
 * @date 2022/8/18 11:33
 * @since 1.0
 */
public class MarioStateMachine01 {
  private int score;
  private State currentState;

  public MarioStateMachine01() {
    this.score = 0;
    this.currentState = State.SMALL;
  }

  public int getScore() {
    return this.score;
  }

  public State getCurrentState() {
    return this.currentState;
  }

  public void obtainMushRoom() {
    if (currentState.equals(State.SMALL)) {
      this.currentState = State.SUPER;
      this.score += 100;
    }
  }

  public void obtainCape() {
    if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER))
      this.currentState = State.CAPE;
    this.score += 200;
  }

  public void obtainFireFlower() {
    if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER))
      this.currentState = State.FIRE;
    this.score += 300;
  }

  public void meetMonster() {
    if (currentState.equals(State.SUPER)) {
      this.currentState = State.SMALL;
      this.score -= 100;
      return;
    }
    if (currentState.equals(State.CAPE)) {
      this.currentState = State.SMALL;
      this.score -= 200;
      return;
    }
    if (currentState.equals(State.FIRE)) {
      this.currentState = State.SMALL;
      this.score -= 300;
      return;
    }
  }
}
