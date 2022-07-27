package di.expection;

/**
 * @author ImOkkkk
 * @date 2022/7/27 9:23
 * @since 1.0
 */
public class NoSuchBeanDefinitionException extends RuntimeException{

  public NoSuchBeanDefinitionException(String message) {
    super(message);
  }
}
