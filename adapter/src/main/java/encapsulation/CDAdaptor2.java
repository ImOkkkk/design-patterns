package encapsulation;

import encapsulation.external.CD;

/**
 * @author ImOkkkk
 * @date 2022/8/2 13:19
 * @since 1.0
 */
public class CDAdaptor2 implements ITarget{

  private CD cd;

  public CDAdaptor2(CD cd) {
    this.cd = cd;
  }

  @Override
  public void function1() {
    CD.staticFunction1();
  }

  @Override
  public void function2() {
    cd.uglyNamingFunction2();
  }

  @Override
  public void fucntion3(ParamsWrapperDefinition paramsWrapper) {
    cd.tooManyParamsFunction3(paramsWrapper.getParamA(), paramsWrapper.getParamB());
  }

  @Override
  public void function4() {
    //...reimplement it
  }
}
