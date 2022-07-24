package com.performance.model.viewer;

import com.alibaba.fastjson.JSON;
import com.performance.pojo.bo.RequestStat;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/7/24 15:58
 * @since 1.0
 */
public class ConsoleViewer implements StatViewer{

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis,
        long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        System.out.println(JSON.toJSONString(requestStats));
    }
}
