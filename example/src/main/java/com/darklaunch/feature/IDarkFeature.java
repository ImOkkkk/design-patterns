package com.darklaunch.feature;

/**
 * @author ImOkkkk
 * @date 2022/10/9 11:38
 * @since 1.0
 */
public interface IDarkFeature {
  boolean enabled();
  boolean dark(long darkTarget);
  boolean dark(String darkTarget);

}
