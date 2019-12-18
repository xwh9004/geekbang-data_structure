package ch12;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Xu at 10:06 on 2019/12/18
 * @version V0.1
 * @classNmae Button
 */
public class Button implements ButtonServer {

    ButtonServer buttonServer;



    public Button(ButtonServer buttonServer){
        this.buttonServer = buttonServer;
    }



    public void turnOn() {
        buttonServer.turnOn();
    }

    public void turnOff() {
        buttonServer.turnOff();
    }
}
