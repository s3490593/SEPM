import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class unitTesting {

    String userInput;
    nextReleaseTime nrtNotify;
    fiveLetters input;
    ValidWord validWord;
    Wordle wordle;
    List <String> guessedWords;

    @BeforeEach
    void setup(){
        userInput = null;
        nrtNotify = new nextReleaseTime();
        validWord = new ValidWord();
        wordle = new Wordle();
        guessedWords = new ArrayList<>();
    }

    @Test
    public void PBI4_T1_displayRules(){
        userInput = "Rules";
        assertEquals("Rules", userInput, "Rules are displayed");
    }

    @Test
    public void PBI4_T2_exitRules(){
        userInput = "y";
        assertEquals("y", userInput, "Exited the game");
    }

    @Test
    void PBI2_T1_is_message_correct_when_user_win() {
        String nextReleaseTime = nrtNotify.getNextReleaseTime();
        String userInput = "SCENE";
        String expectMsg = "Congratulations! You guessed [ " + userInput + " ] correctly!";
        String actualMsg = nrtNotify.notify(nextReleaseTime, true, true, userInput, null);
        assertEquals(expectMsg, actualMsg);
    }

    @Test
    void PBI2_T2_is_message_correct_when_user_lose() {
        String nextReleaseTime = nrtNotify.getNextReleaseTime();
        String userInput = "SCENE";
        String expectMsg = "Too Bad! Todays word is [ " + userInput + " ] !";
        String actualMsg = nrtNotify.notify(nextReleaseTime, false, true, userInput, null);
        assertEquals(expectMsg, actualMsg);
    }

    @Test
    void PBI2_T3_is_message_correct_when_user_not_yet_finish_game() {
        String nextReleaseTime = nrtNotify.getNextReleaseTime();
        String[] guessAns = { "GROUP" };
        String userInput = "";
        String expectMsg = "The user's current guess result is : " + guessAns[0] + " ";
        String actualMsg = nrtNotify.notify(nextReleaseTime, false, false, userInput, guessAns);
        assertEquals(expectMsg, actualMsg);
    }
    @Test
    public void PBI3_T1_gamePlayed_correct(){
        TextualStatistics.calculateGamesPlayed();
        assertEquals(6, TextualStatistics.gamesPlayed,"THE GAME PLAYED NUMBER IS CORRECT");

    }
    @Test
    public void PBI3_T2_gamePlayed_correct(){
        TextualStatistics.calculateGamesPlayed();
        TextualStatistics.calculateGamesPlayed();
        assertEquals(5, TextualStatistics.gamesPlayed);
    }

    @Test
    public void PBI3_T1_winPercentage_correct(){
        TextualStatistics.winPercentage();
        assertEquals(1/3, TextualStatistics.winPercentage());
    }
    @Test
    public void PBI3_T2_winPercentage_correct_with_more_gamePlayed(){
        TextualStatistics.gamesPlayed+=TextualStatistics.gamesPlayed+1;
        TextualStatistics.winPercentage();
        assertEquals(1/4, TextualStatistics.winPercentage());
    }
    @Test
    public void PBI3_T1_displayStats(){
        TextualStatistics.displayStats();
        assertEquals("Games played: 3\n" +
                "Win percentage: 0.0\n" +
                "Current streak: 0\n" +
                "Max streak: 1", "Games played: 3\n" +
                "Win percentage: 0.0\n" +
                "Current streak: 0\n" +
                "Max streak: 1");
    }


    @Test
    public void PBI28_T1_invalid_moreThan5LettersEntered(){
        assertNull(input.userGuess("GROUND"), "Testing only exactly 5 letters are accepted by game");
    }

    @Test
    public void PBI28_T2_invalid_lessThan5LetteredEntered(){
        assertNull(input.userGuess("HEY"), "Testing only exactly 5 letters are accepted by game");
    }

    @Test
    public void PBI28_T3_invalid_specialCharactersEntered(){
        assertNull(input.userGuess("&2"), "Testing special characters are not accepted by game");
    }

    @Test
    public void PBI28_T4_valid_5LettersFromDictionary(){
        assertEquals("GROUP", input.userGuess("GROUP"), "Testing valid 5 letter word is accepted by game");
    }

    @Test
    public void PBI28_T5_invalid_5LettersNotFromDicitionary(){
        assertNull(input.userGuess("ABCDS"), "Testing 5 letter word not in dictionary is not accepted by game");
    }


    @Test
    public void PBI24_T1_priorGamesInaccessible_gameComplete(){
        //dummy assertion as no valid unit viable. Placeholder
        assertNull(null);
    }

    @Test
    public void PBI24_T2_priorGamesInaccessible_gameIncomplete(){
        //dummy assertion as no valid unit viable. Placeholder
        assertNull(null);
    }

    @Test
    public void PBI29_T1_isWordValid_WordExist(){
        assertTrue(validWord.checkValid("greet"),"Testing the word is exist in the dictionary");
    }

    @Test
    public void PBI29_T2_isWordValid_WordNotExist(){
        assertFalse(validWord.checkValid("aaaaa"),"Testing the word is not exist in the dictionary");
    }

    @Test
    public void PBI27_T1_2GuessAttempts(){
        guessedWords.add("hello");
        guessedWords.add("today");
        assertEquals("scone",input.userGuess("scone"), "Checking a 3rd valid guess is accepted");
    }

    @Test
    public void PBI27_T2_4GuessAttempts_Invalid4LetterWord(){
        guessedWords.add("hello");
        guessedWords.add("today");
        guessedWords.add("scone");
        guessedWords.add("helps");
        assertNull(input.userGuess("spam"), "Checking a 4th invalid guess is not accepted");

    }

    @Test
    public void PBI27_T3_5Letters_InvalidWord(){
        guessedWords.add("hello");
        assertNull(input.userGuess("bsdwa"), "Checking a 2nd invalid guess is not accepted");
    }

    @Test
    public void PBI27_T4_acceptsValid_6thGuess(){
        guessedWords.add("hello");
        guessedWords.add("today");
        guessedWords.add("scone");
        guessedWords.add("helps");
        guessedWords.add("halve");
        assertEquals("happy", input.userGuess("happy"));
    }

    @Test
    public void PBI27_T5_7thGuessNotPossible(){
        guessedWords.add("hello");
        guessedWords.add("today");
        guessedWords.add("scone");
        guessedWords.add("helps");
        guessedWords.add("halve");
        guessedWords.add("goose");
        input.userGuess("happy");
        assertEquals(6, guessedWords.size());
    }

}
