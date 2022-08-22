package v01.refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/22 10:46
 * @since 1.0
 */
public class PdfFile extends ResourceFile{

  public PdfFile(String filePath) {
    super(filePath);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
