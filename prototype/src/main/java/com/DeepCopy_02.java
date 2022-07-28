package com;

import java.util.HashMap;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/7/28 15:00
 * @since 1.0
 */
public class DeepCopy_02 {

  private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
  private long lastUpdateTime = -1;

  private List<SearchWord> getSearchWords(long lastUpdateTime) {
    // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
    return null;
  }

  // 先采用浅拷贝的方式创建 newKeywords。对于需要更新的 SearchWord 对象，再使用深度拷贝的方式创建一份新的对象，替换 newKeywords 中的老对象。
  public void refresh() {
    //Shallow copy
    HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();
    List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
    long maxNewUpdatedTime = lastUpdateTime;
    for (SearchWord searchWord : toBeUpdatedSearchWords) {
      if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
        maxNewUpdatedTime = searchWord.getLastUpdateTime();
      }
      if (newKeywords.containsKey(searchWord.getKeyWord())) {
        newKeywords.remove(searchWord.getKeyWord());
      }
      newKeywords.put(searchWord.getKeyWord(), searchWord);
    }
    lastUpdateTime = maxNewUpdatedTime;
    currentKeywords = newKeywords;
  }
}
