package cs533.assignment2.basoltanifar.main;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import cs533.assignment2.basoltanifar.file.operations.FileOrganizer;
import cs533.assignment2.basoltanifar.timer.TimerListener;
import cs533.assignment2.basoltanifar.utils.Recorder;

public class SameFileMainMenu {
	Map<Integer, String> fileOrgMap;
	Recorder recorder = new Recorder();
	TimerListener timerListerner;
	@SuppressWarnings({ "resource", "static-access" })
	public void displayUserOptions(TimerListener tl,String filePath) throws IOException {
		this.timerListerner = tl;
		
		// fileOrgMap = fileOrganizer.readFile(path1);
		FileOrganizer someFile = new FileOrganizer();
		// clean cache memory
		someFile.questionAndAnswerMap.clear();
		fileOrgMap = someFile.readFile(filePath);
		boolean isValid = someFile.validat();
		if (isValid == false) {

			System.out.println("Validation of file failed!! Please make sure your file format is correct");
			System.out.println("Program terminated ");
			System.exit(0);
		} else {
			System.out.println(" The file contains " + fileOrgMap.size() + " questions");

		}
		recorder.setQaFilePath(filePath);
		System.out.println("*******************************************************");
		System.out.println("************please Enter Number of question you want***");
		int numberOfQuestion;
		Scanner reader1 = new Scanner(System.in);
		try {
			numberOfQuestion = reader1.nextInt();
			recorder.setQnumber(numberOfQuestion);
			recorder.setViewNumber(1);
			recorder.setFileMapFromOrgizer(fileOrgMap);
			recorder.setStartTime(System.currentTimeMillis());
			recorder.setStartSessionTime(System.currentTimeMillis());
			if (numberOfQuestion > fileOrgMap.size()) {

				System.out.println(
						" sorry number of question you choosed , is out of index of questions in your file ,currently you have "
								+ fileOrgMap.size() + " numbers of questions !!!");
				System.out.println("** Program terminated !! please try again **");
			} else if (numberOfQuestion < 0) {
				System.out.println("sorry you can not enter negative number !!!");
				System.out.println("** Program terminated !! please try again **");

			} else {
				recorder.randomGenerator();
				QuestonAndAnswer questonAndAnswer = new QuestonAndAnswer();
				questonAndAnswer.questionAndAnswerView(recorder, timerListerner);
			}

		} catch (java.util.InputMismatchException e) {
			System.out.println(" you should only enter integer");
			System.out.println("** Program terminated !! please try again **");
		}

	}


}