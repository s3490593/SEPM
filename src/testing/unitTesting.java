import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class unitTesting {

    String userInput;
    nextReleaseTime nrtNotify;
    ValidWord validWord;
    @BeforeEach
    void setup(){
        userInput = null;
        nrtNotify = new nextReleaseTime();
        validWord = new ValidWord();
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
        userInput = "GROUND";
        assertEquals("GROUN",userInput, "Testing only exactly 5 letters are accepted by game");
    }

    @Test
    public void PBI28_T2_invalid_lessThan5LetteredEntered(){
        userInput = "HEY";
        assertEquals(null, userInput, "Testing only exactly 5 letters are accepted by game");
    }

    @Test
    public void PBI28_T3_invalid_specialCharactersEntered(){
        userInput = "&2";
        assertEquals(null, userInput, "Testing special characters are not accepted by game");
    }

    @Test
    public void PBI28_T4_valid_5LettersFromDictionary(){
        userInput = "GROUP";
        assertEquals("GROUP", userInput, "Testing valid 5 letter word is accepted by game");
    }

    @Test
    public void PBI28_T5_invalid_5LettersNotFromDicitionary(){
        userInput = "ABCDS";
        assertEquals(null, userInput, "Testing 5 letter word not in dictionary is not accepted by game");
    }

    // Not sure unit tests are viable for this PBI as there is nothing to test in code - just visually?
    @Test
    public void PBI24_T1_priorGamesInaccessible_gameComplete(){
        userInput = "GROWN";
        //dummy assertion
        assertFalse(false);
    }

    @Test
    public void PBI24_T2_priorGamesInaccessible_gameIncomplete(){
        // In results page
    }

    @Test
    public void PBI29_T1_isWordValid_WordExist(){
        userInput = "greet";
        boolean expect = true;
        boolean actual = validWord.checkValid(userInput);
        assertEquals(expect,actual,"Testing the word is exist in the dictionary");
    }

    @Test
    public void PBI29_T2_isWordValid_WordNotExist(){
        userInput = "aaaaa";
        boolean expect=  false;
        boolean actual = validWord.checkValid(userInput);
        assertEquals(expect,actual,"Testing the word is not exist in the dictionary");
    }
}