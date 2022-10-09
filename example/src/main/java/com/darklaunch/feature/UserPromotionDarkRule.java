package com.darklaunch.feature;

import com.darklaunch.feature.IDarkFeature;

/**
 * @author ImOkkkk
 * @date 2022/10/9 13:02
 * @since 1.0
 */
public class UserPromotionDarkRule implements IDarkFeature {

  @Override
  public boolean enabled() {
    return true;
  }

  @Override
  public boolean dark(long darkTarget) {
    //自定义灰度规则
    return false;
  }

  @Override
  public boolean dark(String darkTarget) {
    //自定义灰度规则
    return false;
  }
}
