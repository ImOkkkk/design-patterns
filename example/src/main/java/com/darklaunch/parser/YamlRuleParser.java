package com.darklaunch.parser;

import com.darklaunch.DarkRuleConfig;
import com.ratelimiter.common.Yaml;
import java.io.InputStream;

/**
 * @author ImOkkkk
 * @date 2022/10/9 13:12
 * @since 1.0
 */
public class YamlRuleParser implements RuleParser {

  @Override
  public DarkRuleConfig loadRule(InputStream in) {
    Yaml yaml = new Yaml();
    return yaml.loadAs(in, DarkRuleConfig.class);
  }
}
