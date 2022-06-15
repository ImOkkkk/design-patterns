package ioc.WithIOC;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里的控制指的是对程序流程的控制，反转指在使用框架之后，整个程序的执行流程可以通过框架来控制
 * @author ImOkkkk
 * @date 2022/6/15 21:27
 * @since 1.0
 */
public class JunitApplication {
  private static final List<TestCase> testCases = new ArrayList<>();

  public static void register(TestCase testCase){
    testCases.add(testCase);
  }

  public static void main(String[] args) {
    register(new UserServiceTest());
    for (TestCase testCase : testCases) {
      testCase.run();
    }
  }
}
