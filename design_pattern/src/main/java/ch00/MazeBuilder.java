package ch00;

/**
 * <p><b>Description:</b>  抽象的Builder,定义了子类的创建Maze的通用接口
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:58 on 2020/1/6
 * @version V0.1
 * @classNmae MazeBuilder
 */
public abstract class MazeBuilder {

    MazeBuilder(){
    }

    void buildMaze(){};

    void buildRoom(int room){};

    void buildDoor(int form, int to){};

    Maze getMaze(){return null;};
}
