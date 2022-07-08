package service.impl;

import java.util.List;
import java.util.Map;
import pojo.bo.RequestInfo;
import service.MetricsStorage;

/**
 * @author ImOkkkk
 * @date 2022/7/7 16:23
 * @since 1.0
 */
public class RedisMetricsStorage implements MetricsStorage {

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTime, long endTime) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTime, long endTime) {
        return null;
    }
}
