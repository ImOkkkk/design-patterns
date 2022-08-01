package com.auth.domain;

import cn.hutool.core.codec.Base64;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

/**
 * @author ImOkkkk
 * @date 2022/6/1 14:58
 * @since 1.0
 */
public class AuthToken {

  private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000L;

  private String token;

  private long createTime;

  private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

  public AuthToken(String token, long createTime) {
    this.token = token;
    this.createTime = createTime;
  }

  public AuthToken(String token, long createTime, long expiredTimeInterval) {
    this.token = token;
    this.createTime = createTime;
    this.expiredTimeInterval = expiredTimeInterval;
  }

  public static AuthToken generate(String baseUrl, String appId, String password, long timestamp) {
    String str = baseUrl + "appId=" + appId + "&password=" + password + "&timestamp=" + timestamp;
    String token = Base64.encodeUrlSafe(str.getBytes(StandardCharsets.UTF_8));
    AuthToken authToken = new AuthToken(token, timestamp);
    return authToken;
  }

  public boolean isExpired() {
    return Instant.now().toEpochMilli() - createTime > expiredTimeInterval;
  }

  public boolean match(AuthToken authToken) {
    return this.token.equals(authToken.getToken());
  }

  public String getToken() {
    return token;
  }
}
