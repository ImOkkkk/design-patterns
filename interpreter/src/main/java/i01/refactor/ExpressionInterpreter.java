package i01.refactor;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ImOkkkk
 * @date 2022/8/29 15:20
 * @since 1.0
 */
public class ExpressionInterpreter {
  private Deque<Expression> numbers = new LinkedList<>();

  public long interpret(String expression) {
    String[] elements = expression.split(" ");
    int length = elements.length;
    for (int i = 0; i < (length + 1) / 2; i++) {
      numbers.addLast(new NumberExpression(elements[i]));
    }

    for (int i = (length + 1) / 2; i < length; i++) {
      String operator = elements[i];
      boolean isValid =
          "+".equals(operator)
              || "-".equals(operator)
              || "*".equals(operator)
              || "/".equals(operator);
      if (!isValid) {
        throw new RuntimeException("Expression is invalid: " + expression);
      }
      Expression exp1 = numbers.pollFirst();
      Expression exp2 = numbers.pollFirst();
      Expression combinedExp = null;
      if (operator.equals("+")) {
        combinedExp = new AdditionExpression(exp1, exp2);
      } else if (operator.equals("-")) {
        combinedExp = new SubstractionExpression(exp1, exp2);
      } else if (operator.equals("*")) {
        combinedExp = new MultiplicationExpression(exp1, exp2);
      } else if (operator.equals("/")) {
        combinedExp = new DivisionExpression(exp1, exp2);
      }
      long result = combinedExp.interpret();
      numbers.addFirst(new NumberExpression(result));
    }
    if (numbers.size() != 1) {
      throw new RuntimeException("Expression is invalid: " + expression);
    }
    return numbers.pop().interpret();
  }

  public static void main(String[] args) {
    ExpressionInterpreter expressionInterpreter = new ExpressionInterpreter();
    long interpret = expressionInterpreter.interpret("8 3 2 4 - + *");
    System.out.println(interpret);
  }
}
