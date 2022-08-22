package v01.refactor;

/**
 * @author ImOkkkk
 * @date 2022/8/22 10:29
 * @since 1.0
 */
public abstract class ResourceFile {
  protected String filePath;
  public ResourceFile(String filePath) {
    this.filePath = filePath;
  }

  abstract public void accept(Visitor vistor);
}
