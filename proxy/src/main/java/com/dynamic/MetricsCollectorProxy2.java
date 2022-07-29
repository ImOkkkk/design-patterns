package com.dynamic;

import com.performance.controller.MetricsCollector;
import com.performance.pojo.bo.RequestInfo;
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Cglib动态创建被代理类的子类实现方法拦截
 * CGLIB 不能代理被 final 关键字修饰的类和方法。
 * @author ImOkkkk
 * @date 2022/7/29 9:45
 * @since 1.0
 */
public class MetricsCollectorProxy2 {

  private MetricsCollector metricsCollector;

  public MetricsCollectorProxy2() {
    this.metricsCollector = new MetricsCollector();
  }

  public Object createProxy(Object proxiedObject) {
    Enhancer enhancer = new Enhancer();
    enhancer.setClassLoader(proxiedObject.getClass().getClassLoader());
    enhancer.setSuperclass(proxiedObject.getClass());
    DynamicProxyInterceptor dynamicProxyInterceptor = new DynamicProxyInterceptor(proxiedObject);
    enhancer.setCallback(dynamicProxyInterceptor);
    return enhancer.create();
  }

  private class DynamicProxyInterceptor implements MethodInterceptor {

    private Object proxiedObject;

    public DynamicProxyInterceptor(Object proxiedObject) {
      this.proxiedObject = proxiedObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
        throws Throwable {
      long startTimestamp = System.currentTimeMillis();
      Object result = methodProxy.invoke(proxiedObject, objects);
      long endTimeStamp = System.currentTimeMillis();
      long responseTime = endTimeStamp - startTimestamp;
      String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
      RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
      metricsCollector.recordRequest(requestInfo);
      return result;
    }
  }
}
