package com.mybatis;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.sql.Statement;
import java.util.Properties;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;

/**
 * @author ImOkkkk
 * @date 2022/9/20 16:01
 * @since 1.0
 */

// 标明拦截的目标方法
@Intercepts({
  @Signature(
      type = StatementHandler.class,
      method = "query",
      args = {Statement.class, ResultHandler.class}),
  @Signature(
      type = StatementHandler.class,
      method = "update",
      args = {Statement.class}),
  @Signature(
      type = StatementHandler.class,
      method = "batch",
      args = {Statement.class}),
})

// StatementHandler 执行SQL 语句，最后使用 ResultSetHandler 封装执行结果。
public class SqlCostTimeInterceptor implements Interceptor {
  private static final Logger logger = LoggerFactory.getLogger(SqlCostTimeInterceptor.class);

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    Object target = invocation.getTarget();
    long start = System.currentTimeMillis();
    StatementHandler statementHandler = (StatementHandler) target;
    try {
      return invocation.proceed();
    } finally {
      long costTime = System.currentTimeMillis() - start;
      BoundSql boundSql = statementHandler.getBoundSql();
      String sql = boundSql.getSql();
      logger.debug("执行 SQL：[ {} ]执行耗时[ {} ms]", sql, costTime);
    }
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    System.out.println("插件配置的信息："+properties);
  }


//  <!-- MyBatis全局配置文件：mybatis-config.xml -->
//  <plugins>
//    <plugin interceptor="com.xzg.cd.a88.SqlCostTimeInterceptor">
//      <property name="someProperty" value="100"/>
//     </plugin>
//  </plugins>
}
