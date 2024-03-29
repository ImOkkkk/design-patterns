package v01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/8/22 10:31
 * @since 1.0
 */
public class ToolApplication {
  public static void main(String[] args) {
    List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
    for (ResourceFile resourceFile : resourceFiles) {
      resourceFile.extract2txt();
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
