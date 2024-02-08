package stacs;

import java.util.*;


/**
 * A class to analyse the current game state, including judging if the letter guessed by user right and if the user won, getting the current word state
 */

public class GameState {
    private String targetWord;
    private int guessRemaining;

    private int maxWrongGuesses;

    private Set<Character> correctLetters;
    private Set<Character> wrongLetters;

    /**
     * The constructor of GameState Class
     * @param targetWord The word computer program generates randomly
     */
    public GameState(String targetWord, int maxWrongGuesses)
    {

    }

    /**
     * A method to judge if the letter the user guessed is right
     * @param guessedletter The letter the user guessed
     * @return A boolean value indicating correct or incorrect
     */
    public boolean isCorrectLetter(char guessedletter)
    {
        return false;
    }

    /**
     * A method to get remaining number the user can guess wrong
     * @return guessRemaining
     */
    public int getGuessReminding()
    {
        return 0;
    }

    /**
     * A method to get max number the user can guess wrong
     * @return maxWrongGuesses
     */
    public int getMaxWrongGuesses()
    {
        return 0;
    }

    /**
     * A method to get the words list that the user guessed wrong
     * @return wrongLetters
     */
    public Set<Character> getWrongLetters() {
        return new HashSet<>(Arrays.asList('a', 'e', 'i', 'o'));
    }

    /**
     * A method to get current word state
     * @return a string of current word state
     */
    public String getCurrentWordState()
    {
        return "0";
    }

    /**
     * A method to judge if the user won
     * @return boolean value
     */
    public boolean isWon()
    {
        return false;
    }

    /**
     * A method to judge ig user lost
     * @return boolean value
     */
    public boolean isLost()
    {
        return false;
    }
}
