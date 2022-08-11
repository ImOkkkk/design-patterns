package template;

/**
 * @author ImOkkkk
 * @date 2022/8/11 10:53
 * @since 1.0
 */
public class ConcreteObserverOne implements Observer{

  @Override
  public void update(Message message) {
    //TODO: 获取消息通知，执行自己的逻辑...
    System.out.println("ConcreteObserverOne is notified.");
  }
}
