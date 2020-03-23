package com.pattern.bridge;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:12 on 2020/1/19
 * @version V0.1
 * @classNmae IConWindowImp
 */
public class IConWindowImp implements IWindowImp {
    @Override
    public void openWindow() {
        System.out.println("open IconWindow");
    }

    @Override
    public void closeWindow() {
        System.out.println("close IconWindow");
    }

    @Override
    public void windowDraw() {
        System.out.println("drew icon");
    }
}
