package callback;

/**
 * @author ImOkkkk
 * @date 2022/8/14 10:50
 * @since 1.0
 */
public class ShutdownHookDemo {
  private static class ShutdownHook extends Thread{

    @Override
    public void run() {
      System.out.println("I am called during shutting down.");
    }

    public static void main(String[] args) {
      Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }
  }

}
