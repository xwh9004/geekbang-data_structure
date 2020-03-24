package com.pattern.callback;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:43 on 2020/3/24
 * @version V0.1
 * @classNmae BClass
 */
public class BClass {

    public void process(ICallback callback) {
        callback.methodToCallback();
    }
}
