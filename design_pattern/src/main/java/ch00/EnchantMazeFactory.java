package ch00;

/**
 * <p><b>Description:</b>
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:53 on 2020/1/6
 * @version V0.1
 * @classNmae EnchantMazeFactory
 */
public class EnchantMazeFactory extends DefaultMazeFactory {

    @Override
    public Room makeRoom(int roomNo) {
          return new EnchantedRoom(roomNo);
    }

    @Override
    public Door makeDoor(Room from, Room to) {
        return new DoorNeedingSpell(from,to);
    }
}
