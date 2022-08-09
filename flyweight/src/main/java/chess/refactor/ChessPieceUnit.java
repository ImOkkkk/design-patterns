package chess.refactor;

/**
 * 相似对象的 id、text、color 都是相同的，唯独 positionX、positionY 不同。
 *
 * @author ImOkkkk
 * @date 2022/8/9 14:17
 * @since 1.0
 */
public class ChessPieceUnit {
  private int id;
  private String text;
  private Color color;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public ChessPieceUnit(int id, String text, Color color) {
    this.id = id;
    this.text = text;
    this.color = color;
  }

  public static enum Color {
    RED, BLACK
  }
}
