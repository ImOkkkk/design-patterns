package replace;

import replace.external.A;
import replace.external.B;

/**
 * @author ImOkkkk
 * @date 2022/8/2 13:57
 * @since 1.0
 */
public class Main {

  public static void main(String[] args) {
    Demo demo = new Demo(new A());

    //借助BAdaptor，Demo的代码中，调用IA接口的地方都无需改动
    //只需要将BAdaptor如下注入到Demo即可
    Demo demo2 = new Demo(new BAdaptor(new B()));
  }
}
