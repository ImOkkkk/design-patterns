package com.brid.pojo;

import com.brid.service.EggLayable;
import com.brid.service.Tweetable;
import com.brid.service.impl.EggLayAbility;
import com.brid.service.impl.TweetAbility;

/**
 * 鸵鸟
 *
 * @author ImOkkkk
 * @date 2022/6/2 14:51
 * @since 1.0
 */
public class Ostrich implements EggLayable, Tweetable {
  // 组合
  private EggLayAbility eggLayAbility = new EggLayAbility();
  private TweetAbility tweetAbility = new TweetAbility();

  @Override
  public void layEgg() {
    eggLayAbility.layEgg(); // 委托
  }

  @Override
  public void tweet() {
    tweetAbility.tweet();
  }
}
