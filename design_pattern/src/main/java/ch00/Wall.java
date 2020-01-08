package ch00;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:49 on 2020/1/6
 * @version V0.1
 * @classNmae Wall
 */
public  class Wall implements MapSite {

    @Override
    public void Enter() {
        System.out.println("进入一堵墙");
    }
}
