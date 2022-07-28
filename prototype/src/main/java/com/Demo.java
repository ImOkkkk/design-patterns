package com;

import java.util.HashMap;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/7/28 13:15
 * @since 1.0
 */
public class Demo {
  private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
  private long lastUpdateTime = -1;

  private List<SearchWord> getSearchWords(long lastUpdateTime) {
    // 从数据库中取出更新时间>lastUpdatedTime
    return null;
  }

  public void refresh() {
    // 拷贝已有对象的数据，更新少量差值
    // 浅拷贝：只会拷贝对象中的基本数据类型的数据（比如，int、long），以及引用对象（SearchWord）的内存地址，不会递归地拷贝引用对象本身。
    // 在更新 newKeywords 的数据会导致 currentKeywords 的数据也被更新
    HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();
    List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
    long maxNewUpdatedTime = lastUpdateTime;
    for (SearchWord searchWord : toBeUpdatedSearchWords) {
      if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
        maxNewUpdatedTime = searchWord.getLastUpdateTime();
      }
      if (newKeywords.containsKey(searchWord.getKeyWord())) {
        SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyWord());
        oldSearchWord.setCount(searchWord.getCount());
        oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
      } else {
        newKeywords.put(searchWord.getKeyWord(), searchWord);
      }
    }
    lastUpdateTime = maxNewUpdatedTime;
    currentKeywords = newKeywords;
  }
}
