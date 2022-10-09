package com.darklaunch.feature.parser;

import com.darklaunch.DarkRuleConfig.DarkFeatureConfig;
import com.darklaunch.feature.IDarkFeature;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * @author ImOkkkk
 * @date 2022/10/9 11:04
 * @since 1.0
 *
 *
 * 抽象类实现？责任链？策略模式？哪种好一点的
 */
public abstract class AbstractDarkFeature implements IDarkFeature {
  protected int percentage;
  protected RangeSet<Long> rangeSet = TreeRangeSet.create();
  private String key;
  private boolean enabled;

  public AbstractDarkFeature(DarkFeatureConfig darkFeatureConfig) {
    this.key = darkFeatureConfig.getKey();
    this.enabled = darkFeatureConfig.isEnabled();
    String darkRule = darkFeatureConfig.getRule().trim();
    parseDarkRule(darkRule);
  }

  public abstract void parse(String rule);

  protected void parseDarkRule(String darkRule) {
    if (!darkRule.startsWith("{") || !darkRule.endsWith("}")) {
      throw new RuntimeException("Failed to parse dark rule: " + darkRule);
    }

    String[] rules = darkRule.substring(1, darkRule.length() - 1).split(",");
    this.rangeSet.clear();
    this.percentage = 0;
    for (String rule : rules) {
      parse(rule);
    }
  }

  public boolean enabled() {
    return this.enabled;
  }

  public boolean dark(long darkTarget) {
    boolean selected = this.rangeSet.contains(darkTarget);
    if (selected) {
      return true;
    }
    long reminder = darkTarget % 100;
    if (reminder >= 0 && reminder < this.percentage) {
      return true;
    }
    return false;
  }

  public boolean dark(String darkTarget) {
    long target = Long.parseLong(darkTarget);
    return dark(target);
  }
}
