import java.io.IOException;
import java.util.Scanner;

public class fiveLetters {

    // input a guess which must be five letters. Validation when calling class
    public static String userGuess(String guess) {

        // creating dictionary for accepting input
        WordSelector ws = new WordSelector();
        try {
            ws.createDictionary();
        } catch (Exception e){
            e.printStackTrace();
        };

        if (guess.length() != 5) {
            System.out.println("Guess must be 5 letters");
            return null;
        } else if (!guess.matches("[a-zA-Z]+")) {
            System.out.println("Guess must be alphabetic letters only");
            return null;
        } else if (!ws.dictionary.contains(guess.toLowerCase())) {
            System.out.println("Guess not found in dictionary");
            return null;
        } else {
//            System.out.println("Your guess '" + guess + "' is in the dictionary");
//            System.out.println("Guess accepted");
            return guess;
        }
    }
}
