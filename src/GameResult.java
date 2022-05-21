import java.text.SimpleDateFormat;
import java.util.Date;

public class GameResult {
    public static void showResult(String todayWord,int attempt,Double totalTime){
        System.out.println("----------------------------------");
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        int score =(int)(10000/(attempt*totalTime));

        System.out.println("Wordle Challenge Result");
        System.out.println("Date:"+"\t"+df.format(date));
        System.out.println("Word:"+"\t"+todayWord);
        System.out.println("Attempt:"+"\t"+attempt);
        System.out.println("Time:"+"\t"+totalTime+" s");
        System.out.println("score:"+"\t"+score);


        System.out.println("----------------------------------");

    }

}
