import java.util.ArrayList;
import java.util.List;

public class Building extends  Facility{
    private String name;
    private int minFloor;
    private int maxFloor;
    private int capacity;
    private List<Room> rooms;
    public Building(String name, int minFloor, int maxFloor){
        if(minFloor>maxFloor) throw new IllegalArgumentException();
        this.name=name;
        this.minFloor=minFloor;
        this.maxFloor=maxFloor;
        this.capacity=0;
        this.rooms=new ArrayList<>();
    }
    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addCapacity(int capacity){
        this.capacity+=capacity;
    }

    public boolean canEnter(User user){
        for(Room room: rooms){
            if(room.canEnter(user)) return true;
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }
    @Override
    public String toString() {
        return "Building(" + name +')';
    }
}
