package p2p.eventBus;

import com.google.common.eventbus.Subscribe;
import p2p.service.PromotionService;

/**
 * @author ImOkkkk
 * @date 2022/8/11 11:19
 * @since 1.0
 */
public class RegPromotionObserver {
  private PromotionService promotionService; // 依赖注入

  @Subscribe
  public void handleRegSuccess(long userId) {
    promotionService.issueNewUserExperienceCash(userId);
  }

}
