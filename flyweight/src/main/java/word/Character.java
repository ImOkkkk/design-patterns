package word;

/**
 * @author ImOkkkk
 * @date 2022/8/9 14:31
 * @since 1.0
 */
public class Character {

  private char c;
  private Font font;

  private int size;
  private int colorRGB;
  public Character(char c, Font font, int size, int colorRGB) {
    this.c = c;
    this.font = font;
    this.size = size;
    this.colorRGB = colorRGB;
  }

  public static class Font{

  }
}
