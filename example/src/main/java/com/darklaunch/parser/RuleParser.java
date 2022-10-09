package com.darklaunch.parser;

import com.darklaunch.DarkRuleConfig;
import java.io.InputStream;

/**
 * @author ImOkkkk
 * @date 2022/10/9 13:10
 * @since 1.0
 */
public interface RuleParser {

  public DarkRuleConfig loadRule(InputStream in);
}
