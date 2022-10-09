package com.darklaunch;

import com.darklaunch.DarkRuleConfig.DarkFeatureConfig;
import com.darklaunch.dataSource.FileRuleConfigSource;
import com.darklaunch.dataSource.RuleConfigSource;
import com.darklaunch.feature.DarkFeature;
import com.darklaunch.feature.IDarkFeature;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ImOkkkk
 * @date 2022/10/9 11:04
 * @since 1.0 灰度组件的最顶层入口类。它用来组装其他类对 象，串联整个操作流程，提供外部调用的接口。
 */
public class DarkLaunch {
  private static final int DEFAULT_RULE_UPDATE_TIME_INTERVAL = 60;

  private DarkRule rule = new DarkRule();
  private ScheduledExecutorService executor;

  public DarkLaunch(int ruleUpdateTimeInterval) {
    loadRule();
    this.executor = Executors.newSingleThreadScheduledExecutor();
    this.executor.scheduleAtFixedRate(
        new Runnable() {
          @Override
          public void run() {
            loadRule();
          }
        },
        ruleUpdateTimeInterval,
        ruleUpdateTimeInterval,
        TimeUnit.SECONDS);
  }

  public DarkLaunch() {
    this(DEFAULT_RULE_UPDATE_TIME_INTERVAL);
  }

  private void loadRule() {
    RuleConfigSource ruleConfigSource = new FileRuleConfigSource();
    DarkRuleConfig ruleConfig = ruleConfigSource.load();
    // 更新规则并非直接在this.rule上进行，
    // 而是通过创建一个新的DarkRule，然后赋值给this.rule，
    // 来避免更新规则和规则查询的并发冲突问题
    Map<String, IDarkFeature> darkFeatures = new HashMap<>();
    List<DarkFeatureConfig> darkFeatureConfigs = ruleConfig.getFeatures();
    for (DarkFeatureConfig darkFeatureConfig : darkFeatureConfigs) {
      darkFeatures.put(darkFeatureConfig.getKey(), new DarkFeature(darkFeatureConfig));
    }
    this.rule.setDarkFeatures(darkFeatures);
  }
  // 新增：添加编程实现的灰度规则的接口
  public void addProgrammedDarkFeature(String featureKey, IDarkFeature darkFeature) {
    this.rule.addProgrammedDarkFeature(featureKey, darkFeature);
  }

  public IDarkFeature getDarkFeature(String featureKey) {
    IDarkFeature darkFeature = this.rule.getDarkFeature(featureKey);
    return darkFeature;
  }
}
