package ch00;

import static ch00.Direction.*;
import static ch00.Direction.WEST;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:27 on 2020/1/6
 * @version V0.1
 * @classNmae StandardMazeBuilder
 */
public class StandardMazeBuilder extends MazeBuilder {

    private Maze maze;



    @Override
    void buildMaze() {
        super.buildMaze();
        maze = new Maze();
    }


    @Override
    void buildRoom(int roomNo) {
        if(maze.getRoom(roomNo)!=null){
            Room room = new Room(roomNo);
            maze.addRoom(room);
            room.setSide(NORTH, new Wall());
            room.setSide(EAST,new Wall());
            room.setSide(SOUTH,new Wall());
            room.setSide(WEST,new Wall());
        }
    }

    @Override
    void buildDoor(int form, int to) {
        Room r1 = maze.getRoom(form);
        Room r2 = maze.getRoom(to);
        Door door = new Door(r1,r2);
        r1.setSide(commonWall(r1,r2),door);
        r2.setSide(commonWall(r2,r1),door);
    }

    private Direction commonWall(Room r1, Room r2) {
        return NORTH;
    }

    @Override
    public Maze getMaze() {
        return maze;
    }
}
