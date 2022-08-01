package com.auth.domain.storage;

/**
 * @author ImOkkkk
 * @date 2022/6/1 15:04
 * @since 1.0
 */
public interface CredentialStorage {

  String getPasswordByAppId(String appId);
}
