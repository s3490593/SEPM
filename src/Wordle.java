import Util.ColourUtil;
import Util.WordMatchUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.List;
import java.util.Scanner;

public class Wordle {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREY = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String countdown;

    static WordSelector ws = new WordSelector();

    public static List<String> guessedWords = new ArrayList<>();

    public void startGame(){
        System.out.println("START"); // add date
        GameRule.displayRules();
    }

    public static void main(String[] args) throws IOException {
        Wordle wordle = new Wordle();
        wordle.startGame();


        String todaysWord = ws.selectRandomWord(ws.createDictionary());
       // System.out.println("Random word: " + todaysWord);

        System.out.println("Random word: " + todaysWord);

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
                    System.out.println("Previous guesses: " + guessedWords);
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
                System.out.println("Next Wordle" + countdown);
                break;
                // Print statistics
            } else {
                //check all letters in word
                userGuess = WordMatchUtil.doMatch(userGuess,todaysWord);
                guessedWords.add(String.join("",userGuess));

                //System.out.println("Else");
                char c = guess.charAt(0);
                for (int i = todaysWord.indexOf(c); i >= 0; i = todaysWord.indexOf(c, i + 1)) {
                    temp.setCharAt(i, c);
                }
              //  System.out.println("Else");
            }

//            if (guess.length() != 1) {
//                System.out.println("Guesses must each be a single letter.");
//                continue;
//            }



//            System.out.println(ANSI_GREY + temp.toString() +ANSI_RESET);
        }
        nextReleaseTime r = new nextReleaseTime();
        System.out.println("Too bad today's word is : " + todaysWord);
        System.out.println("Next Wordle " + r.getNextReleaseTime());

    }}

