package ch26;

import java.util.List;
import java.util.Map;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:40 on 2020/1/6
 * @version V0.1
 * @classNmae RedisMetricsStorage
 */
public class RedisMetricsStorage implements  MetricsStorage {
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis) {
        return null;
    }

    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
        return null;
    }
}
