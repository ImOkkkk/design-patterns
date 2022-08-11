package p2p.service;

/**
 * @author ImOkkkk
 * @date 2022/8/11 11:00
 * @since 1.0
 */
public interface NotificationService {

  void sendInboxMessage(Long userId, String message);
}
