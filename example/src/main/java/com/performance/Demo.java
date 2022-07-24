package com.performance;

import com.performance.controller.MetricsCollector;
import com.performance.model.aggregator.Aggregator;
import com.performance.model.reporter.ConsoleReporter;
import com.performance.model.reporter.EmailReporter;
import com.performance.model.viewer.ConsoleViewer;
import com.performance.model.viewer.EmailViewer;
import com.performance.pojo.bo.RequestInfo;
import com.performance.service.MetricsStorage;
import com.performance.service.impl.RedisMetricsStorage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ImOkkkk
 * @date 2022/7/8 15:14
 * @since 1.0
 */
public class Demo {
    public static void main(String[] args) {
        MetricsStorage metricsStorage = new RedisMetricsStorage();
        Aggregator aggregator = new Aggregator();
        // 定时触发统计并将结果显示到终端
        ConsoleViewer consoleViewer = new ConsoleViewer();
        ConsoleReporter consoleReporter = new ConsoleReporter(metricsStorage, aggregator, consoleViewer);
        consoleReporter.startRepeatedReport(60, 60);

        // 定时触发统计并将结果输出到邮件
        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addToAddress("example@qq.com");
        EmailReporter emailReporter = new EmailReporter(metricsStorage, aggregator, emailViewer);
        emailReporter.startDailyReport();

        // 收集接口访问数据
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



        ConsoleReporter consoleReporter1 = new ConsoleReporter();
        consoleReporter1.startRepeatedReport(60, 60);

        List<String> emailToAddresses = new ArrayList<>();
        emailToAddresses.add("wangzheng@xzg.com");
        EmailReporter emailReporter1 = new EmailReporter(emailToAddresses);
        emailReporter.startDailyReport();

        MetricsCollector collector1 = new MetricsCollector();
        collector1.recordRequest(new RequestInfo("register", 123, 10234));
        collector1.recordRequest(new RequestInfo("register", 223, 11234));
        collector1.recordRequest(new RequestInfo("register", 323, 12334));
        collector1.recordRequest(new RequestInfo("login", 23, 12434));
        collector1.recordRequest(new RequestInfo("login", 1223, 14234));
    }
}
