package com.pattern.observer;

import lombok.Data;
import lombok.Setter;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by  Jesse Hsu at 16:03 on 2020/3/23
 * @version V0.1
 * @classNmae RegNotificationObserver
 */

public class RegNotificationObserver {

    @Setter
    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(Long userId) {
        notificationService.sendInboxMessage(userId, "Welcome...");
    }
    @Subscribe
    public void handleRegSuccess_1(String name) {
        notificationService.sendInboxMessage("Welcome..."+name);
    }
}
