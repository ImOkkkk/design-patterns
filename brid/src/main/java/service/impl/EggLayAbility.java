package service.impl;

import service.EggLayable;

/**
 * 接口只声明方法，不定义实现。也就是说，每个会下蛋的鸟都要实现一遍layEgg() 方法，并且实现逻辑是一样的，导致代码重复
 * 针对三个接口再定义三个实现类，通过组合和委托技术来消除代码重复
 * @author ImOkkkk
 * @date 2022/6/2 14:50
 * @since 1.0
 */
public class EggLayAbility implements EggLayable {

  @Override
  public void layEgg() {
    System.out.println("layEgg...");
  }
}
