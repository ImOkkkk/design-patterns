package i01.refactor;

import i01.Iterator;

/**
 * @author ImOkkkk
 * @date 2022/8/19 11:05
 * @since 1.0
 */
public interface List<E>{
  // 基于接口而非实现编程，将这个方法定义在 List 接口中
  Iterator iterator();
}
