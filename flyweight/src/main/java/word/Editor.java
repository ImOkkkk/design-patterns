package word;

import java.util.ArrayList;
import java.util.List;
import word.Character.Font;

/**
 * @author ImOkkkk
 * @date 2022/8/9 14:32
 * @since 1.0
 */
public class Editor {

  private List<Character> chars = new ArrayList<>();

  public void appendCharacter(char c, Font font, int size, int colorRGB) {
    Character character = new Character(c, font, size, colorRGB);
    chars.add(character);
  }
}
