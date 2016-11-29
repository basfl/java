package cs533.assignment1.basoltanifar.file.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileValidator {
	public boolean validate(Map<Integer, String> questionAndAnswerMap){
		boolean valid=true;
		int cnt=0;
		while(cnt<questionAndAnswerMap.size()){
			String holder = null;
			for (Map.Entry<Integer, String> entry : questionAndAnswerMap.entrySet()) {
				if (entry.getKey() == cnt) {
					holder = holder + entry.getValue();
				}
			}
			// get ride of two nulls Introduce earlier  
			String qt = holder.substring(8, holder.length());
			int indeOfAnswers = holder.indexOf("@ANSWERS");
			int indexOfEnd = holder.indexOf("@END");
			String sliceAnswer = holder.substring(indeOfAnswers + 9, indexOfEnd);
			@SuppressWarnings("unused")
			String[] answer = null;
			String questionSlice;
			questionSlice = qt.substring(0, indeOfAnswers);
			@SuppressWarnings("unused")
			String questionWithoutAnswer=questionSlice.replace("@ANSWERS","");
			
			// checking number of question line
			String[] qlines = questionSlice.split("\r\n|\r|\n");
			int qlinesIndex = qlines.length;
			//it is 11 because extra line at end when i removed @ANSWERS
			if (qlinesIndex > 11) {
				valid=false;
			}
			/////////////////////////////////
			String[] alines = sliceAnswer.split("\r\n|\r|\n");
			List<String> answerList = new ArrayList<>();
			answerList.add(sliceAnswer);
			answer = sliceAnswer.split("\n");
		
		
			// first one is the correct answer therefore i added etra one
			if(alines.length>11){
				
				valid=false;
			}
			
			answerList.clear();
			cnt++;
			
		}// end of while 
		return valid;
		
	}

}
