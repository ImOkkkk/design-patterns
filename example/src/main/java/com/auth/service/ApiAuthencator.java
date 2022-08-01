package com.auth.service;

import com.auth.domain.ApiRequest;

/**
 * @author ImOkkkk
 * @date 2022/6/1 14:53
 * @since 1.0
 */
public interface ApiAuthencator {
  void auth(String url);

  void auth(ApiRequest apiRequest);
}
