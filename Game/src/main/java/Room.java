import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Room {
    public String name;
    public List<Item> contents;
    public Map<String, String> doors;
    public Map<String, Boolean> lockedDoors;  // Map to track locked doors

    public Room(String name, List<Item> contents, Map<String, String> doors, Map<String, Boolean> lockedDoors) {
        this.name = name;
        this.contents = contents;
        this.doors = doors;
        this.lockedDoors = lockedDoors;
    }

    public String toString() {
        return name;
    }
}
