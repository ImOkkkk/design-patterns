package domain;

import cn.hutool.core.codec.Base64;
import domain.storage.MemoryCredentialStorage;
import java.nio.charset.StandardCharsets;
import service.ApiAuthencator;
import service.impl.DefaultApiAuthencatorImpl;

/**
 * @author ImOkkkk
 * @date 2022/6/2 14:35
 * @since 1.0
 */
public class Demo {

  /**
   * 调用方进行接口请求的时候，将 URL、AppID、密码、时间戳拼接在一起，通过加密算 法生成 token，并且将 token、AppID、时间戳拼接在 URL 中，一并发送到微服务端。
   * 微服务端在接收到调用方的接口请求之后，从请求中拆解出 token、AppID、时间戳。 微服务端首先检查传递过来的时间戳跟当前时间，是否在 token 失效时间窗口内。如果
   * 已经超过失效时间，那就算接口调用鉴权失败，拒绝接口调用请求。 如果 token 验证没有过期失效，微服务端再从自己的存储中，取出 AppID 对应的密 码，通过同样的 token
   * 生成算法，生成另外一个 token，与调用方传递过来的 token 进 行匹配。如果一致，则鉴权成功，允许接口调用；否则就拒绝接口调用。
   */
  public static void main(String[] args) {
    //encodeUrl();
    MemoryCredentialStorage memoryCredentialStorage = new MemoryCredentialStorage();
    String url =
        "https://www.baidu.com/?appId=id1&token=aHR0cHM6Ly93d3cuYmFpZHUuY29tLz9hcHBJZD1pZDEmcGFzc3dvcmQ9cDEmdGltZXN0YW1wPTE2NTQxNTIxNzk2NzU&timestamp=1654152179675";
    ApiAuthencator apiAuthencator = new DefaultApiAuthencatorImpl(memoryCredentialStorage);
    apiAuthencator.auth(url);
  }

  public static void encodeUrl() {
    long timestamp = System.currentTimeMillis();
    System.out.println(timestamp);
    String url = "https://www.baidu.com/?appId=id1&password=p1&timestamp=" + timestamp;
    String token = Base64.encodeUrlSafe(url.getBytes(StandardCharsets.UTF_8));
    System.out.println(token);
  }
}
