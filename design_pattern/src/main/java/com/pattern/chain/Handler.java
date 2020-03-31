package com.pattern.chain;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 11:04 on 2020/3/30
 * @version V0.1
 * @classNmae Handler
 */
public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract boolean handle();
}
