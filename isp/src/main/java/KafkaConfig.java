/**
 * 希望支持 Redis 和 Kafka 配置信息的热更新。所谓“热更新（hot update）”就是，如果在配置中心中更改了配置信息，我们希望在不用重启系
 * 统的情况下，能将最新的配置信息加载到内存中（也就是 RedisConfig、KafkaConfig类中）。但是，因为某些原因，我们并不希望对 MySQL 的配置信息进行热更新。
 *
 * @author ImOkkkk
 * @date 2022/6/12 21:46
 * @since 1.0
 */
public class KafkaConfig implements Updater {
  private ConfigSource configSource;

  public KafkaConfig(ConfigSource configSource) {
    this.configSource = configSource;
  }

  @Override
  public void update() {

  }
}
