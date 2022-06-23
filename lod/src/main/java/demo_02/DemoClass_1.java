package demo_02;

/**
 * 尽管还是要往 demo_02.DemoClass_1 的构造函数中，传入包含序列化和反序列化的 demo_02.Serialization 实现类，但是，依赖的 demo_02.Serializable 接口只包含序列化操作，
 * demo_02.DemoClass_1 无法使用 demo_02.Serialization 类中的反序列化接口，对反序列化操作无感知，符合迪米特法则后半部分所说的“依赖有限接口”的要求。
 *
 * @author ImOkkkk
 * @date 2022/6/23 16:34
 * @since 1.0
 */
public class DemoClass_1 {
  private Serializable serializable;

  public DemoClass_1(Serializable serializable) {
    this.serializable = serializable;
  }
}
