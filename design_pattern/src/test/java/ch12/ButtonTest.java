package ch12;

import org.junit.Test;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:23 on 2019/12/18
 * @version V0.1
 * @classNmae ButtonTest
 */
public class ButtonTest {

    @Test
    public void test(){
        Button engineBtn = new Button(new Engine());
        Button lampBtn = new Button(new Lamp());
        engineBtn.turnOn();
        lampBtn.turnOn();
    }
}
