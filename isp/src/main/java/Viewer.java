import java.util.Map;

/**
 * 只想暴露 MySQL 和 Redis 的配置信息，不想暴露 Kafka 的配置信息
 *
 * @author ImOkkkk
 * @date 2022/6/12 21:56
 * @since 1.0
 */
public interface Viewer {
  String outputInPlainText();

  Map<String, String> output();
}
