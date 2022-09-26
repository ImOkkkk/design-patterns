package com.ratelimiter.alg;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/9/26 14:54
 * @since 1.0
 */
public class RateLimitAlgFactory {

  public static final String FIXED_TIME_WIN = "FixedTimeWin";

  public static RateLimitAlg getRateLimitAlg(int limit, String limitType) {
    switch (limitType) {
      case FIXED_TIME_WIN:
        return new FixedTimeWinRateLimitAlg(limit);
      default:
        return new FixedTimeWinRateLimitAlg(limit);
    }
  }
}
