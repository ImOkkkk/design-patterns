package template;

/**
 * @author ImOkkkk
 * @date 2022/8/11 10:47
 * @since 1.0
 */
public interface Subject {

  void registerObserver(Observer observer);
  void removeObserver(Observer observer);
  void notifyObservers(Message message);

}
