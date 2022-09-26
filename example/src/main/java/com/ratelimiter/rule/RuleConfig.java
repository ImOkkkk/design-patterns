package com.ratelimiter.rule;

import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/9/23 14:59
 * @since 1.0
 */
public class RuleConfig {
  private List<AppRuleConfig> configs;

  public List<AppRuleConfig> getConfigs() {
    return configs;
  }

  public void setConfigs(List<AppRuleConfig> configs) {
    this.configs = configs;
  }

  public static class AppRuleConfig {
    private String appId;
    private List<ApiLimit> limits;

    public AppRuleConfig() {}

    public AppRuleConfig(String appId, List<ApiLimit> limits) {
      this.appId = appId;
      this.limits = limits;
    }
  }
}
