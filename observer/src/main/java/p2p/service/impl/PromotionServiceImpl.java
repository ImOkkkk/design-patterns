package p2p.service.impl;

import p2p.service.PromotionService;

/**
 * @author ImOkkkk
 * @date 2022/8/11 13:55
 * @since 1.0
 */
public class PromotionServiceImpl implements PromotionService {

  @Override
  public void issueNewUserExperienceCash(Long userId) {
    System.out.println(Thread.currentThread().getName() + ": issue new user experience cash to " + userId);
  }
}
