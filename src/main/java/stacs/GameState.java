package stacs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;


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
        this.targetWord = targetWord.toLowerCase();
        this.maxWrongGuesses=maxWrongGuesses;
        this.guessRemaining = this.maxWrongGuesses;
        this.correctLetters = new HashSet<>();
        this.wrongLetters = new HashSet<>();
    }

    /**
     * A method to judge if the letter the user guessed is right
     * @param guessedletter The letter the user guessed
     * @return A boolean value indicating correct or incorrect
     */
    public boolean isCorrectLetter(char guessedletter)
    {
        guessedletter = Character.toLowerCase(guessedletter);

        if(targetWord.contains(String.valueOf(guessedletter)))
        {
            correctLetters.add(guessedletter);
            return true;
        }
        else
        {
            guessRemaining--;
            wrongLetters.add(guessedletter);
            return false;
        }
    }

    /**
     * A method to get remaining number the user can guess wrong
     * @return guessRemaining
     */
    public int getGuessReminding()
    {
        return guessRemaining;
    }

    /**
     * A method to get max number the user can guess wrong
     * @return maxWrongGuesses
     */
    public int getMaxWrongGuesses()
    {
        return maxWrongGuesses;
    }

    /**
     * A method to get the words list that the user guessed wrong
     * @return wrongLetters
     */
    public Set<Character> getWrongLetters() {
        return wrongLetters;
    }

    /**
     * A method to get current word state
     * @return a string of current word state
     */
    public String getCurrentWordState()
    {
        StringBuilder currentState = new StringBuilder();
        for(char letter : targetWord.toCharArray())
        {
            if(correctLetters.contains(letter))
            {
                currentState.append(letter).append(" ");
            }
            else
            {
                currentState.append("_ ");
            }
        }
        return currentState.toString().trim();
    }

    /**
     * A method to judge if the user won
     * @return boolean value
     */
    public boolean isWon()
    {
        for(char letter : targetWord.toCharArray())
        {
            if(!correctLetters.contains(letter))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * A method to judge ig user lost
     * @return boolean value
     */
    public boolean isLost()
    {
        return guessRemaining <= 0;
    }
}
