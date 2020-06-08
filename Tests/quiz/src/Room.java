import java.util.ArrayList;
import java.util.List;

public class Room extends Facility{
    private Building building;
    private String number;
    private int floor;
    private int capacity;
    private List<User> users;
    public Room(Building building, String number, int floor){
        if(building.getMaxFloor()<floor || floor<building.getMinFloor()) throw new IllegalArgumentException();
        for(Room room: building.getRooms()){
            if(room.getBuilding()==building && room.getFloor()==floor && room.getNumber()==number) throw new DuplicateRoomException();
        }
        this.building=building;
        this.number=number;
        this.floor=floor;
        this.users=new ArrayList<>();
        this.building.addRoom(this);
    }
    public Room(Building building, String number, int floor, int capacity){
        if(building.getMaxFloor()<floor || floor<building.getMinFloor()) throw new IllegalArgumentException();
        this.building=building;
        this.number=number;
        this.floor=floor;
        this.capacity=capacity;
        this.building.addCapacity(capacity);
        this.users=new ArrayList<>();
    }

    public void authorize(User user){
        this.users.add(user);
    }

    public boolean canEnter(User user){
        return this.users.contains(user);
    }

    public int getCapacity() {
        return capacity;
    }

    public Building getBuilding() {
        return building;
    }

    public int getFloor() {
        return floor;
    }

    public String getNumber() {
        return number;
    }
    public String getName() {
        return building.getName()+number;
    }

    @Override
    public String toString() {
        return "Room(" + building.getName() +","+ number +')';
    }
}
