package stacs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;


/**
 * A class to generate random word from the specified file path
 */
public class RandomWords {
    public static String getWord() {

        String filePath = "src/main/resources/wordlist.txt";

        try {
            List<String> words = Files.readAllLines(Paths.get(filePath));

            if (words.isEmpty()) {
                System.out.println("The word list is empty.");
                return null;
            }

            Random random = new Random();
            return words.get(random.nextInt(words.size()));
        } catch (IOException e) {
            System.out.println("Failed to read the word list: " + e.getMessage());
            return null;
        }
    }
}
