package cs533.assignment2.basoltanifar.utils;

import java.util.Map;

public class StatCalculator {

	public String getStatic(Recorder recorder) {
		int numberOfCorrectAnswers = 0;
		int numberOfWrongAnswers = 0;
		float correctParcent;
		float worngParcent;
		int total = recorder.correctAndWorngQuestionsMap.size();
		for (Map.Entry<Integer, Boolean> entry : recorder.correctAndWorngQuestionsMap.entrySet()) {
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
		// String timeForSession=recorder.sessionTime();
		recorder.setEndTime(System.currentTimeMillis());
		String sessionTime = recorder.sessionTime();
		String totalq = "Total number of question asked in this session out of "
				+ recorder.getFileMapFromOrgizer().size() + " question provided from questions & answersfile  is "
				+ total + "\n";
		String statCorrect = "Number of correct Answers = " + numberOfCorrectAnswers + " which is " + correctParcent
				+ "% \n";
		String statWrong = "Number of Wrong Answers = " + numberOfWrongAnswers + " which is " + worngParcent + "% \n";
		String totals = sessionTime + totalq + statCorrect + statWrong;
		return totals;

	}

	public String getTotalStatic(Recorder recorder) {
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
		// String timeForSession=recorder.sessionTime();
		recorder.setEndTime(System.currentTimeMillis());
		String sessionTime = recorder.totalSessionTime();
		String totalq = "Total number of question asked in this session out of "
				+ recorder.getFileMapFromOrgizer().size() + " question provided from questions & answersfile  is "
				+ total + "\n";
		String statCorrect = "Number of correct Answers = " + numberOfCorrectAnswers + " which is " + correctParcent
				+ "% \n";
		String statWrong = "Number of Wrong Answers = " + numberOfWrongAnswers + " which is " + worngParcent + "% \n";
		String totals = sessionTime + totalq + statCorrect + statWrong;
		return totals;
	}
}
