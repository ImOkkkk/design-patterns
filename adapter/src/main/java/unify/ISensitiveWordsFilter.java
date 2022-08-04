package unify;

/**
 * 使用适配器模式进行改造
 * 统一接口定义
 *
 * @author ImOkkkk
 * @date 2022/8/2 13:26
 * @since 1.0
 */
public interface ISensitiveWordsFilter {
  String filter(String text);
}
