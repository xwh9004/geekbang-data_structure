package ch26;

import util.StringUtils;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:29 on 2020/1/6
 * @version V0.1
 * @classNmae MetricsCollector
 */
public class MetricsCollector {

    private MetricsStorage metricsStorage;//基于接口而非实现编程


    MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
