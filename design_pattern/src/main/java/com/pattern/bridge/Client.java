package com.pattern.bridge;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:16 on 2020/1/19
 * @version V0.1
 * @classNmae Client
 */
public class Client {

    public static void main(String[] args) {

        IConWindow iconWindow = new IConWindow();
        IConWindowImp iconWindowImp = new IConWindowImp();
        iconWindow.setWindowImp(iconWindowImp);
        iconWindow.open();
        iconWindow.drawIcon();
        iconWindow.close();
    }
}
