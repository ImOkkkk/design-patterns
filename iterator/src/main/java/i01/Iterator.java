package i01;

/**
 * @author ImOkkkk
 * @date 2022/8/19 10:54
 * @since 1.0
 */
public interface Iterator<E> {
  boolean hasNext();

  void next();

  E currentItem();
}
