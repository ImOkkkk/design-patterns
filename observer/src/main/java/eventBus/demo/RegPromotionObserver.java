package eventBus.demo;

import eventBus.annoations.Subscribe;
import p2p.service.PromotionService;

/**
 * @author ImOkkkk
 * @date 2022/8/11 11:19
 * @since 1.0
 */
public class RegPromotionObserver {
  private PromotionService promotionService; // 依赖注入

  public RegPromotionObserver(PromotionService promotionService) {
    this.promotionService = promotionService;
  }

  @Subscribe
  public void handleRegSuccess(Long userId) {
    promotionService.issueNewUserExperienceCash(userId);
  }

}
