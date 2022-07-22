package com.performance.controller;

import cn.hutool.core.util.StrUtil;
import com.performance.pojo.bo.RequestInfo;
import com.performance.service.MetricsStorage;

/**
 * MetricsCollector 负责采集和存储数据，它基于接口而非实现编程，通过依赖注入的方式来传递 MetricsStorage 对象，可以在不需要修改代码的情况
 * 下，灵活地替换不同的存储方式，满足开闭原则。
 *
 * @author ImOkkkk
 * @date 2022/7/7 16:08
 * @since 1.0
 */
public class MetricsCollector {

    private MetricsStorage metricsStorage;

    // 依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StrUtil.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
