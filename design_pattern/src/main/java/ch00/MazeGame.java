package ch00;

import static ch00.Direction.*;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:33 on 2020/1/6
 * @version V0.1
 * @classNmae MazeGame
 */
public class MazeGame {

    /**
     * 构造一个迷宫
     * 该方法缺点 硬编码
     * @return
     */
    Maze createMaze(){
        Maze aMaze = new Maze();
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Door theDoor = new Door(r1,r2);
        aMaze.addRoom(r1);
        aMaze.addRoom(r2);

        r1.setSide(NORTH,new Wall());
        r1.setSide(EAST,theDoor);
        r1.setSide(SOUTH,new Wall());
        r1.setSide(WEST,new Wall());

        r2.setSide(NORTH,new Wall());
        r2.setSide(EAST,new Wall());
        r2.setSide(SOUTH,new Wall());
        r2.setSide(WEST,theDoor);

        return  aMaze;
    }

    /**
     * 抽象工厂模式产生Maze实例
     * @param factory
     * @return
     */
    Maze createMaze(MazeFactory factory){
        Maze aMaze = factory.makeMaze();
        Room r1 =factory.makeRoom(1);
        Room r2 =factory.makeRoom(2);
        Door theDoor = factory.makeDoor(r1,r2);
        //.....
        aMaze.addRoom(r1);
        aMaze.addRoom(r2);
        r1.setSide(NORTH, factory.makeWall());
        r1.setSide(EAST,theDoor);
        r1.setSide(SOUTH,factory.makeWall());
        r1.setSide(WEST,factory.makeWall());

        r2.setSide(NORTH,factory.makeWall());
        r2.setSide(EAST,factory.makeWall());
        r2.setSide(SOUTH,factory.makeWall());
        r2.setSide(WEST,theDoor);
        return aMaze;
    }

    /**
     * 建造者模式产生Maze实例
     * @param builder
     * @return
     */
    Maze createMaze(MazeBuilder builder){
         builder.buildMaze();
         builder.buildRoom(1);
         builder.buildRoom(2);
         builder.buildDoor(1,2);
        return builder.getMaze();
    }
}
