package testing;

import Util.WordMatchUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordMatchUtilTest {

    @Test
    void doMatch() {
        String[] str= new String[5];
        str[0] = "s";
        str[1] = "u";
        str[2] = "n";
        str[3] = "n";
        str[4] = "y";

        String result=String.join("", WordMatchUtil.doMatch(str,"messy"));
        System.out.println(result);
    }
}