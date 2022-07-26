package factory.method.factory;

import factory.method.parser.IRuleConfigParser;

/**
 * 新增一种 parser 的时候，只需要新增一个实现了 IRuleConfigParserFactory
 * 接口的 Factory 类即可。所以，工厂方法模式比起简单工厂模式更加符合开闭原则。
 *
 * @author ImOkkkk
 * @date 2022/7/26 16:54
 * @since 1.0
 */
public interface IRuleConfigParserFactory {
  IRuleConfigParser createParser();
}
