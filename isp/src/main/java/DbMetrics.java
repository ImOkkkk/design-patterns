import java.util.Map;

/**
 * 开发一个 Metrics 性能统计模块，并且希望将 Metrics 也通过 SimpleHttpServer 显示在网页上
 *
 * @author ImOkkkk
 * @date 2022/6/12 22:04
 * @since 1.0
 */
public class DbMetrics implements Viewer {

  @Override
  public String outputInPlainText() {
    return null;
  }

  @Override
  public Map<String, String> output() {
    return null;
  }
}
