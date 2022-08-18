package s01;

import static s01.State.CAPE;
import static s01.State.FIRE;
import static s01.State.SMALL;
import static s01.State.SUPER;

/**
 * 第一维表示当前状态，第二维表示事件，值表示当前状态经过事件之后，转移到的新状态及其执行的动作。
 *
 * @author ImOkkkk
 * @date 2022/8/18 13:12
 * @since 1.0
 */
public class MarioStateMachine1 {

  private static final State[][] transitionTable = {
    {SUPER, CAPE, FIRE, SMALL},
    {SUPER, CAPE, FIRE, SMALL},
    {CAPE, CAPE, CAPE, SMALL},
    {FIRE, FIRE, FIRE, SMALL}
  };
  private static final int[][] actionTable = {
    {+100, +200, +300, +0},
    {+0, +200, +300, -100},
    {+0, +0, +0, -200},
    {+0, +0, +0, -300}
  };
  private int score;
  private State currentState;

  public MarioStateMachine1(int score, State currentState) {
    this.score = score;
    this.currentState = currentState;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public State getCurrentState() {
    return currentState;
  }

  public void setCurrentState(State currentState) {
    this.currentState = currentState;
  }

  // 修改状态机时，我们只需要修改 transitionTable 和 actionTable 两个二维数组即可
  private void executeEvent(Event event) {
    int stateValue = currentState.getValue();
    int eventValue = event.getValue();
    this.currentState = transitionTable[stateValue][eventValue];
    this.score = actionTable[stateValue][eventValue];
  }

  public void obtainMushRoom() {
    executeEvent(Event.GOT_MUSHROOM);
  }

  public void obtainCape() {
    executeEvent(Event.GOT_CAPE);
  }

  public void obtainFireFlower() {
    executeEvent(Event.GOT_FIRE);
  }

  public void meetMonster() {
    executeEvent(Event.MET_MONSTER);
  }
}
