package di.WithDI;

/**
 * @author ImOkkkk
 * @date 2022/6/15 21:53
 * @since 1.0
 */
public class Main {
  public static void main(String[] args) {
    // 创建对象、组装（或注入）对象的工作仅仅是被移动到了更上层代码而已，还是需要自己来实现
    MessageSender messageSender = new MessageSender();
    Notification notification = new Notification(messageSender);
    notification.sendMessage("13918942177", " 短信验证码：2346");
  }
}
