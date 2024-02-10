package stacs;

/**
 *A class to start Hangman
 *
 * @author 230009784
 * @version 2
 */

public class Hangman {
    private RandomWords randomWord;
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
        System.out.println("Hello Hangman!");
        Hangman hangman = new Hangman();
        hangman.initializeGame();
    }


    /**
     * The method to initialize the game
     */
    public void initializeGame() {
        randomWord = new RandomWords();
        targetWord = randomWord.getWord();
        if (targetWord == null) {
            System.out.println("Failed to load the word list. Game cannot start.");
            return;
        }

        this.gameState = new GameState(targetWord, maxWrongGuesses);
        System.out.println("Guess the word: " + gameState.getCurrentWordState());
        playGame();
    }

    /**
     * The method to play the game
     */
    private void playGame() {
        while(!gameState.isWon() && !gameState.isLost())
        {
            char guessedLetter = inputHandler.getGuessedLetter();
            boolean isCorrect = gameState.isCorrectLetter(guessedLetter);

            if(!isCorrect)
            {
                System.out.println("Wrong guess.");
            }
            else
            {
                System.out.println("Invalid guess.");
            }

            display.showCurrentState(gameState);
        }

        if(gameState.isWon())
        {
            display.showWinMessage(gameState);
        }
        if(gameState.isLost())
        {
            display.showLoseMessage(this.targetWord);
        }
    }
}
