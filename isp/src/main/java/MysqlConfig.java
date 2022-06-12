import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/6/12 21:45
 * @since 1.0
 */
public class MysqlConfig implements Viewer{
  private ConfigSource configSource;


  public MysqlConfig(ConfigSource configSource) {
    this.configSource = configSource;
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
