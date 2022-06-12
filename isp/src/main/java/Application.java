/**
 * @author ImOkkkk
 * @date 2022/6/12 21:51
 * @since 1.0
 */
public class Application {

  private static ConfigSource configSource = new ZookeeperConfigSource();

  public static final RedisConfig redisConfig = new RedisConfig(configSource);
  public static final MysqlConfig mysqlConfig = new MysqlConfig(configSource);
  public static final KafkaConfig kafkaConfig = new KafkaConfig(configSource);
  public static final ApiMetrics apiMetrics = new ApiMetrics();
  public static final DbMetrics dbMetrics = new DbMetrics();

  public static void main(String[] args) {
    ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(300, 300, redisConfig);
    redisConfigUpdater.run();
    ScheduledUpdater kafkaConfigUpdater = new ScheduledUpdater(60, 60, kafkaConfig);
    kafkaConfigUpdater.run();

    SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1", 6324);
    simpleHttpServer.addViewers("/config", redisConfig);
    simpleHttpServer.addViewers("/config", mysqlConfig);
    simpleHttpServer.addViewers("/metrics", apiMetrics);
    simpleHttpServer.addViewers("/metrics", dbMetrics);
  }
}
