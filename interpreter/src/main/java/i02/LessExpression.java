package i02;

import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/8/29 15:29
 * @since 1.0
 */
public class LessExpression implements Expression{
  private String key;
  private long value;

  public LessExpression(String key, long value) {
    this.key = key;
    this.value = value;
  }

  public LessExpression(String strExpression) {
    String[] elements = strExpression.trim().split("\\s+");
    if (elements.length != 3 || !elements[1].trim().equals("<")) {
      throw new RuntimeException("Expression is invalid: " + strExpression);
    }
    this.key = elements[0].trim();
    this.value = Long.parseLong(elements[2].trim());
  }



  @Override
  public boolean interpret(Map<String, Long> stats) {
    if(!stats.containsKey(key)){
      return false;
    }
    long statValue = stats.get(key);
    return statValue < value;
  }
}
