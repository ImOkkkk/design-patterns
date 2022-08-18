package refactor;

import s01.State;

/**
 * 所有状态类的接口
 *
 * @author ImOkkkk
 * @date 2022/8/18 14:13
 * @since 1.0
 */
public interface IMario {

  State getName();
  //以下是定义的事件
  void obtainMushRoom(MarioStateMachine stateMachine);
  void obtainCape(MarioStateMachine stateMachine);
  void obtainFireFlower(MarioStateMachine stateMachine);
  void meetMonster(MarioStateMachine stateMachine);

}
