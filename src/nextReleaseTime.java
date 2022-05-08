import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class nextReleaseTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nextReleaseTime nrtNotify = new nextReleaseTime();
		String todayAns = "GROUP";
		String[] guessAns = { "SCENE", "MAPLE" };
		String msg = nrtNotify.notify(nrtNotify.getNextReleaseTime(), true, true, todayAns, guessAns);
	}

	public String getNextReleaseTime() {
		// using 86400(total second in a day) - current Time(second) to get next release
		// time
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String datetime[] = dtf.format(LocalDateTime.now()).toString().split(":");
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
		if (isFinish) {
			responseMsg = "Too Bad! Todays word is [ " + ans + " ] !";

			if (isAnsCorrect) {
				responseMsg = "Congratulations! You guessed [ " + ans + " ] correctly!";
			}

			responseMsg += "\nThe next release time is  " + releaseTime;
		} else {
			responseMsg = "The user's current guess result is : ";
			for (String item : guessAns) {
				responseMsg += item + " ";
			}
		}
		System.out.println(responseMsg);
		return responseMsg;
	}
}
