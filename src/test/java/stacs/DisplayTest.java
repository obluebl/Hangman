package stacs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisplayTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Display display;
    private GameState gameState;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        display = new Display();
        gameState = new GameState("maven", 6); // Assume GameState is already tested and working
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testShowCurrentStateInitial() {
        gameState.isCorrectLetter('z'); // Make one incorrect guess to test output
        display.showCurrentState(gameState);
        String output = outContent.toString();
        assertTrue(output.contains("_ _ _ _ _") && output.contains("Guessed letters: [z]"), "Initial state display does not match expected output.");
    }

    @Test
    void testDrawHangmanInitial() {
        display.drawHangman(6, 6);
        String output = outContent.toString();
        assertTrue(output.contains("    +---+\n    |   |\n        |\n        |\n        |\n    ===="), "Hangman drawing for 0 incorrect guesses does not match.");
    }

    @Test
    void testShowWinMessage() {
        // Assuming gameState calculates score based on remaining guesses
        gameState.isCorrectLetter('m');
        gameState.isCorrectLetter('a');
        gameState.isCorrectLetter('v');
        gameState.isCorrectLetter('e');
        gameState.isCorrectLetter('n');
        display.showWinMessage(gameState);
        String output = outContent.toString();
        assertTrue(output.contains("Congratulations, you won!"), "Win message does not match expected output.");
    }

    @Test
    void testShowLoseMessage() {
        display.showLoseMessage("maven");
        String output = outContent.toString();
        assertTrue(output.contains("Sorry, you lost. The correct word was: maven"), "Lose message does not match expected output.");
    }
}

