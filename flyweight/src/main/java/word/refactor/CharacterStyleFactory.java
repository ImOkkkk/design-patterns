package word.refactor;

import java.util.ArrayList;
import java.util.List;
import word.refactor.CharacterStyle.Font;

/**
 * @author ImOkkkk
 * @date 2022/8/9 14:39
 * @since 1.0
 */
public class CharacterStyleFactory {
  private static final List<CharacterStyle> styles = new ArrayList<>();

  public static CharacterStyle getStyle(Font font, int size, int colorRGB){
    CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
    for (CharacterStyle style : styles) {
      if (style.equals(newStyle)) {
        return style;
      }
    }
    styles.add(newStyle);
    return newStyle;
  }

}
