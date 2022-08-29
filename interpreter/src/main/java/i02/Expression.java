package i02;

import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/8/29 15:27
 * @since 1.0
 */
public interface Expression {

  boolean interpret(Map<String, Long> stats);
}
