package sort;

import java.io.File;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:37
 * @since 1.0
 */
public class Sorter {
  private static final long GB = 1000 * 1000 * 1000;

  public void sortFile(String filePath) {
    File file = new File(filePath);
    long fileSize = file.length();
    if (fileSize < 6 * GB) { // [0, 6GB)
      quickSort(filePath);
    } else if (fileSize < 10 * GB) { // [6GB, 10GB)
      externalSort(filePath);
    } else if (fileSize < 100 * GB) { // [10GB, 100GB)
      concurrentExternalSort(filePath);
    } else { // [100GB, ~)
      mapreduceSort(filePath);
    }
  }

  private void quickSort(String filePath) {
    // 快速排序
  }

  private void externalSort(String filePath) {
    // 外部排序
  }

  private void concurrentExternalSort(String filePath) {
    // 多线程外部排序
  }

  private void mapreduceSort(String filePath) {
    // 利用MapReduce多机排序
  }
}
