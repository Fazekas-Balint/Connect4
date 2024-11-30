package connectfour.game.handler;

import connectfour.game.Game;
import connectfour.db.PlayerDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

class CommandHandlerTest {

    @Mock
    private Game game;

    @Mock
    private PlayerDAO playerDAO;

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

        boolean result = CommandHandler.start(scanner, game, playerDAO, mockExitHandler);

        verify(mockExitHandler, times(1)).run();
        assertFalse(result, "The game should not be won.");
    }

    @Test
    void testStart_InvalidCommand() {
        String input = "Player1\ninvalid\nexit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        boolean result = CommandHandler.start(scanner, game, playerDAO, mockExitHandler);

        verify(game, never()).play();
        verify(mockExitHandler, times(1)).run();
        assertFalse(result, "The game should not be won.");
    }

    @Test
    void testDisplayHighScores() {
        String input = "Player1\nhs\nexit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Map<String, Integer> winCounts = Map.of("Player1", 5, "Player2", 3);
        when(playerDAO.getWinCounts()).thenReturn(winCounts);

        CommandHandler.start(scanner, game, playerDAO, mockExitHandler);

        verify(playerDAO, times(1)).getWinCounts();
        verify(mockExitHandler, times(1)).run();
    }
}