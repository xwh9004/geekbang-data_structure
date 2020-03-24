package com.pattern.callback;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:44 on 2020/3/24
 * @version V0.1
 * @classNmae AClass
 */
public class AClass {

    public static void main(String[] args) {
        BClass b = new BClass();
        b.process(new ICallback() {
            //回调对象
            @Override
            public void methodToCallback() {
                System.out.println("Call back me.");
            }
        });
    }
}
