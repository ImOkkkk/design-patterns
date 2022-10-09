package com.darklaunch.feature.parser;

import cn.hutool.core.util.NumberUtil;
import com.darklaunch.DarkRuleConfig.DarkFeatureConfig;
import com.google.common.collect.Range;

/**
 * @author ImOkkkk
 * @date 2022/10/9 14:06
 * @since 1.0
 */
public class AppointDarkFeature extends AbstractDarkFeature {

  public AppointDarkFeature(DarkFeatureConfig darkFeatureConfig) {
    super(darkFeatureConfig);
  }

  @Override
  public void parse(String rule) {
    if (NumberUtil.isNumber(rule)) {
      long val = Long.parseLong(rule);
      super.rangeSet.add(Range.closed(val, val));
    }
  }
}
