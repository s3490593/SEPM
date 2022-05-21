package Util;

public class ColourUtil {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREY = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    //change the word's colour with specific position
    public static String[] coloring(String[] userGuess,int start,int end,String colour){

        for(int i = start;i>=start && i<=end;i++){
            if(colour.equals("GREEN")){
                userGuess[i]=ANSI_GREEN+userGuess[i]+ANSI_RESET;
            }else if(colour.equals("YELLOW")){
                userGuess[i]=ANSI_YELLOW+userGuess[i]+ANSI_RESET;
            }else if(colour.equals("GREY")){
                userGuess[i]=ANSI_GREY+userGuess[i]+ANSI_RESET;
            }else{
                return userGuess;
            }
        }

        return userGuess;

    }
}
