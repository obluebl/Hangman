package stacs;
import java.util.Scanner;

/**
 * A class to deal with user input
 */

public class InputHandler {
    private Scanner scanner;

    /**
     * The constructor of InputHandler Class
     */
    public InputHandler() {
        scanner = new Scanner(System.in);
    }


    /**
     * The method to verify the user input is a single letter and return the valid input
     * @return inputLetter.charAt(0) The single letter of user input
     */
    public char getGuessedLetter() {
        System.out.print("Enter your guess (a single letter): ");

        String inputLetter = scanner.nextLine().trim().toLowerCase();
        while (inputLetter.isEmpty() || !inputLetter.matches("[a-zA-Z]")) {
            System.out.println("Invalid input. Please enter a single letter:");
            inputLetter = scanner.nextLine().trim().toLowerCase();
        }
        return inputLetter.charAt(0);
    }
}

