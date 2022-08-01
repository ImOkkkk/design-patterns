package com.alert.pojo;

/**
 * @author ImOkkkk
 * @date 2022/6/2 13:43
 * @since 1.0
 */
public class ApiStatInfo {
  private String api;
  private long requestCount;
  private long errorCount;
  private long durationOfSeconds;
  private long timeoutCount; //改动一：添加新字段

  public ApiStatInfo() {
  }

  public String getApi() {
    return api;
  }

  public void setApi(String api) {
    this.api = api;
  }

  public long getRequestCount() {
    return requestCount;
  }

  public void setRequestCount(long requestCount) {
    this.requestCount = requestCount;
  }

  public long getErrorCount() {
    return errorCount;
  }

  public void setErrorCount(long errorCount) {
    this.errorCount = errorCount;
  }

  public long getDurationOfSeconds() {
    return durationOfSeconds;
  }

  public void setDurationOfSeconds(long durationOfSeconds) {
    this.durationOfSeconds = durationOfSeconds;
  }

  public long getTimeoutCount() {
    return timeoutCount;
  }

  public void setTimeoutCount(long timeoutCount) {
    this.timeoutCount = timeoutCount;
  }
}
