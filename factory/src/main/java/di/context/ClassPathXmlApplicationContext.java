package di.context;

import di.config.BeanDefinition;
import di.factory.BeansFactory;
import di.parser.BeanConfigParser;
import di.parser.XmlBeanConfigParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/7/26 22:20
 * @since 1.0
 */
public class ClassPathXmlApplicationContext implements ApplicationContext{

  private BeansFactory beansFactory;
  private BeanConfigParser beanConfigParser;

  public ClassPathXmlApplicationContext(String configLocation){
    this.beansFactory = new BeansFactory();
    this.beanConfigParser = new XmlBeanConfigParser();

  }

  private void loadBeanDefinitions(String configLocation){
    InputStream in = null;
    try{
      in = this.getClass().getResourceAsStream("/" + configLocation);
      if(in == null){
        throw new RuntimeException("Can not find config file: " + configLocation);
      }
      List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
      beansFactory.addBeanDefinitions(beanDefinitions);
    }finally{
      if(in != null){
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  @Override
  public Object getBean(String beanId) {
    return beansFactory.getBean(beanId);
  }
}
