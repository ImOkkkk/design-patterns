package di.context;

/**
 * @author ImOkkkk
 * @date 2022/7/26 22:19
 * @since 1.0
 */
public interface ApplicationContext {
  Object getBean(String beanId);
}
