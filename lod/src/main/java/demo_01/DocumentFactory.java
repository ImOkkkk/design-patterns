package demo_01;

/**
 * @author ImOkkkk
 * @date 2022/6/23 16:51
 * @since 1.0
 */
public class DocumentFactory {
  private HtmlDownloader downloader;

  public DocumentFactory(HtmlDownloader htmlDownloader) {
    this.downloader = htmlDownloader;
  }

  public Document createDocument(String url) {
    Html html = downloader.downloadHtml(url);
    return new Document(url, html);
  }
}
