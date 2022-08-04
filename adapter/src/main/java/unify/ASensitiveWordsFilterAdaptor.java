package unify;

import unify.external.ASensitiveWordsFilter;

/**
 * @author ImOkkkk
 * @date 2022/8/2 13:27
 * @since 1.0
 */
public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

  private ASensitiveWordsFilter aFilter;

  @Override
  public String filter(String text) {
    String maskedText = aFilter.filterSexyWords(text);
    maskedText = aFilter.filterPoliticalWords(maskedText);
    return maskedText;
  }
}
