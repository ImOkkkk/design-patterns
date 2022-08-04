package replace;

import replace.external.B;
import replace.external.IA;

/**
 * 将外部系统A替换成外部系统B
 *
 * @author ImOkkkk
 * @date 2022/8/2 13:59
 * @since 1.0
 */
public class BAdaptor implements IA {
  private B b;

  public BAdaptor(B b) {
    this.b = b;
  }

  @Override
  public void fa() {
    b.fb();
  }
}
