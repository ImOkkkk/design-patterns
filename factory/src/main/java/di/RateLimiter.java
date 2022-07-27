package di;

/**
 * @author ImOkkkk
 * @date 2022/7/26 22:17
 * @since 1.0
 */
public class RateLimiter {
  private RedisCounter redisCounter;

  public RateLimiter(RedisCounter redisCounter) {
    this.redisCounter = redisCounter;
  }

  public void test() {
    System.out.println("Hello World!");
  }
}
