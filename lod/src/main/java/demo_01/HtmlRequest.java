package demo_01;

/**
 * @author ImOkkkk
 * @date 2022/6/23 16:47
 * @since 1.0
 */
public class HtmlRequest {
  private String url;

  private String address;

  private String content;

  public HtmlRequest(String url) {
    this.url = url;
    //
  }

  public String getAddress() {
    return address;
  }

  public String getContent() {
    return content;
  }
}
