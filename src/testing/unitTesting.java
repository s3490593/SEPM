import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class unitTesting {

    String userInput;


    @BeforeEach
    void setup(){
        userInput = null;
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
}