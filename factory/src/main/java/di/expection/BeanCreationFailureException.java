package di.expection;

/**
 * @author ImOkkkk
 * @date 2022/7/27 9:27
 * @since 1.0
 */
public class BeanCreationFailureException extends RuntimeException{

  public BeanCreationFailureException(String message, ReflectiveOperationException e) {
    super(message, e);
  }
}
