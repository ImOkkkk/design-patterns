package com.idempotent.refactor;

import java.util.UUID;

/**
 * @author ImOkkkk
 * @date 2022/9/28 15:36
 * @since 1.0
 *     <p>幂等号生成类
 */
public class IdempotenceIdGenerator {
  public String generateId() {
    return UUID.randomUUID().toString();
  }
}
