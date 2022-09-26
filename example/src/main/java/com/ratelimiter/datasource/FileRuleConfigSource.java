package com.ratelimiter.datasource;

import com.ratelimiter.parser.JsonRuleConfigParser;
import com.ratelimiter.parser.RuleConfigParser;
import com.ratelimiter.parser.YamlRuleConfigParser;
import com.ratelimiter.rule.RuleConfig;
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

  public static final String API_LIMIT_CONFIG_NAME = "ratelimiter-rule";
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
  public RuleConfig load() {
    for (String extension : SUPPORT_EXTENSIONS) {
      InputStream in = null;
      try {
        in = this.getClass().getResourceAsStream("/" + getFileNameByExt(extension));
        if (in != null) {
          RuleConfigParser parser = PARSER_MAP.get(extension);
          return parser.parse(in);
        }
      } finally {
        try {
          in.close();
        } catch (IOException e) {
          log.error("close file error:{}", e);
        }
      }
    }
    return null;
  }

  private String getFileNameByExt(String extension) {
    return API_LIMIT_CONFIG_NAME + "." + extension;
  }
}
