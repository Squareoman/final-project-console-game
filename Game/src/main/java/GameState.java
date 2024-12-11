import java.util.*;

// Tracks global game state
// Useful for implementing state-based behavior (ex: see something new on second visit to room)

public class GameState {
    HashMap<Room, Boolean> visited = new HashMap<Room, Boolean>();
    String name;
    boolean finished;
    Room room;
    List<Item> inventory = new ArrayList<Item>();
    Map<String, Room> rooms; // global list of rooms
    Map<String, Item> items; // global list of known items

    public String update() {
        // Check if the player is in the Secret Room and has the golden key
        if (room.name.equals("Secret Room") && inventory.contains(items.get("golden_key"))) {
            finished = true;
            String finalText = """
                               You use the golden key to unlock a mysterious chest. Inside, you find a rare treasure.
                               With the treasure in hand, you return to the library, ready to leave the adventure behind.
                               You win!
                               """;
            return finalText;
        }
        return "";
    }
    
    

    public GameState(String name) {
        this.name = name;
        finished = false;
        LoadYAML yl = new LoadYAML();
        rooms = yl.rooms;
        items = yl.items;
        room = rooms.get("Starting Room");
        visited.put(room, true);
        inventory.add(items.get("book"));
    }
}
