package service.impl;

import service.Flyable;

/**
 * @author ImOkkkk
 * @date 2022/6/2 14:49
 * @since 1.0
 */
public class FlyAbility implements Flyable {

  @Override
  public void fly() {
    System.out.println("fly...");
  }
}
