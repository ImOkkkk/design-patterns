package sort.refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/15 13:44
 * @since 1.0
 */
public class AlgRange {

  private long start;
  private long end;
  private ISortAlg alg;
  public AlgRange(long start, long end, ISortAlg alg) {
    this.start = start;
    this.end = end;
    this.alg = alg;
  }
  public ISortAlg getAlg() {
    return alg;
  }
  public boolean inRange(long size) {
    return size >= start && size < end;
  }
}
