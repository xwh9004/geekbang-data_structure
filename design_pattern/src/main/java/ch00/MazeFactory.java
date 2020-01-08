package ch00;

/**
 * <p><b>Description:</b>  抽象接口 创建Maze组件的工厂
 * 提前定义好能创建的Maze组件
 * 具体组件由具体工厂创建
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:43 on 2020/1/6
 * @version V0.1
 * @classNmae WidgetFactory
 */
public interface MazeFactory {

    Maze makeMaze();

    Wall makeWall();

    Room makeRoom(int roomNo);

    Door makeDoor(Room from,Room to);


}
