package p2p.observer;

import p2p.service.PromotionService;

/**
 * @author ImOkkkk
 * @date 2022/8/11 10:59
 * @since 1.0
 */
public class RegPromotionObserver implements RegObserver{
  private PromotionService promotionService; // 依赖注入

  @Override
  public void handleRegSuccess(long userId) {
    // 异步非阻塞
    // 频繁地创建和销毁线程比较耗时，并且并发线程数无法控制，创建过多的线程会导致堆栈溢出。
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        promotionService.issueNewUserExperienceCash(userId);
      }
    });
    thread.start();
  }

//  @Override
//  public void handleRegSuccess(long userId) {
//    promotionService.issueNewUserExperienceCash(userId);
//  }
}
