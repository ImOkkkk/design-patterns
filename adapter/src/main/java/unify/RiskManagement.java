package unify;

import unify.external.ASensitiveWordsFilter;
import unify.external.BSensitiveWordsFilter;
import unify.external.CSensitiveWordsFilter;

/**
 * 未使用适配器模式之前的代码：代码的可测试性、扩展性不好
 *
 * @author ImOkkkk
 * @date 2022/8/2 13:25
 * @since 1.0
 */
public class RiskManagement {
  private ASensitiveWordsFilter aFilter = new ASensitiveWordsFilter();
  private BSensitiveWordsFilter bFilter = new BSensitiveWordsFilter();
  private CSensitiveWordsFilter cFilter = new CSensitiveWordsFilter();
  public String filterSensitiveWords(String text) {
    String maskedText = aFilter.filterSexyWords(text);
    maskedText = aFilter.filterPoliticalWords(maskedText);
    maskedText = bFilter.filter(maskedText);
    maskedText = cFilter.filter(maskedText, "***");
    return maskedText;
  }
}
