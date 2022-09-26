package com.ratelimiter.rule;

/**
 * @author ImOkkkk
 * @date 2022/9/23 15:00
 * @since 1.0
 */
public class TrieRateLimitRule implements RateLimitRule {

  public TrieRateLimitRule(RuleConfig ruleConfig) {
    // ...
  }

  @Override
  public ApiLimit getLimit(String appId, String api) {
    // ...
    return null;
  }
}
