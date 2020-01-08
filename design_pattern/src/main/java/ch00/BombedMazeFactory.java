package ch00;


/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:59 on 2020/1/6
 * @version V0.1
 * @classNmae BombedMazeFactory
 */
public class BombedMazeFactory extends DefaultMazeFactory {


    @Override
    public Wall makeWall() {
        return new BombedWall();
    }

}
