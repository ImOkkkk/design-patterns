package s01;

/**
 * @author ImOkkkk
 * @date 2022/8/23 10:09
 * @since 1.0
 */
public class InputText {
  private StringBuilder text = new StringBuilder();

  public String getText() {
    return text.toString();
  }

  public void setText(String text) {
    this.text.replace(0, this.text.length(), text);
  }

  public void append(String input) {
    text.append(input);
  }

}
