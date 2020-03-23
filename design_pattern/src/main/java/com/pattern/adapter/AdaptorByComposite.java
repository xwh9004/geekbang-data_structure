package com.pattern.adapter;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 11:06 on 2020/3/6
 * @version V0.1
 * @classNmae AdaptorByClass
 */
public class AdaptorByComposite implements ITarget {

    private  Adaptee adaptee;

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        adaptee.fb();
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
