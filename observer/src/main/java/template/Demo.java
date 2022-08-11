package template;

/**
 * @author ImOkkkk
 * @date 2022/8/11 10:54
 * @since 1.0
 */
public class Demo {
  public static void main(String[] args) {
    ConcreteSubject subject = new ConcreteSubject();
    subject.registerObserver(new ConcreteObserverOne());
    subject.registerObserver(new ConcreteObserverTwo());
    subject.notifyObservers(new Message());
  }
}
