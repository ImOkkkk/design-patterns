package com.ratelimiter.alg;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ImOkkkk
 * @date 2022/9/23 15:00
 * @since 1.0
 *     <p>固定时间窗口限流算法
 */
public class FixedTimeWinRateLimitAlg implements RateLimitAlg {
  private static final long TRY_LOCK_TIMEOUT = 200L; // 200ms.
  private final int limit;
  private Stopwatch stopwatch;
  private AtomicInteger currentCount = new AtomicInteger(0);
  private Lock lock = new ReentrantLock();

  protected FixedTimeWinRateLimitAlg(int limit, Stopwatch stopwatch) {
    this.limit = limit;
    this.stopwatch = stopwatch;
  }

  public FixedTimeWinRateLimitAlg(int limit) {
    this(limit, Stopwatch.createStarted());
  }

  public boolean tryAcquire() throws Exception {
    int updatedCount = currentCount.incrementAndGet();
    if (updatedCount <= limit) {
      return true;
    }
    try {
      if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
        try {
          if (stopwatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)) {
            currentCount.set(0);
            stopwatch.reset();
          }
          updatedCount = currentCount.incrementAndGet();
          return updatedCount <= limit;
        } finally {
          lock.unlock();
        }
      } else {
        throw new Exception("tryAcquire() wait lock too long:" + TRY_LOCK_TIMEOUT + "ms");
      }
    } catch (InterruptedException e) {
      throw new InterruptedException("tryAcquire() is interrupted by lock-time-out." + e);
    }
  }
}
