package demo_01;

/**
 * 构造函数中的 downloader.downloadHtml() 逻辑复杂，耗时长，不应该放到构造函数中，会影响代码的可测试性
 * HtmlDownloader 对象在构造函数中通过 new 来创建，违反了基于接口而非实现编程的设计思想
 * Document 网页文档没必要依赖 HtmlDownloader类，违背了迪米特法则。
 *
 * @author ImOkkkk
 * @date 2022/6/23 16:51
 * @since 1.0
 */
public class Document {
  private Html html;
  private String url;

//  public Document(String url) {
//    this.url = url;
//    HtmlDownloader downloader = new HtmlDownloader();
//    this.html = downloader.downloadHtml(url);
//  }

  public Document(String url, Html html) {
    this.html = html;
    this.url = url;
  }
}
