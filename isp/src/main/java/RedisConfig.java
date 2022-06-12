import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/6/12 21:39
 * @since 1.0
 */
public class RedisConfig implements Updater, Viewer{
  private ConfigSource configSource;
  private String address;
  private int timeout;
  private int maxTotal;
  // 省略其他配置: maxWaitMillis,maxIdle,minIdle...

  public RedisConfig(ConfigSource configSource) {
    this.configSource = configSource;
  }

  public String getAddress() {
    return this.address;
  }

  @Override
  public void update() {

  }

  @Override
  public String outputInPlainText() {
    return null;
  }

  @Override
  public Map<String, String> output() {
    return null;
  }
}
