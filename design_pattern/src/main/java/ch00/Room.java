package ch00;


/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:47 on 2020/1/6
 * @version V0.1
 * @classNmae Room
 */
public class Room implements MapSite {


    private MapSite[] mapSites = new MapSite[4];

    private int roomNo;

    Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public void setSide(Direction direction, MapSite mapSite) {
        if (mapSites[direction.ordinal()] != null) {
            mapSites[direction.ordinal()] = mapSite;
        } else {
            throw new UnsupportedOperationException(direction.name()+" mapSite already existed");
        }
    }

    MapSite getSide(Direction direction) {
        return mapSites[direction.ordinal()];
    }

    public int getRoomNo() {
        return roomNo;
    }

    @Override
    public void Enter() {
        System.out.println("记录一间房");
    }
}
