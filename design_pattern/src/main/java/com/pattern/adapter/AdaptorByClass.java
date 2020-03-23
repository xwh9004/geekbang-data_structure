package com.pattern.adapter;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 11:06 on 2020/3/6
 * @version V0.1
 * @classNmae AdaptorByClass
 */
public class AdaptorByClass extends Adaptee implements ITarget {


    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        super.fb();
    }
}
