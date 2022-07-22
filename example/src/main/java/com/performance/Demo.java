package com.performance;

import com.performance.controller.MetricsCollector;
import com.performance.model.reporter.ConsoleReporter;
import com.performance.model.reporter.EmailReporter;
import com.performance.pojo.bo.RequestInfo;
import com.performance.service.MetricsStorage;
import com.performance.service.impl.RedisMetricsStorage;

/**
 * @author ImOkkkk
 * @date 2022/7/8 15:14
 * @since 1.0
 */
public class Demo {
    public static void main(String[] args) {
        MetricsStorage metricsStorage = new RedisMetricsStorage();
        ConsoleReporter consoleReporter = new ConsoleReporter(metricsStorage);
        consoleReporter.startRepeatedReport(60, 60);

        EmailReporter emailReporter = new EmailReporter(metricsStorage);
        emailReporter.addToAddress("example@qq.com");
        emailReporter.startDailyReport();

        MetricsCollector collector = new MetricsCollector(metricsStorage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
