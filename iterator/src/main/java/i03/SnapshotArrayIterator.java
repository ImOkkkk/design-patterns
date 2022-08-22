package i03;

import i01.Iterator;
import java.util.ArrayList;

/**
 * @author ImOkkkk
 * @date 2022/8/19 13:27
 * @since 1.0
 */
public class SnapshotArrayIterator<E> implements Iterator<E> {

  private int cursor;
  private ArrayList<E> snapshot;

  public SnapshotArrayIterator(ArrayList<E> arrayList) {
    this.cursor = 0;
    this.snapshot = new ArrayList<>();
    // 在迭代器类中定义一个成员变量 snapshot 来存储快照。
    // 每当创建迭代器的时候，都拷贝一份容器中的元素到快照中，后续的遍历操作都基于这个迭代器自己持有的快照来进行
    this.snapshot.addAll(arrayList);
  }

  @Override
  public boolean hasNext() {
    return cursor < snapshot.size();
  }

  @Override
  public void next() {
    cursor++;
  }

  @Override
  public E currentItem() {
    return snapshot.get(cursor);
  }
}
