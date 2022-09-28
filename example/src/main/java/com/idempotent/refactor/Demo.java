package com.idempotent.refactor;

import redis.clients.jedis.JedisCluster;

/**
 * @author ImOkkkk
 * @date 2022/9/28 15:47
 * @since 1.0
 */
public class Demo {

  private static JedisCluster jedisCluster;

  public static void main(String[] args) {
    Idempotence idempotence = new Idempotence(new RedisClusterIdempotenceStorage(jedisCluster));
    String idempotenceId = new IdempotenceIdGenerator().generateId();
    idempotence.saveIfAbsent(idempotenceId);
    idempotence.delete(idempotenceId);
  }
}
