package connectfour.game.handler;

import connectfour.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

class CommandHandlerTest {

    @Mock
    private Game game;

    private Runnable mockExitHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockExitHandler = mock(Runnable.class);
    }

    @Test
    void testStart_ExitCommand() {
        String input = "Player1\nexit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        boolean result = CommandHandler.start(scanner, game, mockExitHandler);

        verify(mockExitHandler, times(1)).run();
        assertFalse(result, "The game should not be won.");
    }

    @Test
    void testStart_InvalidCommand() {
        String input = "Player1\ninvalid\nexit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        boolean result = CommandHandler.start(scanner, game, mockExitHandler);

        verify(game, never()).play();
        verify(mockExitHandler, times(1)).run();
        assertFalse(result, "The game should not be won.");
    }
}