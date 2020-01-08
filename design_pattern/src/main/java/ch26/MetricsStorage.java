package ch26;

import java.util.List;
import java.util.Map;

/**
 * 统计数据的存储
 */
public interface MetricsStorage {

    public void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
