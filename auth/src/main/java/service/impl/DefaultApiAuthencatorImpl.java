package service.impl;

import domain.ApiRequest;
import domain.AuthToken;
import domain.storage.CredentialStorage;
import domain.storage.MysqlCredentialStorage;
import service.ApiAuthencator;

/**
 * @author ImOkkkk
 * @date 2022/6/1 15:06
 * @since 1.0
 */
public class DefaultApiAuthencatorImpl implements ApiAuthencator {

  private CredentialStorage credentialStorage;

  public DefaultApiAuthencatorImpl() {
    this.credentialStorage = new MysqlCredentialStorage();
  }

  public DefaultApiAuthencatorImpl(CredentialStorage credentialStorage) {
    this.credentialStorage = credentialStorage;
  }

  @Override
  public void auth(String url) {
    ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
    auth(apiRequest);
  }

  @Override
  public void auth(ApiRequest apiRequest) {
    String appId = apiRequest.getAppId();
    String token = apiRequest.getToken();
    long timestamp = apiRequest.getTimestamp();
    String baseUrl = apiRequest.getBaseUrl();
    AuthToken clientAuthToken = new AuthToken(token, timestamp, 30 * 60 * 1000L);
    if (clientAuthToken.isExpired()) {
      throw new RuntimeException("Token is Expired!");
    }
    String password = credentialStorage.getPasswordByAppId(appId);
    AuthToken serverAuthToken = AuthToken.generate(baseUrl, appId, password, timestamp);
    if (!serverAuthToken.match(clientAuthToken)) {
      throw new RuntimeException("Token verfication failed.");
    }
  }
}
