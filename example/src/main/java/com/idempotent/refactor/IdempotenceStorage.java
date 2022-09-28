package com.idempotent.refactor;

/**
 * @author ImOkkkk
 * @date 2022/9/28 15:37
 * @since 1.0
 */
public interface IdempotenceStorage {

  boolean saveIfAbsent(String idempotenceId);
  void delete(String idempotenceId);

}
