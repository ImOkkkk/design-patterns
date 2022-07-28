import config.ResourcePoolConfig;
import config.ResourcePoolConfig.Builder;

/**
 * @author ImOkkkk
 * @date 2022/7/27 9:58
 * @since 1.0
 */
public class Main {
  public static void main(String[] args) {
    ResourcePoolConfig config =
        new Builder()
            .setName("dbconnectionpool")
            .setMaxTotal(16)
            .setMaxIdle(10)
            .setMinIdle(12)
            .build();
  }
}
