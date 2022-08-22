package v01.refactor02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/8/22 14:23
 * @since 1.0
 */
public class ExtractorFactory {
  private static final Map<ResourceFileType, Extractor> extractors = new HashMap<>();

  static {
    extractors.put(ResourceFileType.PDF, new PdfExtractor());
    extractors.put(ResourceFileType.PPT, new PPTExtractor());
    extractors.put(ResourceFileType.WORD, new WordExtractor());
  }
  public static Extractor getExtractor(ResourceFileType type) {
    return extractors.get(type);
  }

}
