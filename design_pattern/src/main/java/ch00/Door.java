package ch00;

import java.util.Map;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:57 on 2020/1/6
 * @version V0.1
 * @classNmae Door
 */
public  class Door implements MapSite {

    private Room from;

    private Room to;

    private boolean isOpen;

    Door(Room from,Room to){
        this.from = from;
        this.to = to;

    }

    @Override
    public void Enter() {
        System.out.println("进入一扇门");
    }
}
