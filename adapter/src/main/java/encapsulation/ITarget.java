package encapsulation;

/**
 *使用适配器模式进行重构(这是我们重新定义的接口)
 *
 * @author ImOkkkk
 * @date 2022/8/2 13:12
 * @since 1.0
 */
public interface ITarget {

  void function1();

  void function2();

  void fucntion3(ParamsWrapperDefinition paramsWrapper);

  void function4();
}
