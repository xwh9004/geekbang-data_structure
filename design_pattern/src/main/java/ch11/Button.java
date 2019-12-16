package ch11;

import java.util.ArrayList;
import java.util.List;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:34 on 2019/12/16
 * @version V0.1
 * @classNmae Button
 */
public class Button {
    private List<ButtonListener> listeners;

    public Button() {
        this.listeners = new ArrayList<ButtonListener>();
    }

    public void addListener(ButtonListener listener){
        listeners.add(listener);
    }

    public void press() {
       for (ButtonListener listener:listeners){
           listener.buttonPressed();
       }
    }
}
