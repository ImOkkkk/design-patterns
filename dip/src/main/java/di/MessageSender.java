package di;

/**
 * 把 MessageSender定义成接口，基于接口而非实现编程
 *
 * @author ImOkkkk
 * @date 2022/6/15 21:55
 * @since 1.0
 */
public interface MessageSender {
  void send(String phone, String message);
}
