package di;

/**
 * @author ImOkkkk
 * @date 2022/7/26 22:17
 * @since 1.0
 */
public class RedisCounter {
  private String ipAddress;
  private int port;

  public RedisCounter(String ipAddress, int port) {
    this.ipAddress = ipAddress;
    this.port = port;
  }
}
