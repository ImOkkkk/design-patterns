package di.parser;

import di.config.BeanDefinition;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/7/27 9:08
 * @since 1.0
 */
public class XmlBeanConfigParser implements BeanConfigParser{

  @Override
  public List<BeanDefinition> parse(InputStream inputStream) {
    String content = null;

    return parse(content);
  }

  @Override
  public List<BeanDefinition> parse(String configContent) {
    List<BeanDefinition> beanDefinitions = new ArrayList<>();

    return beanDefinitions;
  }
}
