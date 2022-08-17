package c02;

/**
 * 政治词过滤器
 *
 * @author ImOkkkk
 * @date 2022/8/16 17:11
 * @since 1.0
 */
public class PoliticalWordFilter implements SensitiveWordFilter {

  @Override
  public boolean doFilter(Content content) {
    boolean legal = true;
    // ...
    return legal;
  }
}
