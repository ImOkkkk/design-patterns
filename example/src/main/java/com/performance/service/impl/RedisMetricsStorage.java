package com.performance.service.impl;

import com.performance.pojo.bo.RequestInfo;
import com.performance.service.MetricsStorage;
import java.util.List;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/7/7 16:23
 * @since 1.0
 */
public class RedisMetricsStorage implements MetricsStorage {

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {}

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTime, long endTime) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTime, long endTime) {
        return null;
    }
}
