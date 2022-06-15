import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 以固定时间频 率（periodInSeconds）来调用 RedisConfig、KafkaConfig 的 update() 方法更新配置信 息
 *
 * @author ImOkkkk
 * @date 2022/6/12 21:49
 * @since 1.0
 */
public class ScheduledUpdater {
  private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
  private long initialDelayInSeconds;
  private long periodInSeconds;
  private Updater updater;

  public ScheduledUpdater(long initialDelayInSeconds, long periodInSeconds, Updater updater) {
    this.initialDelayInSeconds = initialDelayInSeconds;
    this.periodInSeconds = periodInSeconds;
    this.updater = updater;
  }

  public void run() {
    executor.scheduleAtFixedRate(
        new Runnable() {
          @Override
          public void run() {
            updater.update();
          }
        },
        this.initialDelayInSeconds,
        this.periodInSeconds,
        TimeUnit.SECONDS);
  }
}
