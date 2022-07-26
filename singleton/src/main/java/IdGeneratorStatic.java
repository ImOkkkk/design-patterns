import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类
 *
 * @author ImOkkkk
 * @date 2022/7/25 13:43
 * @since 1.0
 */
public class IdGeneratorStatic {
  private AtomicLong id = new AtomicLong(0);

  private IdGeneratorStatic() {}

  public static IdGeneratorStatic getInstance() {
    return SingletonHolder.instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }

  // 静态内部类，当外部类IdGeneratorStatic被加载时，并不会创建Singleton实例对象，
  // 只有调用getInstance()方法时，SingletonHolder 才会被加载，这个时候才会创建 instance
  private static class SingletonHolder {
    private static final IdGeneratorStatic instance = new IdGeneratorStatic();
  }
}
