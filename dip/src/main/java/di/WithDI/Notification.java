package di.WithDI;

/**
 * 不通过new()的方式在类内部创建依赖对象，而是将依赖的类对象在外部创建好之后，通过构造函数、函数参数等方式传递(或注入)给类使用。
 * @author ImOkkkk
 * @date 2022/6/15 21:48
 * @since 1.0
 */
// 依赖注入实现方式
public class Notification {
  private MessageSender messageSender;

  public Notification(MessageSender messageSender) {
    this.messageSender = messageSender;
  }

  public void sendMessage(String phone, String message) {
    // ... 省略校验逻辑等...
    this.messageSender.send(phone, message);
  }
}
