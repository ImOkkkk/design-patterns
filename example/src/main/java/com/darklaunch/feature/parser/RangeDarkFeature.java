package com.darklaunch.feature.parser;

import com.darklaunch.DarkRuleConfig.DarkFeatureConfig;
import com.google.common.collect.Range;

/**
 * @author ImOkkkk
 * @date 2022/10/9 14:06
 * @since 1.0
 */
public class RangeDarkFeature extends AbstractDarkFeature {

  public RangeDarkFeature(DarkFeatureConfig darkFeatureConfig) {
    super(darkFeatureConfig);
  }

  @Override
  public void parse(String rule) {
    if (rule.contains("-")) {
      String[] parts = rule.split("-");
      if (parts.length != 2) {
        throw new RuntimeException("Failed to parse dark rule: " + rule);
      }
      long start = Long.parseLong(parts[0]);
      long end = Long.parseLong(parts[1]);
      if (start > end) {
        throw new RuntimeException("Failed to parse dark rule: " + rule);
      }
      super.rangeSet.add(Range.closed(start, end));
    }
  }
}
