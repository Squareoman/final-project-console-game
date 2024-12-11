import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;

public class GameTest {

    @Test
    public void testYAML() {
        LoadYAML yl = new LoadYAML();
        Room room1 = yl.rooms.get("Starting Room");
        assertEquals(room1.name, "Starting Room");
    }
    
    @Test
    public void testLockedDoor() {
        GameState state = new GameState("TestPlayer");

        // Make sure the key is in the inventory
        state.inventory.add(state.items.get("golden_key"));
        
        // Try to move through the locked door
        state.room = state.rooms.get("Library");
        state.moveThroughDoor("red");
        
        // Check that the player is now in the "Secret Room"
        assertEquals("Secret Room", state.room.name);
    }

    @Test
    public void testEndingWithKey() {
        GameState state = new GameState("TestPlayer");

        // Add the key to the inventory
        state.inventory.add(state.items.get("golden_key"));

        // Simulate entering the "Secret Room"
        state.room = state.rooms.get("Secret Room");

        // Update the game state and check for the win condition
        String result = state.update();
        assertTrue(result.contains("You win!"));
    }

}
