package refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/18 14:14
 * @since 1.0
 */
public class MarioStateMachine {
  private int score;
  private IMario currentState; // 不再使用枚举来表示状态

  public MarioStateMachine() {
    this.score = 0;
    this.currentState = SmallMario.getInstance();
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public IMario getCurrentState() {
    return currentState;
  }

  public void setCurrentState(IMario currentState) {
    this.currentState = currentState;
  }

  public void obtainMushRoom() {
    this.currentState.obtainMushRoom(this);
  }
  public void obtainCape() {
    this.currentState.obtainCape(this);
  }
  public void obtainFireFlower() {
    this.currentState.obtainFireFlower(this);
  }
  public void meetMonster() {
    this.currentState.meetMonster(this);
  }

}
