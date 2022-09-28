package com.idempotent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * @author ImOkkkk
 * @date 2022/9/28 15:27
 * @since 1.0
 */
public class Idempotence {

  //如果要替换存储方式，是不是很麻烦呢？
  private JedisCluster jedisCluster;

  //如果幂等框架要跟业务系统复用jedisCluster连接呢？
  //是不是应该注释说明一下redisClusterAddress的格式，以及config是否可以传递进null呢？
  public Idempotence(String redisClusterAddress, GenericObjectPoolConfig config) {
    String[] addressArray = redisClusterAddress.split(";");
    Set<HostAndPort> redisNodes = new HashSet<>();
    for (String address : addressArray) {
      String[] hostAndPort = address.split(":");
      redisNodes.add(new HostAndPort(hostAndPort[0], Integer.valueOf(hostAndPort[1])));
    }
    this.jedisCluster = new JedisCluster(redisNodes);
  }

  //generateId()是不是比缩写要好点？
  //根据接口隔离原则，这个函数跟其他函数的使用场景完全不同，这个函数主要用在调用方，其他函数用在实现方，是不是应该分别放到两个类中？
  public String genId() {
    return UUID.randomUUID().toString();
  }

  public boolean saveIfIfAbsent(String idempotenceId) {
    long success = jedisCluster.setnx(idempotenceId, "1");
    return success == 1;
  }

  public void delete(String idempotenceId) {
    jedisCluster.del(idempotenceId);
  }
}
