package chess.refactor;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类来缓存 ChessPieceUnit 信息（也就是 id、text、 color） 工厂类来缓存 ChessPieceUnit 信息（也就是 id、text、 color）
 *
 * @author ImOkkkk
 * @date 2022/8/9 14:21
 * @since 1.0
 */
public class ChessPieceUnitFactory {

  private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

  static {
    pieces.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.Color.BLACK));
    pieces.put(2, new ChessPieceUnit(2,"馬", ChessPieceUnit.Color.BLACK));
    //...省略摆放其他棋子的代码...
  }

  public static ChessPieceUnit getChessPiece(int chessPieceId) {
    return pieces.get(chessPieceId);
  }

}
