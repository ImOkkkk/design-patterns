package v01.refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/22 10:47
 * @since 1.0
 */
public class Extractor implements Visitor {


  @Override
  public void visit(PdfFile pdfFile) {
    System.out.println("Extract PDF.");
  }

  @Override
  public void visit(PPTFile pptFile) {
    System.out.println("Extract PPT.");
  }

  @Override
  public void visit(WordFile wordFile) {
    System.out.println("Extract WORD.");
  }
}
