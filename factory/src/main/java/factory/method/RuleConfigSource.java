package factory.method;

import factory.method.factory.IRuleConfigParserFactory;
import factory.method.factory.JsonRuleConfigParserFactory;
import factory.method.factory.PropertiesRuleConfigParserFactory;
import factory.method.factory.RuleConfigParserFactoryMap;
import factory.method.factory.XmlRuleConfigParserFactory;
import factory.method.factory.YamlRuleConfigParserFactory;
import factory.method.parser.IRuleConfigParser;

/**
 * @author ImOkkkk
 * @date 2022/7/26 16:52
 * @since 1.0
 */
public class RuleConfigSource {
  private String getFileExtension(String filePath) {
    // ...解析文件名获取扩展名，比如rule.json，返回json
    return "json";
  }

  public RuleConfig load(String ruleConfigFilePath) {
    String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

    IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(
        ruleConfigFileExtension);
    if (parserFactory == null){
      throw new InvalidRuleConfigException("Rule config file format is not support!");
    }
    IRuleConfigParser parser = parserFactory.createParser();

//    IRuleConfigParserFactory parserFactory = null;
//    if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
//      parserFactory = new JsonRuleConfigParserFactory();
//    } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
//      parserFactory = new XmlRuleConfigParserFactory();
//    } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
//      parserFactory = new YamlRuleConfigParserFactory();
//    } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
//      parserFactory = new PropertiesRuleConfigParserFactory();
//    } else {
//      throw new InvalidRuleConfigException("Rule config file format is not support!");
//    }
//    IRuleConfigParser parser = parserFactory.createParser();

    String configText = "";
    RuleConfig ruleConfig = parser.parse(configText);
    return ruleConfig;
  }
}
