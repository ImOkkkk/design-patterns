package refactor;

import s01.State;

/**
 * @author ImOkkkk
 * @date 2022/8/18 14:13
 * @since 1.0
 */
public class SmallMario implements IMario {
  private static final SmallMario instance = new SmallMario();
  private SmallMario() {}
  public static SmallMario getInstance() {
    return instance;
  }

  @Override
  public State getName() {
    return State.SMALL;
  }

  @Override
  public void obtainMushRoom(MarioStateMachine stateMachine) {
    stateMachine.setCurrentState(SuperMario.getInstance());
    stateMachine.setScore(stateMachine.getScore() + 100);
  }

  @Override
  public void obtainCape(MarioStateMachine stateMachine) {}

  @Override
  public void obtainFireFlower(MarioStateMachine stateMachine) {}

  @Override
  public void meetMonster(MarioStateMachine stateMachine) {}
}
