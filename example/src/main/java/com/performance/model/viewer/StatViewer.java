package com.performance.model.viewer;

import com.performance.pojo.bo.RequestStat;
import java.util.Map;

/**
 * @author ImOkkkk
 * @date 2022/7/24 15:56
 * @since 1.0
 */
public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
