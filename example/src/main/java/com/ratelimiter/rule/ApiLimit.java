package com.ratelimiter.rule;

/**
 * @author ImOkkkk
 * @date 2022/9/23 14:59
 * @since 1.0
 */
public class ApiLimit {
  private static final int DEFAULT_TIME_UNIT = 1; // 1 second

  private String api;
  private int limit;
  private int unit = DEFAULT_TIME_UNIT;

  public ApiLimit() {}

  public ApiLimit(String api, int limit) {
    this(api, limit, DEFAULT_TIME_UNIT);
  }

  public ApiLimit(String api, int limit, int unit) {
    this.api = api;
    this.limit = limit;
    this.unit = unit;
  }

  public String getApi() {
    return this.api;
  }

  public int getLimit() {
    return this.limit;
  }
}
