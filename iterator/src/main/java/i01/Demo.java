package i01;

import java.util.ArrayList;

/**
 * @author ImOkkkk
 * @date 2022/8/19 11:01
 * @since 1.0
 */
public class Demo {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("AAA");
    names.add("BBB");
    names.add("CCC");

    Iterator<String> iterator = new ArrayIterator<>(names);
    while (iterator.hasNext()){
      System.out.println(iterator.currentItem());
      iterator.next();
      //数组的删除操作会涉及元素的搬移
      names.remove("AAA");
    }
  }
}
