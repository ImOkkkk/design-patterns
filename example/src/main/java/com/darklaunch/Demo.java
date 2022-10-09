package com.darklaunch;

import com.darklaunch.feature.IDarkFeature;
import com.darklaunch.feature.UserPromotionDarkRule;

/**
 * @author ImOkkkk
 * @date 2022/10/9 11:04
 * @since 1.0
 */
public class Demo {
  public static void main(String[] args) {
    //默认加载classpath下dark-rule.yaml
    DarkLaunch darkLaunch = new DarkLaunch();
    darkLaunch.addProgrammedDarkFeature("user_promotion", new UserPromotionDarkRule());
    IDarkFeature darkFeature = darkLaunch.getDarkFeature("user_promotion");
    System.out.println(darkFeature.enabled());
    System.out.println(darkFeature.dark(893));
  }
}
