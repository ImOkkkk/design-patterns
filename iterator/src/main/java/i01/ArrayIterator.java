package i01;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author ImOkkkk
 * @date 2022/8/19 10:56
 * @since 1.0
 */
public class ArrayIterator<E> implements Iterator<E>{
  private int cursor;
  private ArrayList<E> arrayList;

  public ArrayIterator(ArrayList<E> arrayList) {
    this.cursor = 0;
    this.arrayList = arrayList;
  }

  @Override
  public boolean hasNext() {
    ///cursor在指向最后一个元素的时候，hasNext()仍旧返回true。
    return cursor != arrayList.size();
  }

  @Override
  public void next() {
    cursor++;
  }

  @Override
  public E currentItem() {
    if(cursor >= arrayList.size()){
      throw new NoSuchElementException();
    }
    return arrayList.get(cursor);
  }
}
