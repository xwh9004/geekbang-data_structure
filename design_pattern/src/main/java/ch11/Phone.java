package ch11;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:33 on 2019/12/16
 * @version V0.1
 * @classNmae Phone
 */
public class Phone {
    private Dialer dialer;
    private Button[] digitButtons;
    private Button sendButton;

    public Phone() {
        dialer = new Dialer();
        digitButtons = new Button[10];
        for (int i = 0; i < digitButtons.length; i++) {
            digitButtons[i] = new Button();
            digitButtons[i].addListener(new DigitButtonDialerAdepter(i,dialer));
        }
        sendButton = new Button();
        sendButton.addListener(new SendButtonDialerAdepter(dialer));
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.digitButtons[9].press();
        phone.digitButtons[1].press();
        phone.digitButtons[1].press();
        phone.sendButton.press();
    }
}
