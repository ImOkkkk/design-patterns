import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程唯一单例
 * @author ImOkkkk
 * @date 2022/7/25 14:35
 * @since 1.0
 */
public class IdGeneratorThread {
  private static final ConcurrentHashMap<Long, IdGeneratorThread> instances =
      new ConcurrentHashMap<>();
  private AtomicLong id = new AtomicLong(0);

  private IdGeneratorThread() {}

  public static IdGeneratorThread getInstance() {
    long currentThreadId = Thread.currentThread().getId();
    instances.putIfAbsent(currentThreadId, new IdGeneratorThread());
    return instances.get(currentThreadId);
  }
  public long getId() {
    return id.incrementAndGet();
  }
}
