import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发一个内嵌的 SimpleHttpServer，输出项目的配置信息到一个固定的 HTTP 地址，比如：http://127.0.0.1:2389/config
 * 。我们只需要在浏览器中输入这个地 址，就可以显示出系统的配置信息。不过，出于某些原因，我们只想暴露 MySQL 和 Redis 的配置信息，不想暴露 Kafka 的配置信息。
 *
 * @author ImOkkkk
 * @date 2022/6/12 21:57
 * @since 1.0
 */
public class SimpleHttpServer {
  private String host;
  private int port;
  private Map<String, List<Viewer>> viewers = new HashMap<>();

  public SimpleHttpServer(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public void addViewers(String urlDirectory, Viewer viewer) {
    if (!viewers.containsKey(urlDirectory)) {
      viewers.put(urlDirectory, new ArrayList<Viewer>());
    }
    viewers.get(urlDirectory).add(viewer);
  }

  public void run() {}
}
