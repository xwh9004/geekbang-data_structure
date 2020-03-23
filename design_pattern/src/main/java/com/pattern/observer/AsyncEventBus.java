package com.pattern.observer;

import java.util.concurrent.Executor;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:09 on 2020/3/23
 * @version V0.1
 * @classNmae AsyncEventBus
 */

public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}