package com.darklaunch.feature.parser;

import com.darklaunch.DarkRuleConfig.DarkFeatureConfig;

/**
 * @author ImOkkkk
 * @date 2022/10/9 14:17
 * @since 1.0
 */
public class PercentDarkFeature extends AbstractDarkFeature {

  public PercentDarkFeature(DarkFeatureConfig darkFeatureConfig) {
    super(darkFeatureConfig);
  }

  @Override
  public void parse(String rule) {
    int newPercentage = Integer.parseInt(rule.substring(1));
    if (newPercentage > super.percentage) {
      super.percentage = newPercentage;
    }
  }
}
