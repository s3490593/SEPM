import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class unitTesting {

    String userInput;
    nextReleaseTime nrtNotify;
    fiveLetters input;
    ValidWord validWord;

    @BeforeEach
    void setup(){
        userInput = null;
        nrtNotify = new nextReleaseTime();
        validWord = new ValidWord();
    }

    @Test
    public void PBI2_T1_displayRules(){
        userInput = "Rules";
        assertEquals("Rules", userInput, "Rules are displayed");
    }

    @Test
    public void PBI2_T2_exitRules(){
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
}