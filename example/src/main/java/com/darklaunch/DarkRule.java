package com.darklaunch;

import com.darklaunch.feature.IDarkFeature;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ImOkkkk
 * @date 2022/10/9 11:04
 * @since 1.0 包含所有要灰度的业务功能的灰度规则。它用来支持 根据业务功能标识（feature key）， * 快速查询灰度规则（DarkFeature）
 */
public class DarkRule {

  // 从配置文件中加载的灰度规则
  private Map<String, IDarkFeature> darkFeatures = new HashMap<>();

  // 编程实现的灰度规则
  private ConcurrentHashMap<String, IDarkFeature> programmedDarkFeatures =
      new ConcurrentHashMap<>();

  public void addProgrammedDarkFeature(String featureKey, IDarkFeature darkFeature) {
    programmedDarkFeatures.put(featureKey, darkFeature);
  }

  public void setDarkFeatures(Map<String, IDarkFeature> newDarkFeatures) {
    this.darkFeatures = newDarkFeatures;
  }

  public IDarkFeature getDarkFeature(String featureKey) {
    IDarkFeature darkFeature = programmedDarkFeatures.get(featureKey);
    if (darkFeature != null) {
      return darkFeature;
    }
    return darkFeatures.get(featureKey);
  }
}
