package stacs;

/**
 *A class to start Hangman
 *
 * @author 230009784
 * @version 3
 */

public class Hangman {
    private InputHandler inputHandler;
    private GameState gameState;
    private Display display;
    private String targetWord;

    private final int maxWrongGuesses = 6;


    /**
     * The construction of Hangman Class
     */
    public Hangman() {
        this.inputHandler = new InputHandler();
        this.display = new Display();
    }


    /**
     * The method to launch the application
     * @param args
     */
    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        hangman.startGame();
    }

    /**
     * The method to start the game
     */
    private void startGame() {
        System.out.println("Hello Hangman!");
        if (!initializeGame()) {
            System.out.println("Failed to initialize the game. Exiting...");
            return;
        }
        playGame();
        concludeGame();
    }

    /**
     * The method to initialize the game
     * @return boolean value if the game can initial successfully
     */
    private boolean initializeGame() {
        targetWord = RandomWords.getWord();
        if (targetWord == null) {
            System.out.println("Failed to load the word list. Game cannot start.");
            return false;
        }

        gameState = new GameState(targetWord, maxWrongGuesses);
        System.out.println("Guess the word: " + gameState.getCurrentWordState());
        return true;
    }

    /**
     * The method to play the game
     */
    private void playGame() {
        while (!gameState.isWon() && !gameState.isLost()) {
            processGuess();
        }
    }

    /**
     * The method to process the letter the user guessed
     */
    private void processGuess() {
        char guessedLetter = inputHandler.getGuessedLetter();
        if (gameState.isCorrectLetter(guessedLetter)) {
            System.out.println("Correct guess.");
        } else {
            System.out.println("Wrong guess.");
        }
        display.showCurrentState(gameState);
    }

    /**
     *The method to conclude the game by showing relevant information
     */
    private void concludeGame() {
        if (gameState.isWon()) {
            display.showWinMessage(gameState);
        } else if (gameState.isLost()) {
            display.showLoseMessage(targetWord);
        }
    }
}
