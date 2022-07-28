package com;

/**
 * @author ImOkkkk
 * @date 2022/7/28 13:15
 * @since 1.0
 */

public class SearchWord {

  private String keyWord;

  private Integer count;

  private Long lastUpdateTime;

  public SearchWord(String keyWord, Integer count, Long lastUpdateTime) {
    this.keyWord = keyWord;
    this.count = count;
    this.lastUpdateTime = lastUpdateTime;
  }

  public String getKeyWord() {
    return keyWord;
  }

  public void setKeyWord(String keyWord) {
    this.keyWord = keyWord;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Long getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(Long lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }
}
