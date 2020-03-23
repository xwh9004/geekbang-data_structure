package com.pattern.observer;

import lombok.Setter;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:02 on 2020/3/23
 * @version V0.1
 * @classNmae RegPromotionObserver
 */
public class RegPromotionObserver {
    @Setter
    private PromotionService promotionService; // 依赖注入
    @Subscribe

    public void handleRegSuccess(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
