package di.parser;

import di.config.BeanDefinition;
import java.io.InputStream;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/7/27 8:59
 * @since 1.0
 */
public interface BeanConfigParser {

  List<BeanDefinition> parse(InputStream inputStream);

  List<BeanDefinition> parse(String configContent);
}
