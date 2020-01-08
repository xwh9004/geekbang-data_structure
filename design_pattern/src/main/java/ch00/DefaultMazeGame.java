package ch00;

import static ch00.Direction.*;
import static ch00.Direction.WEST;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:15 on 2020/1/7
 * @version V0.1
 * @classNmae DefaultMazeGame
 */
public abstract class DefaultMazeGame {

    Maze makeMaze(){
        return new Maze();
    }

    Room makeRoom(int no){
        return new Room(no);
    }

    Wall makeWall(){
        return new Wall();
    }

    Door makeDoor(Room from,Room to){
        return new Door(from,to);
    }

     Maze createMaze(){
         Maze aMaze = makeMaze();
         Room r1 = makeRoom(1);
         Room r2 = makeRoom(2);
         Door theDoor = new Door(r1,r2);
         aMaze.addRoom(r1);
         aMaze.addRoom(r2);

         r1.setSide(NORTH,makeWall());
         r1.setSide(EAST,makeDoor(r1,r2));
         r1.setSide(SOUTH,makeWall());
         r1.setSide(WEST,makeWall());

         r2.setSide(NORTH,makeWall());
         r2.setSide(EAST,makeWall());
         r2.setSide(SOUTH,makeWall());
         r2.setSide(WEST,makeDoor(r2,r1));
         return aMaze;
     };
}
