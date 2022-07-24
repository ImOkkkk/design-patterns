package com.performance.model.viewer;

import com.performance.model.sender.EmailSender;
import com.performance.pojo.bo.RequestStat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/7/24 15:59
 * @since 1.0
 */
public class EmailViewer implements StatViewer {

    private EmailSender emailSender;
    private List toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender(/*省略参数*/ );
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    @Override
    public void output(
            Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        // format the requestStats to HTML style.
        // send it to email toAddresses.
    }
}
