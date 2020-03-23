package com.pattern.observer;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by  at 16:03 on 2020/3/23
 * @version V0.1
 * @classNmae NotificationService
 */
public class NotificationService {
    public void sendInboxMessage(long userId,String  msg){
        System.out.println("sendInboxMessage done "+userId +" "+msg);
    }

    public void sendInboxMessage(String  msg){
        System.out.println("sendInboxMessage done" + msg);
    }
}
