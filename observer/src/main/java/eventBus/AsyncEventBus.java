package eventBus;

import java.util.concurrent.Executor;

/**
 * @author ImOkkkk
 * @date 2022/8/11 13:46
 * @since 1.0
 */
public class AsyncEventBus extends EventBus{

  public AsyncEventBus(Executor executor){
    super(executor);
  }

}
