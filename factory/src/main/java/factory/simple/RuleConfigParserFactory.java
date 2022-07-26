package factory.simple;

import factory.method.parser.IRuleConfigParser;
import factory.method.parser.JsonRuleConfigParser;
import factory.method.parser.PropertiesRuleConfigParser;
import factory.method.parser.XmlRuleConfigParser;
import factory.method.parser.YamlRuleConfigParser;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/7/26 21:22
 * @since 1.0
 */
public class RuleConfigParserFactory {
  private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

  static {
    cachedParsers.put("json", new JsonRuleConfigParser());
    cachedParsers.put("xml", new XmlRuleConfigParser());
    cachedParsers.put("yaml", new YamlRuleConfigParser());
    cachedParsers.put("properties", new PropertiesRuleConfigParser());
  }

  public static IRuleConfigParser createParser(String configFormat) {
    if (configFormat == null || configFormat.isEmpty()) {
      return null;
    }
    IRuleConfigParser parser = cachedParsers.get(configFormat);
    return parser;
  }
}
