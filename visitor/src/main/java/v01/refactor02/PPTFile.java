package v01.refactor02;

/**
 * @author ImOkkkk
 * @date 2022/8/22 14:19
 * @since 1.0
 */
public class PPTFile extends ResourceFile{

  public PPTFile(String filePath) {
    super(filePath);
  }

  @Override
  public ResourceFileType getType() {
    return ResourceFileType.PPT;
  }
}
