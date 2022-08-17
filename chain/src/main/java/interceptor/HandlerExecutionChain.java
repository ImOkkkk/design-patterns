package interceptor;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ImOkkkk
 * @date 2022/8/17 13:40
 * @since 1.0
 */
public class HandlerExecutionChain {
  private static final Logger logger = LoggerFactory.getLogger(HandlerExecutionChain.class);
  private Object handler;
  private HandlerInterceptor[] interceptors;
  private int index = 0;
  private int n;

  public void addInterceptor(HandlerInterceptor interceptor) {
    for (HandlerInterceptor handlerInterceptor : interceptors) {
      if (handlerInterceptor == interceptor) {
        return;
      }
    }
    if (n == interceptors.length) {
      HandlerInterceptor[] newInterceptors = new HandlerInterceptor[n + 1];
      System.arraycopy(interceptors, 0, newInterceptors, 0, n);
      interceptors = newInterceptors;
    }
    interceptors[n++] = interceptor;
  }

  boolean applyPreHandle(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    if (!ObjectUtils.isEmpty(interceptors)) {
      for (HandlerInterceptor interceptor : interceptors) {
        if (!interceptor.preHandle(request, response, this.handler)) {
          triggerAfterCompletion(request, response, null);
          return false;
        }
      }
    }
    return true;
  }

  void applyPostHandle(HttpServletRequest request, HttpServletResponse response, ModelAndView mv)
      throws Exception {
    if (!ObjectUtils.isEmpty(interceptors)) {
      for (int i = interceptors.length - 1; i >= 0; i--) {
        HandlerInterceptor interceptor = interceptors[i];
        interceptor.postHandle(request, response, this.handler, mv);
      }
    }
  }

  private void triggerAfterCompletion(
      HttpServletRequest request, HttpServletResponse response, Exception ex) {
    if (!ObjectUtils.isEmpty(interceptors)) {
      for (int i = this.index; i >= 0; i--) {
        HandlerInterceptor interceptor = interceptors[i];
        try {
          interceptor.afterCompletion(request, response, this.handler, ex);
        } catch (Exception ex2) {
          logger.error("HandlerInterceptor.afterCompletion threw exception", ex2);
        }
      }
    }
  }
}
