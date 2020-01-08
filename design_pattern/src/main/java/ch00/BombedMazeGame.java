package ch00;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:19 on 2020/1/7
 * @version V0.1
 * @classNmae BombedMazeGame
 */
public class BombedMazeGame extends DefaultMazeGame {


    @Override
    Wall makeWall() {
        return new BombedWall();
    }
}
