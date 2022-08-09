package word.refactor;

import java.util.ArrayList;
import java.util.List;
import word.refactor.CharacterStyle.Font;

/**
 * @author ImOkkkk
 * @date 2022/8/9 14:43
 * @since 1.0
 */
public class Editor {

  private List<Character> chars = new ArrayList<>();

  public void appendCharacter(char c, Font font, int size, int colorRGB) {
    Character character = new Character(c, CharacterStyleFactory.getStyle(font, size, colorRGB));
    chars.add(character);
  }
}
