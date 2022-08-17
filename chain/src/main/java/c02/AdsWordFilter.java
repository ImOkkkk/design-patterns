package c02;

/**
 * @author ImOkkkk
 * @date 2022/8/16 17:12
 * @since 1.0
 */
public class AdsWordFilter implements SensitiveWordFilter{

  @Override
  public boolean doFilter(Content content) {
    boolean legal = true;
    // ...
    return legal;
  }
}
