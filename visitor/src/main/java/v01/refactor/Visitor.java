package v01.refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/22 11:02
 * @since 1.0
 */
public interface Visitor {

  void visit(PdfFile pdfFile);

  void visit(PPTFile pptFile);

  void visit(WordFile wordFile);
}
