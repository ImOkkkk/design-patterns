package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author ImOkkkk
 * @date 2022/8/17 13:07
 * @since 1.0
 */
public final class ApplicationFilterChain implements FilterChain {

  private int pos = 0; //当前执行到了哪个filter
  private int n; //filter的个数
  private ApplicationFilterConfig[] filters;
  private Servlet servlet;


  @Override
  public void doFilter(ServletRequest request, ServletResponse response)
      throws IOException, ServletException {
    if(pos < n){
      ApplicationFilterConfig filterConfig = filters[pos++];
      Filter filter = filterConfig.getFilter();
      filter.doFilter(request, response, this);
    }else{
      //filter都处理完毕后，执行servlet
      servlet.service(request, response);
    }
  }

  public void addFilter(ApplicationFilterConfig filterConfig){
    for (ApplicationFilterConfig filter : filters) {
      if(filter == filterConfig){
        return;
      }
    }
    if(n == filters.length){
      //扩容
      ApplicationFilterConfig[] newFilters = new ApplicationFilterConfig[n + 1];
      System.arraycopy(filters, 0, newFilters, 0, n);
      filters = newFilters;
    }
    filters[n++] = filterConfig;
  }
}
