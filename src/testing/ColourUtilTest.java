package testing;

import Util.ColourUtil;
import Util.WordMatchUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourUtilTest {

    @Test
    void coloring_partial_coloring() {
        String[] str= new String[5];
        str[0] = "h";
        str[1] = "e";
        str[2] = "l";
        str[3] = "l";
        str[4] = "o";

        String[] expectStr = str.clone();

        expectStr[1]= "\u001B[33m"+expectStr[1]+"\u001B[0m";
        expectStr[2]= "\u001B[33m"+expectStr[2]+"\u001B[0m";
        expectStr[3]= "\u001B[33m"+expectStr[3]+"\u001B[0m";

        String expectResult = String.join("",expectStr);
        String result=String.join("", ColourUtil.coloring(str,1,3,"YELLOW"));

        assertEquals(expectResult, result);

    }
    @Test
    void coloring_all_coloring() {
        String[] str= new String[5];
        str[0] = "h";
        str[1] = "e";
        str[2] = "l";
        str[3] = "l";
        str[4] = "o";

        String[] expectStr = str.clone();

        expectStr[0]= "\u001B[32m"+expectStr[0]+"\u001B[0m";
        expectStr[1]= "\u001B[32m"+expectStr[1]+"\u001B[0m";
        expectStr[2]= "\u001B[32m"+expectStr[2]+"\u001B[0m";
        expectStr[3]= "\u001B[32m"+expectStr[3]+"\u001B[0m";
        expectStr[4]= "\u001B[32m"+expectStr[4]+"\u001B[0m";



        String expectResult = String.join("",expectStr);
        String result=String.join("", ColourUtil.coloring(str,0,4,"GREEN"));

        assertEquals(expectResult, result);

    }

}