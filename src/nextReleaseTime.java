import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class nextReleaseTime {
	public static void main(String[] args) {
		//try to make sure that we can get correct next release time
		nextReleaseTime nrtNotify = new nextReleaseTime();
		String todayAns = "GROUP";
		String[] guessAns = { "SCENE", "MAPLE" };
		boolean isAnsCorrect = true;
		boolean isFinish = true;

		String msg = nrtNotify.notify(nrtNotify.getNextReleaseTime(), isAnsCorrect, isFinish, todayAns, guessAns);
		nrtNotify.displayNextReleaseTime(isFinish);
	}

	public String getNextReleaseTime() {
		// using 86400(total second in a day) - current Time(second) to get next release
		// time
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String datetime[] = dtf.format(LocalDateTime.now()).split(":");
		int totalSecond = 86400;
		int restSecond = totalSecond - (Integer.parseInt(datetime[0]) * 3600 + Integer.parseInt(datetime[1]) * 60
				+ Integer.parseInt(datetime[2]));
		int nextHour = restSecond / 3600;
		int nextMinute = (restSecond - (nextHour * 3600)) / 60;
		int nextSecond = restSecond - (nextHour * 3600) - (nextMinute * 60);

		return nextHour + ":" + nextMinute + ":" + nextSecond;
	}

	public String notify(String releaseTime, boolean isAnsCorrect, boolean isFinish, String ans, String[] guessAns) {
		// return different response based on different condition
		String responseMsg = null;
//		boolean isActive = false;

		if (isFinish) {
			responseMsg = "Too Bad! Todays word is [ " + ans + " ] !";

			if (isAnsCorrect) {
				responseMsg = "Congratulations! You guessed [ " + ans + " ] correctly!";
			}
//			isActive = true;
		} else {
			responseMsg = "The user's current guess result is : ";
			for (String item : guessAns) {
				responseMsg += item + " ";
			}
		}
		System.out.println(responseMsg);
//		this.displayNextReleaseTime(isActive);

		return responseMsg;
	}

	public void displayNextReleaseTime(boolean isFinish){
		if(isFinish){
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run() {
					System.out.println("The Next Release Time is : "+new nextReleaseTime().getNextReleaseTime());
				}
			};
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(timerTask,0,1000);
		}

	}
}
