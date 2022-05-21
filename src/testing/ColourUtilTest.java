package testing;

import Util.ColourUtil;
import Util.WordMatchUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourUtilTest {

    @Test
    void coloring() {
        String[] str= new String[5];
        str[0] = "h";
        str[1] = "e";
        str[2] = "l";
        str[3] = "l";
        str[4] = "o";
        String result=String.join("", ColourUtil.coloring(str,1,3,"YELLOW"));
        System.out.println(result);

    }
}