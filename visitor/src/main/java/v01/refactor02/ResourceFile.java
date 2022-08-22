package v01.refactor02;

/**
 * @author ImOkkkk
 * @date 2022/8/22 14:06
 * @since 1.0
 */
public abstract class ResourceFile {
  protected String filePath;
  public ResourceFile(String filePath) {
    this.filePath = filePath;
  }
  public abstract ResourceFileType getType();
}
