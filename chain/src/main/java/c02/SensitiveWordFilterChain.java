package c02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/8/16 17:13
 * @since 1.0
 */
public class SensitiveWordFilterChain {
  private List<SensitiveWordFilter> filters = new ArrayList<>();

  public void addFilter(SensitiveWordFilter filter){
    this.filters.add(filter);
  }

  public boolean filter(Content content){
    for (SensitiveWordFilter filter : filters) {
      if(!filter.doFilter(content)){
        return false;
      }
    }
    return true;
  }

}
