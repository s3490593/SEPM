public class GameRule {

    public GameRule(){
    }

    public static void displayRules(){
        System.out.println("Game Rules");
        System.out.println("Start by inputting a five-letter word and hitting enter. \n" +
                "The letter wills turn to different colours or stay blank \n (green for correct letter and location, yellow for correct letter wrong location). \n" +
                "If the colour doesn’t change and remains blank, the input letter is not in the word. \n" +
                "If the colour has changed, it means that the letter is included in the word. \n");

    }
}
