package com.ratelimiter.parser;

import com.ratelimiter.rule.RuleConfig;
import java.io.InputStream;

/**
 * @author ImOkkkk
 * @date 2022/9/23 17:12
 * @since 1.0
 */
public interface RuleConfigParser {

  RuleConfig parse(String configText);

  RuleConfig parse(InputStream in);

}
