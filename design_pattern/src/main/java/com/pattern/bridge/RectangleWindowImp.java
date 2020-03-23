package com.pattern.bridge;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:15 on 2020/1/19
 * @version V0.1
 * @classNmae RectangleWindowImp
 */
public class RectangleWindowImp implements IWindowImp {
    @Override
    public void openWindow() {
        System.out.println("open rectangle window");
    }

    @Override
    public void closeWindow() {
        System.out.println("close rectangle window");
    }

    @Override
    public void windowDraw() {
        System.out.println("drew rectangle");
    }
}
