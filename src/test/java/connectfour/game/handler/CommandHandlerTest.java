package connectfour.game.handler;

import connectfour.game.Game;
import connectfour.player.PlayerName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CommandHandlerTest {

    private Scanner scanner;
    private Game game;

    @BeforeEach
    public void setUp() {
        scanner = mock(Scanner.class);
        game = mock(Game.class);
    }

    @Test
    public void testStartPlayCommand() {
        when(scanner.nextLine()).thenReturn("Player1", "play", "exit");
        CommandHandler.start(scanner, game);
        verify(game, times(1)).play();
    }

    @Test
    public void testStartHighScoresCommand() {
        when(scanner.nextLine()).thenReturn("Player1", "hs", "exit");
        CommandHandler.start(scanner, game);
        // Add verification for high scores display if needed
    }

    @Test
    public void testStartExitCommand() {
        when(scanner.nextLine()).thenReturn("Player1", "exit");
        CommandHandler.start(scanner, game);
        verify(game, never()).play();
    }

    @Test
    public void testSetPlayerName() {
        when(scanner.nextLine()).thenReturn("Player1", "exit");
        CommandHandler.start(scanner, game);
        assertEquals("Player1", PlayerName.getName());
    }
}