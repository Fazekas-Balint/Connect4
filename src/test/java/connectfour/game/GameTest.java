package connectfour.game;

import connectfour.board.Board;
import connectfour.game.checker.WinChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {

    private Game game;
    private Board mockBoard;
    private WinChecker mockWinChecker;
    private Random mockRandom;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockBoard = mock(Board.class);
        mockWinChecker = mock(WinChecker.class);
        mockRandom = mock(Random.class);
        game = new Game();
        game.mockgame(mockBoard, mockWinChecker, mockRandom);
    }

    @Test
    public void testMockGameInitialization() {
        // A játék objektum inicializálása a mock objektumokkal
        game.mockgame(mockBoard, mockWinChecker, mockRandom);

        // Ellenőrizzük, hogy a játék objektum megkapta-e a megfelelő mock objektumokat
        assertEquals(mockBoard, game.getBoard(), "The board should be the mock object.");
        assertEquals(mockWinChecker, game.getWinChecker(), "The winChecker should be the mock object.");
        assertEquals('S', game.getCurrentPlayer(), "The first player should be 'S'.");
    }

    @Test
    public void testPlay_HumanWins() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "2\n2\n2\n"; // Ember játékos 2. oszlopba rakja a követ, majd a gépi játékos 2. oszlopba
        // rakja a követ, majd az ember játékos 2. oszlopba rakja a követ
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        when(mockBoard.isColumnFull(anyInt())).thenReturn(false);
        when(mockBoard.isFull()).thenReturn(false);
        doReturn(new char[6][7]).when(mockBoard).getBoard(); // Üres tábla
        doReturn(true).when(mockWinChecker).checkWin(any(char[][].class), eq('S'));

        doNothing().when(mockBoard).displayBoard();
        doNothing().when(mockBoard).dropPiece(anyInt(), eq('S'));

        // Act
        game.play();

        // Assert
        String output = outContent.toString().trim();
        assertTrue(output.contains("Player S won!")); // A játékos S nyert
    }
}