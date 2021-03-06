package factory.simple;

import factory.method.InvalidRuleConfigException;
import factory.method.RuleConfig;
import factory.method.parser.IRuleConfigParser;

/**
 * 简单工厂模式
 * @author ImOkkkk
 * @date 2022/7/26 21:21
 * @since 1.0
 */
public class RuleConfigSource {
  public RuleConfig load(String ruleConfigFilePath) {
    String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
    IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
    if (parser == null) {
      throw new InvalidRuleConfigException("Rule config file format is not support!");
    }
    String configText = "";
    // 从ruleConfigFilePath文件中读取配置文本到configText中
    RuleConfig ruleConfig = parser.parse(configText);
    return ruleConfig;
  }

  private String getFileExtension(String filePath) {
    // ...解析文件名获取扩展名，比如rule.json，返回json
    return "json";
  }
}
