import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ValidWord {


    public ArrayList<String> getDictionary() throws IOException {
        ArrayList<String> dictionary = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
        String line = reader.readLine();

        while (line != null) {
            dictionary.add(line);
            line = reader.readLine();
        }

        reader.close();
        return dictionary;
    }

    public boolean checkValid(String input) {
        boolean isExist=false;
        try{
            for(String item:new ValidWord().getDictionary()){
                if(item.equals(input)){
                    isExist=true;
                }
            }
        }catch (IOException IOex){
            System.out.println(IOex.getMessage());
        }


        String resMsg=isExist?"The word is valid":"The word is inValid";
        System.out.println(resMsg);

        return isExist;
    }


    public static void main(String[] args) {
        ValidWord validWord = new ValidWord();
        String userInput = "greet";
        validWord.checkValid(userInput);
    }
}
