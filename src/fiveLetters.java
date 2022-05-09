import java.io.IOException;
import java.util.Scanner;

public class fiveLetters {

    public static void main(String[] args) throws IOException {
        guess();
    }

    // input a guess which must be five letters
    public static void guess() throws IOException {

        // creating dictionary for accepting input
        WordSelector ws = new WordSelector();
        ws.createDictionary();

        Scanner userInput = new Scanner(System.in);

        System.out.println("Please input a 5 letter guess:");
        String guess = userInput.next();

        if (guess.length() != 5) {
            System.out.println("Guess must be 5 letters");

        } else if (!guess.matches("[a-zA-Z]+")) {
            System.out.println("Guess must be alphabetic letters only");

        } else if (!ws.dictionary.contains(guess.toLowerCase())) {
            System.out.println("Guess not found in dictionary");

        } else {
            System.out.println("Your guess '" + guess + "' is in the dictionary");
            System.out.println("Guess accepted");
        }
    }
}
