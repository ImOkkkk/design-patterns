package pojo;

import service.EggLayable;
import service.Flyable;
import service.Tweetable;
import service.impl.EggLayAbility;
import service.impl.FlyAbility;
import service.impl.TweetAbility;

/**
 * 麻雀
 *
 * @author ImOkkkk
 * @date 2022/6/2 14:54
 * @since 1.0
 */
public class Sparrow implements EggLayable, Flyable, Tweetable {
  // 组合
  private EggLayAbility eggLayAbility = new EggLayAbility();
  private TweetAbility tweetAbility = new TweetAbility();
  private FlyAbility flyAbility = new FlyAbility();

  @Override
  public void layEgg() {
    eggLayAbility.layEgg();
  }

  @Override
  public void fly() {
    flyAbility.fly();
  }

  @Override
  public void tweet() {
    tweetAbility.tweet();
  }
}
