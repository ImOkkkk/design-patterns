package service;

import java.util.List;
import java.util.Map;
import pojo.bo.RequestInfo;

/**
 * 当我们需要实现新的存储方式的时候，只需要实现 MetricsStorage 接口即可。
 *
 * @author ImOkkkk
 * @date 2022/7/7 16:12
 * @since 1.0
 */
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfos(String apiName, long startTime, long endTime);

    Map<String, List<RequestInfo>> getRequestInfos(long startTime, long endTime);
}
