package ioc;

/**
 * 所有的流程都由程序来控制
 *
 * @author ImOkkkk
 * @date 2022/6/15 21:19
 * @since 1.0
 */
public class UserServiceTest {
  public static  boolean doTest(){
    return false;
  }

  public static void main(String[] args) {
    if(doTest()){
      System.out.println("Test succeed!");
    }else {
      System.out.println("Test failed!");
    }
  }
}
