package factory.abstract_.factory;

import factory.abstract_.parser.IRuleConfigParser;
import factory.abstract_.parser.ISystemConfigParser;
import factory.abstract_.parser.JsonRuleConfigParser;
import factory.abstract_.parser.JsonSystemConfigParser;

/**
 * @author ImOkkkk
 * @date 2022/7/26 21:53
 * @since 1.0
 */
public class JsonConfigParserFactory implements IConfigParserFactory{

  @Override
  public IRuleConfigParser createRuleParser() {
    return new JsonRuleConfigParser();
  }

  @Override
  public ISystemConfigParser createSystemParser() {
    return new JsonSystemConfigParser();
  }
}
