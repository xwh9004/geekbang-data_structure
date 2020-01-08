package ch00;

import java.util.ArrayList;
import java.util.List;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:15 on 2020/1/6
 * @version V0.1
 * @classNmae Maze
 */
public class Maze {

    List<Room> rooms ;

    Maze() {
        rooms= new ArrayList<>();
    }

    void addRoom(Room room) {
        rooms.add(room.getRoomNo(),room);
    }

    Room getRoom(int roomNo) {
        return rooms.get(roomNo);
    }
}
