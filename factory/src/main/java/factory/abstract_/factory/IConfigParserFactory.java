package factory.abstract_.factory;

import factory.abstract_.parser.IRuleConfigParser;
import factory.abstract_.parser.ISystemConfigParser;

/**
 * 一个工厂负责创建多个不同类 型的对象（IRuleConfigParser、ISystemConfigParser 等），
 * 而不是只创建一种 parser 对象。这样就可以有效地减少工厂类的个数。
 *
 * @author ImOkkkk
 * @date 2022/7/26 21:50
 * @since 1.0
 */
public interface IConfigParserFactory {
  IRuleConfigParser createRuleParser();

  ISystemConfigParser createSystemParser();
  // 此处可以扩展新的parser类型，比如IBizConfigParser
}
