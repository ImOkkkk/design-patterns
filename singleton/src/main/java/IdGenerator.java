import java.util.concurrent.atomic.AtomicLong;

/**
 * 全局唯一类
 *
 * @author ImOkkkk
 * @date 2022/7/25 13:26
 * @since 1.0
 */
public class IdGenerator {
  // 饿汉式
  // 在类加载的时候，instance 静态实例就已经创建并初始化，不支持延迟加载
  private static final IdGenerator instance = new IdGenerator();
  private AtomicLong id = new AtomicLong(0);

  private IdGenerator() {}

  public static IdGenerator getInstance() {
    return instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
