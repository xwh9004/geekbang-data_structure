package ch12;

/**
 * <p><b>Description:</b>
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:20 on 2019/12/18
 * @version V0.1
 * @classNmae Engine
 */
public class Engine implements ButtonServer {
    public void turnOn() {
        System.out.println("Engine starting...");
    }

    public void turnOff() {
        System.out.println("Engine stopping...");
    }
}
