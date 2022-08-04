package unify;

import unify.external.ASensitiveWordsFilter;
import unify.external.BSensitiveWordsFilter;

/**
 * @author ImOkkkk
 * @date 2022/8/2 13:27
 * @since 1.0
 */
public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

  private BSensitiveWordsFilter bFilter;

  @Override
  public String filter(String text) {
    String maskedText = bFilter.filter(text);
    return maskedText;
  }
}
