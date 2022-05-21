package Util;

public class ColourUtil {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREY = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String[] coloring(String[] userGuess,int start,int end,String colour){
//        String[] userGuess = word.split("(?!^)");
        String prefix = "";
        String coloured = "";
        String suffixes = "";
        String[] result = new String[5];

//        for(int i = 0;i<start;i++){
//            prefix =prefix + userGuess[i];
//        }
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
//        if(colour.equals("GREEN")){
//            coloured = ANSI_GREEN + coloured +ANSI_RESET;
//        }else if(colour.equals("YELLOW")){
//            coloured = ANSI_YELLOW + coloured +ANSI_RESET;
//        }else if(colour.equals("GREY")){
//            coloured = ANSI_GREY + coloured +ANSI_RESET;
//        }else{
//            return userGuess;
//        }

//        for(int i = end+1;i< userGuess.length;i++){
//            suffixes = suffixes + userGuess[i];
//        }
        return userGuess;

    }
}
