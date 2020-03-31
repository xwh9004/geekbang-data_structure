package com.pattern.chain;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 11:11 on 2020/3/30
 * @version V0.1
 * @classNmae AbstractHandler
 */
public abstract class AbstractHandler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle() {
        boolean handled = doHandle();
        if (successor != null && !handled) {
            successor.handle();
        }
    }

    protected abstract boolean doHandle();
}
