package v01;

/**
 * @author ImOkkkk
 * @date 2022/8/22 10:29
 * @since 1.0
 */
public class PPTFile extends ResourceFile {

  public PPTFile(String filePath) {
    super(filePath);
  }

  @Override
  public void extract2txt() {
    // ...省略一大坨从PPT中抽取文本的代码...
    // ...将抽取出来的文本保存在跟filePath同名的.txt文件中...
    System.out.println("Extract PPT.");
  }
}
