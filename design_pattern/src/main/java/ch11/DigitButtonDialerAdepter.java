package ch11;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:56 on 2019/12/16
 * @version V0.1
 * @classNmae DigitButtonDialerAdepter
 */
public class DigitButtonDialerAdepter implements ButtonListener {

    private Dialer dialer;

    private int token;

    DigitButtonDialerAdepter(int token,Dialer dialer) {
        this.token =token;
        this.dialer =dialer;
    }

    public void buttonPressed() {
        dialer.enterDigit(token);
    }
}
