package sort.refactor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:43
 * @since 1.0
 */
public class Sorter {
  private static final long GB = 1000 * 1000 * 1000;
  private static final List<AlgRange> algs = new ArrayList<>();

  static {
    algs.add(new AlgRange(0, 6 * GB, SortAlgFactory.getSortAlg("QuickSort")));
    algs.add(new AlgRange(6 * GB, 10 * GB, SortAlgFactory.getSortAlg("ExternalSort")));
    algs.add(new AlgRange(10 * GB, 100 * GB, SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
    algs.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg("MapReduceSort")));
  }

  public void sortFile(String filePath) {
    File file = new File(filePath);
    long fileSize = file.length();
    for (AlgRange alg : algs) {
      if (alg.inRange(fileSize)) {
        ISortAlg sortAlg = alg.getAlg();
        sortAlg.sort(filePath);
        break;
      }
    }
  }
}
