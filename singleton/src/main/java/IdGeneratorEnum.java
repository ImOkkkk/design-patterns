import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举
 * @author ImOkkkk
 * @date 2022/7/25 13:49
 * @since 1.0
 */
public enum IdGeneratorEnum {
  INSTANCE;
  private AtomicLong id = new AtomicLong(0);
  public long getId() {
    return id.incrementAndGet();
  }
}
