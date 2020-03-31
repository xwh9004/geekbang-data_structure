package com.pattern.chain;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 11:09 on 2020/3/30
 * @version V0.1
 * @classNmae HandlerChain
 */
public class HandlerChain {

    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
