package Util;


public class WordMatchUtil {
    public static String[] doMatch(String[] guess,String todaysWord){

        for(int i = 0;i<guess.length;i++){
            if(guess[i].equals(String.valueOf(todaysWord.charAt(i)))  ){

                guess = ColourUtil.coloring(guess,i,i,"GREEN");
                continue;
            }
            int index = todaysWord.indexOf(guess[i]);
            if(index >=0){
                guess = ColourUtil.coloring(guess,i,i,"YELLOW");
            }
        }

        return guess;
    }
}
