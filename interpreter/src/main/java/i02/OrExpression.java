package i02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/8/29 15:36
 * @since 1.0
 */
public class OrExpression implements Expression {

  private List<Expression> expressions = new ArrayList<>();

  public OrExpression(String strOrExpression) {
    String[] andExpressions = strOrExpression.split("\\|\\|");
    for (String andExpr : andExpressions) {
      expressions.add(new AndExpression(andExpr));
    }
  }

  public OrExpression(List<Expression> expressions) {
    this.expressions.addAll(expressions);
  }

  @Override
  public boolean interpret(Map<String, Long> stats) {
    for (Expression expr : expressions) {
      if (expr.interpret(stats)) {
        return true;
      }
    }
    return false;
  }
}
