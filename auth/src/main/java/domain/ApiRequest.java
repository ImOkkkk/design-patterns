package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ImOkkkk
 * @date 2022/6/1 14:55
 * @since 1.0
 */
public class ApiRequest {
  private String baseUrl;

  private String token;

  private String appId;

  private long timestamp;

  public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
    this.baseUrl = baseUrl;
    this.token = token;
    this.appId = appId;
    this.timestamp = timestamp;
  }

  public static ApiRequest createFromFullUrl(String url) {
    String[] substr = url.split("\\?");
    String baseUrl = substr[0] + "?";

    String appId = getParamByUrl(url, "appId");
    String token = getParamByUrl(url, "token");
    long timestamp = Long.parseLong(getParamByUrl(url, "timestamp"));
    return new ApiRequest(baseUrl, token, appId, timestamp);
  }

  public static String getParamByUrl(String url, String name) {
    url += "&";
    String pattern = "(\\?|&){1}#{0,1}" + name + "=[a-zA-Z0-9]*(&{1})";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(url);
    if (m.find()) {
      return m.group(0).split("=")[1].replace("&", "");
    } else {
      return null;
    }
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public String getToken() {
    return token;
  }

  public String getAppId() {
    return appId;
  }

  public long getTimestamp() {
    return timestamp;
  }
}
