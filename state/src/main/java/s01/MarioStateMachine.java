package s01;

/**
 * @author ImOkkkk
 * @date 2022/8/18 11:33
 * @since 1.0
 */
public class MarioStateMachine {
  private int score;
  private State currentState;

  public MarioStateMachine() {
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
    // TODO 根据当前的状态和事件，更新状态和增减积分
  }

  public void obtainCape() {
    // TODO
  }

  public void obtainFireFlower() {
    // TODO
  }

  public void meetMonster() {
    // TODO
  }
}
