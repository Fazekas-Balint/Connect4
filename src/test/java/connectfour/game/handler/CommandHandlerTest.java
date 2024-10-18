package connectfour.game.handler;

import connectfour.game.Game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class CommandHandlerTest {
    @Test
    public void testStart() {
        // Létrehozunk egy Game mock objektumot
        Game game = Mockito.mock(Game.class);

        // Teszteljük, hogy a játék elindul-e, ha a felhasználó "Start" szót ír be
        String input = "Start\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        CommandHandler.start(scanner, game);
        // Ellenőrizzük, hogy a play metódus pontosan egyszer hívódott meg
        Mockito.verify(game, Mockito.times(1)).play();

        // Reset the input stream
        System.setIn(System.in);

        // Test that the game does not start when the user types something else first, then "Start"
        input = "Hello\nStart\n";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        CommandHandler.start(scanner, game);
        // Ellenőrizzük, hogy a play metódus pontosan kétszer hívódott meg (1 korábbi és 1 új hívás)
        Mockito.verify(game, Mockito.times(2)).play();

        // Újraindítjuk az input streamet
        System.setIn(System.in);

        // teszteljük, hogy a játék elindul-e, ha a felhasználó "Start" szót ír be, majd újra "Start" szót ír be
        input = "start\n";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        CommandHandler.start(scanner, game);
        // Ellenőrizzük, hogy a play metódus pontosan háromszor hívódott meg (2 korábbi és 1 új hívás)
        Mockito.verify(game, Mockito.times(3)).play();

        // Újraindítjuk az input streamet
        System.setIn(System.in);
    }
}



