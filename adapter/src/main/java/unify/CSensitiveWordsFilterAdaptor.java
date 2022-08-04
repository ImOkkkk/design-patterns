package unify;

import unify.external.CSensitiveWordsFilter;

/**
 * @author ImOkkkk
 * @date 2022/8/2 13:27
 * @since 1.0
 */
public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

  private CSensitiveWordsFilter cFilter;

  @Override
  public String filter(String text) {
    String maskedText = cFilter.filter(text,  "***");
    return maskedText;
  }
}
