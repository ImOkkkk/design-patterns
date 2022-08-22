package v01.refactor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/8/22 10:47
 * @since 1.0
 */
public class ToolApplication {
  public static void main(String[] args) {
    Extractor extractor = new Extractor();
    Compressor compressor = new Compressor();
    List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
    for (ResourceFile resourceFile : resourceFiles) {
      resourceFile.accept(extractor);
      resourceFile.accept(compressor);
    }
  }

  private static List<ResourceFile> listAllResourceFiles(String resourceDirPath) {
    List<ResourceFile> resourceFiles = new ArrayList<>();
    // ...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
    resourceFiles.add(new PdfFile("a.pdf"));
    resourceFiles.add(new WordFile("b.word"));
    resourceFiles.add(new PPTFile("c.ppt"));
    return resourceFiles;
  }
}
