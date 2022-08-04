package encapsulation;

import encapsulation.external.CD;

/**
 * 类适配器: 基于继承
 *
 * @author ImOkkkk
 * @date 2022/8/2 13:15
 * @since 1.0
 */
public class CDAdaptor extends CD implements ITarget{

  @Override
  public void function1() {
    super.staticFunction1();
  }

  @Override
  public void function2() {
    super.uglyNamingFunction2();
  }

  @Override
  public void fucntion3(ParamsWrapperDefinition paramsWrapper) {
    super.tooManyParamsFunction3(paramsWrapper.getParamA(), paramsWrapper.getParamB());
  }

  @Override
  public void function4() {
    //...reimplement it
  }
}
