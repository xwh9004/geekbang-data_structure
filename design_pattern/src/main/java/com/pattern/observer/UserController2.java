package com.pattern.observer;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:05 on 2020/3/23
 * @version V0.1
 * @classNmae UserController
 */

public class UserController2 {
    @Setter
    private UserService userService; // 依赖注入

    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public UserController2() {
        eventBus = new EventBus(); // 同步阻塞模式
//        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE)); // 异步非阻塞模式
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public Long register(String telephone, String name) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        Long userId = userService.register(telephone, name);
        eventBus.post(userId);
        eventBus.post(name);
        return userId;
    }

    public static void main(String[] args) {
        UserController2 userController2 = new UserController2();
        RegPromotionObserver regPromotionObserver=new RegPromotionObserver();
        regPromotionObserver.setPromotionService(new PromotionService());
        RegNotificationObserver regNotificationObserver=  new RegNotificationObserver();
        regNotificationObserver.setNotificationService(new NotificationService());
        List<Object> list =new ArrayList<>();
        list.add(regPromotionObserver);
        list.add(regNotificationObserver);
        userController2.setUserService(new UserService());
        userController2.setRegObservers(list);
        userController2.register("15300518706","Jesse Hsu");


    }
}
