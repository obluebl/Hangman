package stacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    GameState gameState;

    @BeforeEach
    void setUp() {
        gameState = new GameState("maven", 6);
    }

    @Test
    void testIsCorrectLetterWithCorrectGuess() {
        assertTrue(gameState.isCorrectLetter('m'), "Guessing 'm' should be marked as correct.");
    }

    @Test
    void testIsCorrectLetterWithIncorrectGuess() {
        assertFalse(gameState.isCorrectLetter('z'), "Guessing 'z' should be marked as incorrect.");
    }

    @Test
    void testGetGuessRemainingAfterCorrectGuess() {
        gameState.isCorrectLetter('m');
        assertEquals(6, gameState.getGuessReminding(), "Guess remaining should not decrease after a correct guess.");
    }

    @Test
    void testGetGuessRemainingAfterIncorrectGuess() {
        gameState.isCorrectLetter('z');
        assertEquals(5, gameState.getGuessReminding(), "Guess remaining should decrease after an incorrect guess.");
    }

    @Test
    void testGetMaxWrongGuesses() {
        assertEquals(6, gameState.getMaxWrongGuesses(), "Max wrong guesses should match the initial value.");
    }

    @Test
    void testGetWrongLettersAfterIncorrectGuess() {
        gameState.isCorrectLetter('z');
        assertTrue(gameState.getWrongLetters().contains('z'), "Wrong letters should contain 'z' after it is guessed incorrectly.");
    }

    @Test
    void testGetCurrentWordStateInitial() {
        assertEquals("_ _ _ _ _", gameState.getCurrentWordState(), "Initial word state should be all underscores.");
    }

    @Test
    void testGetCurrentWordStateAfterCorrectGuess() {
        gameState.isCorrectLetter('m');
        assertEquals("m _ _ _ _", gameState.getCurrentWordState(), "Word state should reveal correct guesses.");
    }

    @Test
    void testIsWonWithIncompleteWord() {
        gameState.isCorrectLetter('m');
        gameState.isCorrectLetter('a');
        assertFalse(gameState.isWon(), "Game should not be won with incomplete word guesses.");
    }

    @Test
    void testIsWonWithCompleteWord() {
        gameState.isCorrectLetter('m');
        gameState.isCorrectLetter('a');
        gameState.isCorrectLetter('v');
        gameState.isCorrectLetter('e');
        gameState.isCorrectLetter('n');
        assertTrue(gameState.isWon(), "Game should be won when all letters are guessed correctly.");
    }

    @Test
    void testIsLostWithGuessesRemaining() {
        gameState.isCorrectLetter('z');
        assertFalse(gameState.isLost(), "Game should not be lost while guesses remain.");
    }

    @Test
    void testIsLostWithNoGuessesRemaining() {
        for (int i = 0; i < 6; i++) {
            gameState.isCorrectLetter((char) ('z' + i)); // Incorrect guesses
        }
        assertTrue(gameState.isLost(), "Game should be lost when no guesses remain.");
    }

}
