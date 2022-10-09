package com.darklaunch.dataSource;

import com.darklaunch.DarkRuleConfig;
import com.ratelimiter.common.Yaml;
import com.ratelimiter.parser.JsonRuleConfigParser;
import com.ratelimiter.parser.RuleConfigParser;
import com.ratelimiter.parser.YamlRuleConfigParser;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/9/23 17:14
 * @since 1.0
 */
public class FileRuleConfigSource implements RuleConfigSource {
  public static final String DARK_LAUNCH_CONFIG_NAME = "dark-rule";
  public static final String YAML_EXTENSION = "yaml";
  public static final String YML_EXTENSION = "yml";
  public static final String JSON_EXTENSION = "json";
  private static final Logger log = LoggerFactory.getLogger(FileRuleConfigSource.class);
  private static final String[] SUPPORT_EXTENSIONS =
      new String[] {YAML_EXTENSION, YML_EXTENSION, JSON_EXTENSION};

  private static final Map<String, RuleConfigParser> PARSER_MAP = new HashMap<>();

  static {
    PARSER_MAP.put(YAML_EXTENSION, new YamlRuleConfigParser());
    PARSER_MAP.put(YML_EXTENSION, new YamlRuleConfigParser());
    PARSER_MAP.put(JSON_EXTENSION, new JsonRuleConfigParser());
  }

  @Override
  public DarkRuleConfig load() {
    for (String extension : SUPPORT_EXTENSIONS) {
      // 将灰度规则配置文件dark-rule.yaml中的内容读取DarkRuleConfig中
      InputStream in = null;
      DarkRuleConfig ruleConfig = null;
      try {
        in = this.getClass().getClassLoader().getResourceAsStream(getFileNameByExt(extension));
        if (in != null) {
          Yaml yaml = new Yaml();
          ruleConfig = yaml.loadAs(in, DarkRuleConfig.class);
        }
      } finally {
        if (in != null) {
          try {
            in.close();
          } catch (IOException e) {
            log.error("close file error:{}", e);
          }
        }
      }
      if (ruleConfig == null) {
        throw new RuntimeException("Can not load dark rule.");
      }
      return ruleConfig;
    }
    return null;
  }

  private String getFileNameByExt(String extension) {
    return DARK_LAUNCH_CONFIG_NAME + "." + extension;
  }
}
