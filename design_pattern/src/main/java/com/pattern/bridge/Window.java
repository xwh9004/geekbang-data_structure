package com.pattern.bridge;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:58 on 2020/1/19
 * @version V0.1
 * @classNmae Window
 */
public abstract class Window {

    public IWindowImp windowImp;

    public void setWindowImp(IWindowImp windowImp){
       this.windowImp = windowImp;
    }

    public IWindowImp getWindowImp() {
        return windowImp;
    }

    abstract void open();

    abstract void close();

    abstract void draw();
}
