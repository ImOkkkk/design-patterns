package ioc.WithIOC;

/**
 * 提供了一个可扩 展的代码骨架，用来组装对象、管理整个执行流程。
 *
 * @author ImOkkkk
 * @date 2022/6/15 21:24
 * @since 1.0
 */
public abstract class TestCase {
  public void run(){
    if(doTest()){
      System.out.println("Test succeed!");
    }else{
      System.out.println("Test failed!");
    }
  }

  public abstract boolean doTest();

}
