package stacs;


/**
 * A class to display the game interface
 */
public class Display {

    /**
     * A method to show current state of the game interface
     * @param gameState
     */
    public void showCurrentState(GameState gameState)
    {
        System.out.println("\ncurrent word: " + gameState.getCurrentWordState());
        drawHangman(gameState.getGuessReminding(), gameState.getMaxWrongGuesses());
        System.out.println("Guessed letters: " + gameState.getWrongLetters());
    }

    /**
     * A method to draw Hangamn according to guessesRemaining
     * @param guessesRemaining The remaining number the user can guess wrong
     */
    public void drawHangman(int guessesRemaining, int maxWrongGuesses)
    {
        System.out.println("Hangman:");

        switch (maxWrongGuesses - guessesRemaining) {
            case 0:
                System.out.println("    +---+\n    |   |\n        |\n        |\n        |\n    ====");
                break;
            case 1:
                System.out.println("    +---+\n    |   |\n    O   |\n        |\n        |\n    ====");
                break;
            case 2:
                System.out.println("    +---+\n    |   |\n    O   |\n    |   |\n        |\n    ====");
                break;
            case 3:
                System.out.println("    +---+\n    |   |\n    O   |\n   /|   |\n        |\n    ====");
                break;
            case 4:
                System.out.println("    +---+\n    |   |\n    O   |\n   /|\\  |\n        |\n    ====");
                break;
            case 5:
                System.out.println("    +---+\n    |   |\n    O   |\n   /|\\  |\n   /    |\n    ====");
                break;
            case 6:
                System.out.println("    +---+\n    |   |\n    O   |\n   /|\\  |\n   / \\  |\n    ====");
                System.out.println("Game Over!");
                break;
        }
    }

    /**
     * A method to show win message and score
     * @param gameState The game state
     */
    public void showWinMessage(GameState gameState)
    {
        System.out.println("\nCongratulations, you won!");
        System.out.println("Your score is: " + gameState.getGuessReminding()*10);

    }

    /**
     * A method to show lose message and target word
     * @param targetWord The word the computer generates randomly
     */
    public void showLoseMessage(String targetWord)
    {
        System.out.println("\nSorry, you lost. The correct word was: " + targetWord);
    }
}
