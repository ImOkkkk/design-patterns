package i02;

import i01.Iterator;
import java.util.ConcurrentModificationException;

/**
 * @author ImOkkkk
 * @date 2022/8/19 11:25
 * @since 1.0
 */
public class ArrayIterator<E> implements Iterator<E> {
  private int cursor;
  private ArrayList<E> arrayList;
  private int expectedModCount;

  public ArrayIterator(ArrayList<E> arrayList) {
    this.cursor = 0;
    this.arrayList = arrayList;
    this.expectedModCount = arrayList.modCount;
  }

  @Override
  public boolean hasNext() {
    checkForComodification();
    return cursor != arrayList.size();
  }

  private void checkForComodification() {
    // 检查集合上的 modCount 是否等于 expectedModCount
    if (arrayList.modCount != expectedModCount) throw new ConcurrentModificationException();
  }

  @Override
  public void next() {
    checkForComodification();
    cursor++;
  }

  @Override
  public E currentItem() {
    checkForComodification();
    return arrayList.get(cursor);
  }
}
