package chess.refactor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/8/9 14:23
 * @since 1.0
 */
public class ChessBoard {

  private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

  public ChessBoard() {
    init();
  }

  private void init() {
    // 工厂类获取到的 ChessPieceUnit 就是享元。所有的 ChessBoard 对象共享
    // 这 30 个 ChessPieceUnit 对象（因为象棋中只有 30 个棋子）
    chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1), 0, 0));
    chessPieces.put(1, new ChessPiece(
        ChessPieceUnitFactory.getChessPiece(2), 1,0));
    //...省略摆放其他棋子的代码...
  }

  public void move(int chessPieceId, int toPositionX, int toPositionY) {
    //...省略...
  }
}
