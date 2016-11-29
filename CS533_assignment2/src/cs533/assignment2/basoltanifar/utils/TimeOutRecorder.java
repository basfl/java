package cs533.assignment2.basoltanifar.utils;

import java.util.Map;

public class TimeOutRecorder {
	// private static Recorder recorder;
	public int getTimeOutInMin() {
		return timeOutInMin;
	}

	public void setTimeOutInMin(int timeOutInMin) {
		this.timeOutInMin = timeOutInMin;
	}

	private static String timeOutStat;
	private int timeOutInMin;

	// public static Recorder getRecorder() {
	// return recorder;
	// }

	public static String getTimeOutStat() {
		return timeOutStat;
	}

	public static void setTimeOutStat(String timeOutStat) {
		TimeOutRecorder.timeOutStat = timeOutStat;
	}

	// public static void setRecorder(Recorder recorder) {
	// TimeOutRecorder.recorder = recorder;
	// }
	public String getTimeOutStat(Recorder recorder) {
		int numberOfCorrectAnswers = 0;
		int numberOfWrongAnswers = 0;
		float correctParcent;
		float worngParcent;
		int total = recorder.correctAndWorngQuestionsMapForEntireSession.size();
		for (Map.Entry<Integer, Boolean> entry : recorder.correctAndWorngQuestionsMapForEntireSession.entrySet()) {
			@SuppressWarnings("unused")
			Integer key = entry.getKey();
			Boolean value = entry.getValue();

			if (value == true) {
				numberOfCorrectAnswers++;
			} else {
				numberOfWrongAnswers++;
			}

		}
		correctParcent = ((float) numberOfCorrectAnswers / total) * 100;
		worngParcent = ((float) numberOfWrongAnswers / total) * 100;
		String statCorrect = "Number of correct Answers = " + numberOfCorrectAnswers + " which is " + correctParcent
				+ "% \n";
		String statWrong = "Number of Wrong Answers = " + numberOfWrongAnswers + " which is " + worngParcent + "% \n";
		String totalStat=statCorrect+statWrong;
		return totalStat;

	}

}
