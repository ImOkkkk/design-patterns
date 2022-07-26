package factory.abstract_.factory;

import factory.abstract_.parser.IRuleConfigParser;
import factory.abstract_.parser.ISystemConfigParser;
import factory.abstract_.parser.XmlRuleConfigParser;
import factory.abstract_.parser.XmlSystemConfigParser;

/**
 * @author ImOkkkk
 * @date 2022/7/26 21:53
 * @since 1.0
 */
public class XmlConfigParserFactory implements IConfigParserFactory {

  @Override
  public IRuleConfigParser createRuleParser() {
    return new XmlRuleConfigParser();
  }

  @Override
  public ISystemConfigParser createSystemParser() {
    return new XmlSystemConfigParser();
  }
}
