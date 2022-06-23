package demo_02;

/**
 * @author ImOkkkk
 * @date 2022/6/23 16:32
 * @since 1.0
 */
public class Serialization implements Serializable, Deserializable {

  @Override
  public Object deserialize(String text) {
    Object deserializeResult = new Object();
    return deserializeResult;
  }

  @Override
  public String serialize(Object obj) {
    String serializeResult = "serializeResult";
    return serializeResult;
  }
}
