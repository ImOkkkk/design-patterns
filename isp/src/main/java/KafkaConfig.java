/**
 * @author ImOkkkk
 * @date 2022/6/12 21:46
 * @since 1.0
 */
public class KafkaConfig implements Updater{
  private ConfigSource configSource;

  public KafkaConfig(ConfigSource configSource) {
    this.configSource = configSource;
  }

  @Override
  public void update() {

  }
}
