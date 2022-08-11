package template;

/**
 * @author ImOkkkk
 * @date 2022/8/11 10:54
 * @since 1.0
 */
public class ConcreteObserverTwo implements Observer{

  @Override
  public void update(Message message) {
    //TODO: 获取消息通知，执行自己的逻辑...
    System.out.println("ConcreteObserverTwo is notified.");
  }
}
