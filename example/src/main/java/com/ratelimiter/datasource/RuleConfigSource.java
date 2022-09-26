package com.ratelimiter.datasource;

import com.ratelimiter.rule.RuleConfig;

/**
 * @author ImOkkkk
 * @date 2022/9/23 17:14
 * @since 1.0
 */
public interface RuleConfigSource {

  RuleConfig load();

}
