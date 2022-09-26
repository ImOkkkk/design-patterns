package com.ratelimiter.alg;

/**
 * @author ImOkkkk
 * @date 2022/9/23 15:00
 * @since 1.0
 *     <p>限流算法
 */
public interface RateLimitAlg {

  boolean tryAcquire() throws Exception;
}
