package com.ratelimiter.rule;

/**
 * @author ImOkkkk
 * @date 2022/9/23 17:11
 * @since 1.0
 */
public interface RateLimitRule {

  ApiLimit getLimit(String appId, String api);

}
