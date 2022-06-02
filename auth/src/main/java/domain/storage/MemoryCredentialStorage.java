package domain.storage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/6/1 16:36
 * @since 1.0
 */
public class MemoryCredentialStorage implements CredentialStorage {

  private Map<String, String> appId2Password = new HashMap<>();

  public MemoryCredentialStorage() {
    appId2Password.put("id1", "p1");
    appId2Password.put("id2", "p2");
    appId2Password.put("id3", "p3");
    appId2Password.put("id4", "p4");
  }

  @Override
  public String getPasswordByAppId(String appId) {
    return appId2Password.get(appId);
  }
}
