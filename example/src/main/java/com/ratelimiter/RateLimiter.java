package com.ratelimiter;

import com.ratelimiter.alg.RateLimitAlg;
import com.ratelimiter.alg.RateLimitAlgFactory;
import com.ratelimiter.datasource.FileRuleConfigSource;
import com.ratelimiter.datasource.RuleConfigSource;
import com.ratelimiter.rule.ApiLimit;
import com.ratelimiter.rule.RuleConfig;
import com.ratelimiter.rule.TrieRateLimitRule;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ImOkkkk
 * @date 2022/9/23 14:57
 * @since 1.0
 */
public class RateLimiter {

  // 为每个api在内存中存储限流计数器
  private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
  private TrieRateLimitRule rule;

  public RateLimiter() {
    // 调用RuleConfigSource类来实现配置加载
    RuleConfigSource configSource = new FileRuleConfigSource();
    RuleConfig ruleConfig = configSource.load();
    // 将限流规则构建成支持快速查找的数据结构RateLimitRule
    this.rule = new TrieRateLimitRule(ruleConfig);
  }

  public boolean limit(String appId, String url, String limitType) throws Exception {
    ApiLimit apiLimit = rule.getLimit(appId, url);
    if (apiLimit == null) {
      return true;
    }
    // 获取api对应在内存中的限流计数器（rateLimitCounter）
    String counterKey = appId + ":" + apiLimit.getApi();
    RateLimitAlg rateLimitCounter = counters.get(counterKey);
    if (rateLimitCounter == null) {
      RateLimitAlg rateLimitAlg =
          RateLimitAlgFactory.getRateLimitAlg(apiLimit.getLimit(), limitType);
      rateLimitCounter = counters.putIfAbsent(counterKey, rateLimitAlg);
      if (rateLimitCounter == null) {
        rateLimitCounter = rateLimitAlg;
      }
    }
    // 判断是否限流
    return rateLimitCounter.tryAcquire();
  }
}
