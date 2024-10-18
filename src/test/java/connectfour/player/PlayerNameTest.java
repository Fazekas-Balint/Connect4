package connectfour.player;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerNameTest {
    @Test
    void testPlayerNameInput() {
        // Beállítjuk a szimulált inputot
        String simulatedInput = "Leonidas\n"; // A játékos neve
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // Létrehozunk egy játékost
        PlayerName player = new PlayerName();

        // Ellenőrizzük a játékos nevét
        assertEquals("Leonidas", player.getName(), "The player's name should be 'Leonidas'.");
        player.printName();
    }

}
