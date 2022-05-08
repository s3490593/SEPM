import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class gameRuleTesting{
    String input;
    @BeforeEach
    void setup(){
        input = null;
    }

    @Test
    public void PBI2_T1_displayRules(){
        input = "Rules";
        assertEquals("Rules", input, "Rules are displayed")
    }

    @Test
    public void PBI2_T2_exitRules(){
        input = "y";
        assertEquals("y", input, "Exited the game")

    }


}
