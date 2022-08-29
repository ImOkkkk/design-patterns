package i01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 运算符只包含加、减、乘、除，并且没有优先级的概念； 表达式中，先书写数字，后书写运算符，空格隔开； 按照先后顺序，取出两个数字和一个运算符计算结果，结果重新放入数字的最头部位
 * 置，循环上述过程，直到只剩下一个数字，这个数字就是表达式最终的计算结果。
 *
 * @author ImOkkkk
 * @date 2022/8/29 15:07
 * @since 1.0
 */
public class ExpressionInterpreter {
  private Deque<Long> numbers = new LinkedList<>();

  public long interpret(String expression){
    String[] elements = expression.split(" ");
    int length = elements.length;
    for (int i = 0; i < (length + 1) / 2; i++) {
      numbers.addLast(Long.parseLong(elements[i]));
    }

    for (int i = (length + 1) / 2; i < length; i++) {
      String operator = elements[i];
      boolean isValid = "+".equals(operator) || "-".equals(operator)
          || "*".equals(operator) || "/".equals(operator);
      if (!isValid) {
        throw new RuntimeException("Expression is invalid: " + expression);
      }
      long number1 = numbers.pollFirst();
      long number2 = numbers.pollFirst();
      long result = 0;
      if (operator.equals("+")) {
        result = number1 + number2;
      } else if (operator.equals("-")) {
        result = number1 - number2;
      } else if (operator.equals("*")) {
        result = number1 * number2;
      } else if (operator.equals("/")) {
        result = number1 / number2;
      }
      numbers.addFirst(result);
    }
    if(numbers.size() != 1){
      throw new RuntimeException("Expression is invalid: " + expression);
    }
    return numbers.pop();
  }
}
