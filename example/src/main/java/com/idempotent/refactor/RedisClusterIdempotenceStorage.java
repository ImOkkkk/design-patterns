package com.idempotent.refactor;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * @author ImOkkkk
 * @date 2022/9/28 15:38
 * @since 1.0
 */
public class RedisClusterIdempotenceStorage implements IdempotenceStorage {
  private JedisCluster jedisCluster;

  public RedisClusterIdempotenceStorage(
      String redisClusterAddress, GenericObjectPoolConfig config) {
    Set<HostAndPort> redisNodes = parseHostAndPorts(redisClusterAddress);
    this.jedisCluster = new JedisCluster(redisNodes, config);
  }

  public RedisClusterIdempotenceStorage(JedisCluster jedisCluster) {
    this.jedisCluster = jedisCluster;
  }

  @Override
  public boolean saveIfAbsent(String idempotenceId) {
    Long success = jedisCluster.setnx(idempotenceId, "1");
    return success == 1;
  }

  @Override
  public void delete(String idempotenceId) {
    jedisCluster.del(idempotenceId);
  }

  protected Set<HostAndPort> parseHostAndPorts(String redisClusterAddress) {
    String[] addressArray = redisClusterAddress.split(";");
    Set<HostAndPort> redisNodes = new HashSet<>();
    for (String address : addressArray) {
      String[] hostAndPort = address.split(":");
      redisNodes.add(new HostAndPort(hostAndPort[0], Integer.valueOf(hostAndPort[1])));
    }
    return redisNodes;
  }
}
