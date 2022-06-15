package di;


/**
 * @author ImOkkkk
 * @date 2022/6/15 22:03
 * @since 1.0
 */
public class Main {
  public static void main(String[] args) {
    MessageSender messageSender = new SmsSender();
    Notification notification = new Notification(messageSender);
    notification.sendMessage("", "");

  }
}
