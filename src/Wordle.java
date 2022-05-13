import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Wordle {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREY = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    static WordSelector ws = new WordSelector();

    public void startGame(){
        System.out.println("START"); // add date
        GameRule.displayRules();
    }

    public static void main(String[] args) throws IOException {
        Wordle wordle = new Wordle();
        wordle.startGame();
        String todaysWord = ws.selectRandomWord(ws.createDictionary());

        System.out.println("Random word: " + todaysWord);

        Scanner keyboard = new Scanner(System.in);

        StringBuilder temp;
        if (todaysWord.length() == 5) {
            char[] array = new char[todaysWord.length()];
            Arrays.fill(array, 'X');
            temp = new StringBuilder(new String(array));
        } else {
            temp = new StringBuilder();
        }

        for (int turn = 0; turn < 10; turn++) {
            String guess = null;
            do {
                System.out.println("Enter your guess");
                guess = fiveLetters.userGuess(keyboard.nextLine());
            }while (guess == null);

            if (guess.equals(todaysWord)){
                String[] userGuess = guess.split("(?!^)");
                System.out.println(ANSI_GREEN + guess +ANSI_RESET);
                System.out.println("You guessed correctly!");
                nextReleaseTime r = new nextReleaseTime();
                String countdown = r.notify(r.getNextReleaseTime(), true, true, todaysWord, userGuess);
                break;
                // Print statistics
            } else {
                //check all letters in word
                char c = guess.charAt(0);
                for (int i = todaysWord.indexOf(c); i >= 0; i = todaysWord.indexOf(c, i + 1)) {
                    temp.setCharAt(i, c);
                }
                System.out.println("Else");
            }


//            if (guess.length() != 1) {
//                System.out.println("Guesses must each be a single letter.");
//                continue;
//            }



//            System.out.println(ANSI_GREY + temp.toString() +ANSI_RESET);
        }

    }}

