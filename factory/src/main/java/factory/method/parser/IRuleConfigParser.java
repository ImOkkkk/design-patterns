package factory.method.parser;

import factory.method.RuleConfig;

/**
 * @author ImOkkkk
 * @date 2022/7/26 16:55
 * @since 1.in
 */
public interface IRuleConfigParser {
  RuleConfig parse(String str);
}
