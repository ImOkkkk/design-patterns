package i01.refactor;

import i01.ArrayIterator;
import i01.Iterator;

/**
 * @author ImOkkkk
 * @date 2022/8/19 11:05
 * @since 1.0
 */
public class ArrayList<E> implements List<E> {

  // 在容器中定义一个 iterator() 方法，来创建对应的迭代器
  @Override
  public Iterator iterator() {
//    return new ArrayIterator(this);
    return null;
  }

}
