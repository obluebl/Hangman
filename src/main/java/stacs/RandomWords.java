package stacs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/**
 * A class to generate random word from the specified file path
 */
public class RandomWords {
    public static String getWord() {

        String filePath= "src/main/resources/wordlist.txt";
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                words.add(line.trim());
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }

        if (words.isEmpty())
        {
            return null;
        }

        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
