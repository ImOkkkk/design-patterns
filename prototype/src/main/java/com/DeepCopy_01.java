package com;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author ImOkkkk
 * @date 2022/7/28 14:07
 * @since 1.0
 */
public class DeepCopy_01 {
  private HashMap<String, SearchWord> currentKeywords=new HashMap<>();
  private long lastUpdateTime = -1;

  private List<SearchWord> getSearchWords(long lastUpdateTime) {
    // 从数据库中取出更新时间>lastUpdatedTime
    return null;
  }

  public void refresh() {
    // 递归拷贝对象、对象的引用对象以及引用对象的引用对象……
    // 直到要拷贝的对象只包含基本数据类型数据，没有引用对象为止。
    HashMap<String, SearchWord> newKeywords = new HashMap<>();
    for (Entry<String, SearchWord> entry : currentKeywords.entrySet()) {
      SearchWord searchWord = entry.getValue();
      SearchWord newSearchWord = new SearchWord(searchWord.getKeyWord(), searchWord.getCount(), searchWord.getLastUpdateTime());
      newKeywords.put(entry.getKey(), newSearchWord);
    }
    // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
    List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
    long maxNewUpdatedTime = lastUpdateTime;
    for (SearchWord searchWord : toBeUpdatedSearchWords) {
      if(searchWord.getLastUpdateTime() > maxNewUpdatedTime){
        maxNewUpdatedTime = searchWord.getLastUpdateTime();
      }
      if(newKeywords.containsKey(searchWord.getKeyWord())){
        SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyWord());
        oldSearchWord.setCount(searchWord.getCount());
        oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
      }else{
        newKeywords.put(searchWord.getKeyWord(), searchWord);
      }
    }
    lastUpdateTime = maxNewUpdatedTime;
    currentKeywords = newKeywords;
  }

  //第二种方法，先将对象序列化，再反序列化成新的对象
  public Object deepCopy(Object object) throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bo = new ByteArrayOutputStream();
    ObjectOutputStream oo = new ObjectOutputStream(bo);
    oo.writeObject(object);

    ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
    ObjectInputStream oi = new ObjectInputStream(bi);
    return oi.readObject();

  }
}
