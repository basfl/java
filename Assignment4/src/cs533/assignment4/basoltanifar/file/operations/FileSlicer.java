package cs533.assignment4.basoltanifar.file.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSlicer {
	Map<Integer, String> questionAndAnswerMap = new HashMap<>();
	public String[] answers = null;
	public String questionWithoutAnswer;

	public FileSlicer(Map<Integer, String> questionAndAnswerMap) {
		this.questionAndAnswerMap = questionAndAnswerMap;
	}

	public void slice(int index) {
		String holder = null;
		for (Map.Entry<Integer, String> entry : questionAndAnswerMap.entrySet()) {
			if (entry.getKey() == index) {
				holder = holder + entry.getValue();
			}
		}
		// get ride of two nulls added
		String qt = holder.substring(8, holder.length());
		int indeOfAnswers = holder.indexOf("@ANSWERS");
		int indexOfEnd = holder.indexOf("@END");
		String sliceAnswer = holder.substring(indeOfAnswers + 9, indexOfEnd);
		String questionSlice;
		questionSlice = qt.substring(0, indeOfAnswers);
		questionWithoutAnswer = questionSlice.replace("@ANSWERS", "");
		@SuppressWarnings("unused")
		String[] alines = sliceAnswer.split("\r\n|\r|\n");
		List<String> answerList = new ArrayList<>();
		answerList.add(sliceAnswer);
		answers = sliceAnswer.split("\n");
		answerList.clear();

	}

}

