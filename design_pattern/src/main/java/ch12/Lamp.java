package ch12;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:17 on 2019/12/18
 * @version V0.1
 * @classNmae Lamp
 */
public class Lamp implements ButtonServer {

    public void turnOn() {
        System.out.println("light on...");
    }

    public void turnOff() {
        System.out.println("light off...");
    }
}
