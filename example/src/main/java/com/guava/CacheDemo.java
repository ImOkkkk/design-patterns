package com.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;

/**
 * @author ImOkkkk
 * @date 2022/9/15 16:48
 * @since 1.0
 */
public class CacheDemo {
  public static void main(String[] args) {
    Cache<String, String> cache = CacheBuilder.newBuilder()
        .initialCapacity(100)
        .maximumSize(1000)
        .expireAfterAccess(10, TimeUnit.MINUTES)
        .build();

    cache.put("key1", "value1");

    String value = cache.getIfPresent("key1");
    System.out.println(value);
  }
}
