import Util.ColourUtil;
import Util.WordMatchUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.List;
import java.util.Scanner;

public class Wordle {

    public static String countdown;
    public static String todaysWord;

    static WordSelector ws = new WordSelector();

    public static List<String> guessedWords = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Wordle wordle = new Wordle();
        GameRule.displayRules();

    game();
    }

    public static void game() throws IOException {
        todaysWord = ws.selectRandomWord(ws.createDictionary());

        long startTime = System.currentTimeMillis();
        Scanner keyboard = new Scanner(System.in);

        StringBuilder temp;
        if (todaysWord.length() == 5) {
            char[] array = new char[todaysWord.length()];
            Arrays.fill(array, 'X');
            temp = new StringBuilder(new String(array));
        } else {
            temp = new StringBuilder();
        }


        int attempt = 0;
        for (int turn = 0; turn < 6; turn++) {
            attempt+=1;
            String guess = null;
            do {
                if(guessedWords.size()!=0 && guessedWords!=null) {
                    System.out.println(guessedWords);
                }
                System.out.println("Enter your guess");
                guess = fiveLetters.userGuess(keyboard.nextLine());

            }while (guess == null);

            String[] userGuess = guess.split("(?!^)");
            if (guess.equals(todaysWord)){
                guessedWords.clear();

                userGuess = ColourUtil.coloring(userGuess,0, userGuess.length-1, "GREEN");

                System.out.println(String.join("",userGuess));
                System.out.println("You guessed correctly!");
                long endTime = System.currentTimeMillis();
                Double totalTime = Double.parseDouble((String.valueOf((endTime-startTime)/1000)));
                GameResult.showResult(todaysWord,attempt,totalTime);
                nextReleaseTime r = new nextReleaseTime();
                countdown = r.notify(r.getNextReleaseTime(), true, true, todaysWord, userGuess);
                System.out.println("Congratulations !");
                System.out.println("Next Wordle in: " + countdown);
                break;
            } else {
                //check all letters in word
                userGuess = WordMatchUtil.doMatch(userGuess,todaysWord);
                guessedWords.add(String.join("",userGuess));

                char c = guess.charAt(0);
                for (int i = todaysWord.indexOf(c); i >= 0; i = todaysWord.indexOf(c, i + 1)) {
                    temp.setCharAt(i, c);
                }
            }
        }
        nextReleaseTime r = new nextReleaseTime();
        System.out.println("Too bad today's word is : " + todaysWord);
        System.out.println("Next Wordle " + r.getNextReleaseTime());

    }
}

