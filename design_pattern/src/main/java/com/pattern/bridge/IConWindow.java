package com.pattern.bridge;

/**
 * <p><b>Description:</b>
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:06 on 2020/1/19
 * @version V0.1
 * @classNmae IConWindow
 */
public class IConWindow extends Window {

    @Override
    void open() {
        getWindowImp().openWindow();
    }

    @Override
    void close() {
        getWindowImp().closeWindow();
    }

    @Override
    void draw() {
        getWindowImp().windowDraw();
        System.out.println("filled in red");
    }

    void drawIcon(){
        draw();

    }
}
