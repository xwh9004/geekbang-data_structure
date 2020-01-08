package ch00;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by  at 15:01 on 2020/1/6
 * @version V0.1
 * @classNmae DefaultMazeFactory
 */
public class DefaultMazeFactory implements MazeFactory{
    @Override
    public Maze makeMaze() {
        return new Maze();
    }

    @Override
    public Wall makeWall() {
        return new Wall();
    }

    @Override
    public Room makeRoom(int roomNo) {
        return new Room(roomNo);
    }

    @Override
    public Door makeDoor(Room from, Room to) {
        return new Door(from,to);
    }
}
