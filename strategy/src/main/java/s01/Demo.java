package s01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:20
 * @since 1.0
 */
public class Demo {

  public static void main(String[] args) throws IOException {
    //运行时动态确定，根据配置文件的配置决定使用哪种策略
    Properties props = new Properties();
    props.load(new FileInputStream("./config.properties"));
    String type = props.getProperty("eviction_type");
    Strategy strategy = StrategyFactory.getStrategy(type);
  }

//  public static void main(String[] args) {
//  非运行时动态确定，在代码中指定使用哪种策略
//    Strategy strategy = new ConcreteStrategyA();
//  }
}
