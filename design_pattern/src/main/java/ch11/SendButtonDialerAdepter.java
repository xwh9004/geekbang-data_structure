package ch11;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:57 on 2019/12/16
 * @version V0.1
 * @classNmae SendButtonDialerAdepter
 */
public class SendButtonDialerAdepter implements ButtonListener {

    private Dialer dialer;

    SendButtonDialerAdepter(Dialer dialer){
        this.dialer = dialer;
    }

    public void buttonPressed() {
        dialer.dial();
    }
}
