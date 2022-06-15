package di;

/**
 * @author ImOkkkk
 * @date 2022/6/15 22:06
 * @since 1.0
 */
public class Notification {
  private MessageSender messageSender;

  public Notification(MessageSender messageSender) {
    this.messageSender = messageSender;
  }
  public void sendMessage(String phone, String message){
    //... 省略校验逻辑等...
    this.messageSender.send(phone, message);
  }
}
