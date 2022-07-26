package factory.method.factory;

import factory.method.parser.IRuleConfigParser;
import factory.method.parser.JsonRuleConfigParser;
import factory.method.parser.PropertiesRuleConfigParser;

/**
 * @author ImOkkkk
 * @date 2022/7/26 16:54
 * @since 1.0
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory{

  @Override
  public IRuleConfigParser createParser() {
    return new PropertiesRuleConfigParser();
  }
}
