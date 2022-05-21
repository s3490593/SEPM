package testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void showResult() {
        String todayWord = "avoid";
        int attempt = 1;
        Double totalTime = 3.0;

        assertEquals("Wordle Challenge Result\n" +
                "Date:\t22-05-2022 01:39:18\n" +
                "Word:\tavoid\n" +
                "Attempt:\t1\n" +
                "Time:\t3.0 s"+
                "score:\t56" , "Wordle Challenge Result\n" +
                "Date:\t22-05-2022 01:39:18\n" +
                "Word:\tavoid\n" +
                "Attempt:\t1\n" +
                "Time:\t3.0 s"+
                "score:\t56" );

    }
}