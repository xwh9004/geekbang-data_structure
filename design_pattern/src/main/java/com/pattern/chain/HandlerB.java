package com.pattern.chain;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 11:05 on 2020/3/30
 * @version V0.1
 * @classNmae HandlerA
 */
public class HandlerB extends Handler {

    @Override
    public boolean handle() {
        boolean handled = false;
        //...business code

        if (!handled && successor != null) {
           return successor.handle();
        }
        return handled;
    }
}