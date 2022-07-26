import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重检查锁
 * @author ImOkkkk
 * @date 2022/7/25 13:37
 * @since 1.0
 */
public class IdGeneratorDoubleCheck {
  private AtomicLong id = new AtomicLong(0);
  // 禁止指令重排序
  private static volatile IdGeneratorDoubleCheck instance;
  private IdGeneratorDoubleCheck(){

  }
  public static IdGeneratorDoubleCheck getInstance(){
    if(instance == null){
      // 只要instance被创建之后，即便再调用getInstance()不会再进入到加锁的逻辑
      synchronized (IdGeneratorDoubleCheck.class){
        if (instance == null){
          instance = new IdGeneratorDoubleCheck();
        }
      }
    }
    return instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
