package i02;

import i01.Iterator;
import i01.refactor.List;

/**
 * @author ImOkkkk
 * @date 2022/8/19 11:05
 * @since 1.0
 */
public class ArrayList<E> implements List<E> {

  // 记录集合被修改的次数，集合每调用一次增加或删除元素的函数，就会给modCount加 1
  protected transient int modCount = 0;

  private int size;

  public int size() {
    return size;
  }
  // 在容器中定义一个 iterator() 方法，来创建对应的迭代器
  @Override
  public Iterator iterator() {
    // 创建迭代器，把modCount 值传递给迭代器的 expectedModCount 成员变量
    return new ArrayIterator(this);
  }

  public E get(int index) {
    return null;
  }
}
