package i02;

import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/8/29 15:36
 * @since 1.0
 */
public class AlertRuleInterpreter {

  private Expression expression;

  public AlertRuleInterpreter(String ruleExpression) {
    this.expression = new OrExpression(ruleExpression);
  }

  public boolean interpret(Map<String, Long> stats) {
    return expression.interpret(stats);
  }
}
