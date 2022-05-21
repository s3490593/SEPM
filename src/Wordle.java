import Util.ColourUtil;
import Util.WordMatchUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Wordle {



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


                System.out.println(guess);
                System.out.println("You guessed correctly!");
                nextReleaseTime r = new nextReleaseTime();
                String countdown = r.notify(r.getNextReleaseTime(), true, true, todaysWord, userGuess);
                break;
                // Print statistics
            } else {
                //check all letters in word
                userGuess = WordMatchUtil.doMatch(userGuess,todaysWord);
                guessedWords.add(String.join("",userGuess));

                System.out.println("Else");
            }


        }

    }}

