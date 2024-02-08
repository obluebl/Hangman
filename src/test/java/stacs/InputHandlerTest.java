package stacs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class InputHandlerTest {
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @BeforeEach
    public void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    public void testGetGuessedLetter_WithValidInput() {
        // Arrange
        String simulatedInput = "a\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        InputHandler inputHandler = new InputHandler();

        // Act
        char guessedLetter = inputHandler.getGuessedLetter();

        // Assert
        assertEquals('a', guessedLetter);
        assertEquals("Enter your guess (a single letter): ", outputStream.toString());
    }

    @Test
    public void testGetGuessedLetter_WithInvalidInputThenValidInput() {
        // Arrange
        String simulatedInput = "123\na\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        InputHandler inputHandler = new InputHandler();

        // Act
        char guessedLetter = inputHandler.getGuessedLetter();

        // Assert
        assertEquals('a', guessedLetter);
        assertTrue(outputStream.toString().contains("Invalid input. Please enter a single letter:"));
        assertTrue(outputStream.toString().contains("Enter your guess (a single letter): "));
    }
}
