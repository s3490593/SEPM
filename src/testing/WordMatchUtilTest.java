package testing;

import Util.WordMatchUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordMatchUtilTest {

    @Test
    void doMatch1() {
        String[] str= new String[5];
        str[0] = "s";
        str[1] = "u";
        str[2] = "n";
        str[3] = "n";
        str[4] = "y";

        String[] expectStr = str.clone();

        expectStr[0]= "\u001B[33m"+expectStr[0]+"\u001B[0m";
        expectStr[4]= "\u001B[32m"+expectStr[4]+"\u001B[0m";
        String expectResult = String.join("",expectStr);
        String result=String.join("", WordMatchUtil.doMatch(str,"messy"));
        assertEquals(expectResult, result);
    }
    @Test
    void doMatch2() {
        String[] str= new String[5];
        str[0] = "n";
        str[1] = "o";
        str[2] = "i";
        str[3] = "s";
        str[4] = "y";

        String[] expectStr = str.clone();
        expectStr[3]= "\u001B[32m"+expectStr[3]+"\u001B[0m";
        expectStr[4]= "\u001B[32m"+expectStr[4]+"\u001B[0m";
        String expectResult = String.join("",expectStr);
        String result=String.join("", WordMatchUtil.doMatch(str,"messy"));
        assertEquals(expectResult, result);
    }

}