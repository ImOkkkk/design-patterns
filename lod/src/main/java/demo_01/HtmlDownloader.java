package demo_01;

import java.nio.charset.StandardCharsets;

/**
 * @author ImOkkkk
 * @date 2022/6/23 16:46
 * @since 1.0
 */
public class HtmlDownloader {

  private NetworkTransporter networkTransporter;

//  public Html downloadHtml(String url) {
//    Byte[] rawHtml = networkTransporter.send(new HtmlRequest(url));
//    return new Html(rawHtml);
//  }

  public Html downloadHtml(String url) {
    HtmlRequest htmlRequest = new HtmlRequest(url);
    Byte[] rawHtml = networkTransporter.send(htmlRequest.getAddress(),
        htmlRequest.getContent().getBytes(
            StandardCharsets.UTF_8));
    return new Html(rawHtml);
  }

}
