package word.refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/9 14:37
 * @since 1.0
 */
public class CharacterStyle {

  private Font font;
  private int size;
  private int colorRGB;

  public CharacterStyle(Font font, int size, int colorRGB) {
    this.font = font;
    this.size = size;
    this.colorRGB = colorRGB;
  }

  @Override
  public boolean equals(Object obj) {
    CharacterStyle otherStyle = (CharacterStyle) obj;
    return font.equals(otherStyle.font)
        && size == otherStyle.size
        && colorRGB == otherStyle.colorRGB;
  }

  public Font getFont() {
    return font;
  }

  public void setFont(Font font) {
    this.font = font;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getColorRGB() {
    return colorRGB;
  }

  public void setColorRGB(int colorRGB) {
    this.colorRGB = colorRGB;
  }

  public static class Font {}
}
