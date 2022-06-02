package pojo;

/**
 * @author ImOkkkk
 * @date 2022/6/2 13:33
 * @since 1.0
 */
public class AlertRule {
  public final Long MAX_TPS = 1000L;
  public final Long MAX_ERROR = 100L;
  public final Long MAX_TIME_OUT = 100L;

  public Long getMAX_TPS() {
    return MAX_TPS;
  }

  public Long getMAX_ERROR() {
    return MAX_ERROR;
  }

  public Long getMAX_TIME_OUT() {
    return MAX_TIME_OUT;
  }

  public AlertRule getMatchedRule(String api){
    return new AlertRule();
  }
}
