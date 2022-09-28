package com.idempotent.refactor;

/**
 * @author ImOkkkk
 * @date 2022/9/28 15:37
 * @since 1.0
 */
public class Idempotence {
  private IdempotenceStorage storage;

  public Idempotence(IdempotenceStorage storage) {
    this.storage = storage;
  }

  public boolean saveIfAbsent(String idempotenceId) {
    return storage.saveIfAbsent(idempotenceId);
  }

  public void delete(String idempotenceId) {
    storage.delete(idempotenceId);
  }
}
