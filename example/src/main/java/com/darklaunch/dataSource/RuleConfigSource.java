package com.darklaunch.dataSource;

import com.darklaunch.DarkRuleConfig;

/**
 * @author ImOkkkk
 * @date 2022/9/23 17:14
 * @since 1.0
 */
public interface RuleConfigSource {

  DarkRuleConfig load();
}
