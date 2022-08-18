package refactor;

import s01.State;

/**
 * @author ImOkkkk
 * @date 2022/8/18 14:17
 * @since 1.0
 */
public class SuperMario implements IMario {
  private static final SuperMario instance = new SuperMario();
  private SuperMario(){

  }
  public static SuperMario getInstance(){
    return instance;
  }

  @Override
  public State getName() {
    return State.SUPER;
  }

  @Override
  public void obtainMushRoom(MarioStateMachine stateMachine) {}

  @Override
  public void obtainCape(MarioStateMachine stateMachine) {}

  @Override
  public void obtainFireFlower(MarioStateMachine stateMachine) {}

  @Override
  public void meetMonster(MarioStateMachine stateMachine) {
    stateMachine.setCurrentState(SmallMario.getInstance());
    stateMachine.setScore(stateMachine.getScore() - 100);
  }
}
