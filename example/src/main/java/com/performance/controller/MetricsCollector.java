package com.performance.controller;

import cn.hutool.core.util.StrUtil;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.performance.pojo.bo.RequestInfo;
import com.performance.service.MetricsStorage;
import com.performance.service.impl.RedisMetricsStorage;
import java.util.concurrent.Executors;

/**
 * MetricsCollector 负责采集和存储数据，它基于接口而非实现编程，通过依赖注入的方式来传递 MetricsStorage 对象，可以在不需要修改代码的情况
 * 下，灵活地替换不同的存储方式，满足开闭原则。
 *
 * @author ImOkkkk
 * @date 2022/7/7 16:08
 * @since 1.0
 */
public class MetricsCollector {
    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;

    private EventBus eventBus;

    private MetricsStorage metricsStorage;

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public MetricsCollector() {
        this(new RedisMetricsStorage());
    }

    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public MetricsCollector(MetricsStorage metricsStorage) {
        this(metricsStorage, DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    public MetricsCollector(MetricsStorage metricsStorage, int threadNumToSaveData) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
        this.eventBus.register(new EventListener());
    }

    /**
     * “生产者 - 消费者”模型或者“发布 - 订阅”模型，
     * 采集的数据先放入内存共享队列中，另一个线程读取共享队列中的数据，写入到外部存储（比如 Redis）中
     * @param requestInfo
     */
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StrUtil.isBlank(requestInfo.getApiName())) {
            return;
        }
        eventBus.post(requestInfo);
    }
    public class EventListener {
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }
}
