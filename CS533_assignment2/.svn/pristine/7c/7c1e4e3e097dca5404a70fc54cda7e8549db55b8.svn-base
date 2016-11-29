package cs533.assignment2.basoltanifar.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs533.assignment2.basoltanifar.file.operations.FileSlicer;
import cs533.assignment2.basoltanifar.timer.TimerApp;
import cs533.assignment2.basoltanifar.timer.TimerListener;
import cs533.assignment2.basoltanifar.utils.LogRecorder;
import cs533.assignment2.basoltanifar.utils.Recorder;
import cs533.assignment2.basoltanifar.utils.StatCalculator;
import cs533.assignment2.basoltanifar.utils.TimeOutRecorder;

public class QuestonAndAnswer {
	StatCalculator statCalculator = new StatCalculator();
	LogRecorder logRecorder=new LogRecorder();
	private int maxCharacterPerLine = 75;

	///// this varible is for keeping the answer it is -1 in case if user did
	///// not choose any answer ///////////
	public int finalAnswer = -1;
	TimeOutRecorder timeOutRecorder = new TimeOutRecorder();
	////////////////////////////////////////////////////////
	Recorder recorder = new Recorder();
	FileSlicer fileSlicer;
	public int qViewCounter;

	public String correctAnswer;
	TimerListener timerListener;

	public void questionAndAnswerView(Recorder record1, TimerListener tl) throws IOException {
		this.recorder = record1;
		this.timerListener = tl;
		if (recorder.getViewNumber() <= recorder.getQnumber()) {
			System.out.println("**************question#:(" + recorder.getViewNumber() + ")***************************");
			fileSlicer = new FileSlicer(recorder.getFileMapFromOrgizer());
			int index = (recorder.getViewNumber() - 1);
			int numberGen = recorder.randomGenerator().get(index);
			fileSlicer.slice(numberGen);
			qViewCounter = recorder.getViewNumber() + 1;
			recorder.setViewNumber(qViewCounter);
			////////////////////////////////////////////
			fileSlicer = new FileSlicer(recorder.getFileMapFromOrgizer());
			fileSlicer.slice(numberGen);
			List<String> finalAnswers = new ArrayList<>();
			String question = fileSlicer.questionWithoutAnswer;
			// slicing the question line
			String[] qlines = question.split("\r\n|\r|\n");
			for (String qline : qlines) {
				if (qline.length() > maxCharacterPerLine) {
					String cutQuestion = qline.substring(0, maxCharacterPerLine);
					System.out.println(cutQuestion);
				} else {
					System.out.println(qline);
				}
			}
			System.out.println("******************************************************");

			//////////////////
			for (int i = 0; i < fileSlicer.answers.length; i++) {
				if (i == 0) {
					// removing correct answer
					correctAnswer = fileSlicer.answers[i];
				} else {
					finalAnswers.add(fileSlicer.answers[i]);
				}
			}
			int aindex = 1;
			for (String answer : finalAnswers) {
				if (answer.length() > maxCharacterPerLine) {
					String cutAnswer = answer.substring(0, maxCharacterPerLine);
					System.out.println("(" + aindex + ")" + cutAnswer);
				} else {
					System.out.println("(" + aindex + ")" + answer);
				}

				aindex++;
			}
			System.out.println("**** Please select you answer");
			Scanner reader1 = new Scanner(System.in);
			finalAnswer = reader1.nextInt();

			int correctAnswerInt = Integer.parseInt(correctAnswer.trim().intern());
			if (finalAnswer == correctAnswerInt) {
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				System.out.println("&        correct answer                    &");
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				recorder.setCorrectAndWorngQuestionsMap(recorder.random.get(index), true);
				recorder.setCorrectAndWorngQuestionsMapForEntireSession(recorder.random.get(index), true);
			} else {
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				System.out
						.println("& your answer was worng , the correct answer is answer # " + correctAnswerInt + " &");
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				recorder.setCorrectAndWorngQuestionsMap(recorder.random.get(index), false);
				recorder.setCorrectAndWorngQuestionsMapForEntireSession(recorder.random.get(index), false);
			}
			System.out.println("******************************************************");
			// timeOutRecorder.setRecorder(recorder);
			timeOutRecorder.setTimeOutStat(timeOutRecorder.getTimeOutStat(recorder));
			QuestonAndAnswer questionAndAnswerView = new QuestonAndAnswer();
			questionAndAnswerView.questionAndAnswerView(recorder, timerListener);

		} else {

			String stat = statCalculator.getStatic(recorder);
			logRecorder.recordLog(stat);
			System.out.println(stat);
			System.out.println("********************************************************************************");
			System.out.println("*Do you want to continue with another session with same Number of question(Y|N)*");
			System.out.println("********************************************************************************");
			Scanner reader2 = new Scanner(System.in);
			String continueChoice = reader2.nextLine();

			if (continueChoice.equals("Y") || continueChoice.equals("y")) {
				if (recorder.alredayChoosen.size() == recorder.getFileMapFromOrgizer().size()) {
					System.out.println("No more question left");
					totalStatOptionDisplay();

				} else {
					recorder.setViewNumber(1);
					recorder.setStartTime(System.currentTimeMillis());
					recorder.random.clear();
					recorder.correctAndWorngQuestionsMap.clear();
					int n = recorder.getFileMapFromOrgizer().size() - recorder.alredayChoosen.size();
					if (n < recorder.getQnumber()) {
						System.out.println("you choose " + recorder.getQnumber() + " for this session." + n
								+ " questions left which will be use for this session  ");
						recorder.setQnumber(n);
					} else {
						System.out.println("" + n + " questions left");
					}
					// timeOutRecorder.setRecorder(recorder);
					timeOutRecorder.setTimeOutStat(timeOutRecorder.getTimeOutStat(recorder));
					// int tempTimerHolder=timerListener.min;
					if (timerListener == null) {
						QuestonAndAnswer qt = new QuestonAndAnswer();
						qt.questionAndAnswerView(recorder, timerListener);
					} else {
						// timeOutRecorder.setTimeOutInMin(intMin);
						// timerListener = new TimerListener(intMin);
						// timerApp = new TimerApp(timerListener);
						// timerApp.doWork();
						TimerListener tListener = new TimerListener(timerListener.min);
						timerListener.stop();
						TimerApp ta = new TimerApp(tListener);
						ta.setR(recorder);
						try {
							ta.doWorkNewSession();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				} // end of else

			} else {
				System.out.println("***YOU CHOOSE NO***");
				totalStatOptionDisplay();

			} // end of else
			System.out.println("**************************************************************************");
			System.out.println("Do you want to have another session with different criteria for this file(Y|N)");
			System.out.println("**************************************************************************");
			Scanner sameFile = new Scanner(System.in);
			String sameFileOption = sameFile.nextLine();
			if (sameFileOption.equals("Y") || sameFileOption.equals("y")) {
				System.out.println("do some thing");
				if (timerListener == null) {
					sameFileMenu(recorder.getQaFilePath());
				} else {
					timerListener.stop();
					sameFileMenu(recorder.getQaFilePath());
				}
			} else {
				System.out.println("You choose no!!!");
			}

			System.out.println("*********************************************");
			System.out.println("*    do you want to start new session (Y|N) *");
			System.out.println("*********************************************");
			Scanner startNewSession = new Scanner(System.in);
			String startNewSessionChoice = startNewSession.nextLine();
			if (startNewSessionChoice.equals("Y") || startNewSessionChoice.equals("y")) {
				// MainMenu mainMenu = new MainMenu();
				try {
					// mainMenu.displayUserOptions(timerListener);
					// App app=new App();
					timerListener.stop();
					newSesstionMenu();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("******YOU CHOOSE NO****");
				System.out.println("** Program terminated.Thank you ! **");
				System.exit(0);
			}

		}

	}

	private void sameFileMenu(String qaFilePath) throws IOException {
		TimerListener timerListenerTemp = null;
		TimerApp timerAppTemp;
		TimeOutRecorder timeOutRecorder = new TimeOutRecorder();
		System.out.println("Do you want to try your session with timer (Y|N)");
		Scanner option = new Scanner(System.in);
		String sOption = option.nextLine();
		if (sOption.equals("Y") || sOption.equals("y")) {
			System.out.println("Enter thet time in minutes please");
			Scanner min = new Scanner(System.in);
			int intMin = min.nextInt();
			System.out.println(intMin);
			timeOutRecorder.setTimeOutInMin(intMin);
			timerListenerTemp = new TimerListener(intMin);
			timerAppTemp = new TimerApp(timerListenerTemp);
			timerAppTemp.doWorkForSameFile(qaFilePath);
			// TimerApp timerApp1=new TimerApp(new TimerListener());
			// timerApp1.doWork();

		} else {
			// MainMenu mainMenu = new MainMenu();
			// mainMenu.displayUserOptions(timerListenerTemp);
			SameFileMainMenu sameFileMainMenu = new SameFileMainMenu();
			sameFileMainMenu.displayUserOptions(timerListenerTemp, qaFilePath);
		}

	}

	private void newSesstionMenu() throws IOException {
		TimerListener timerListenerTemp = null;
		TimerApp timerAppTemp;
		TimeOutRecorder timeOutRecorder = new TimeOutRecorder();
		System.out.println("Do you want to try your session with timer (Y|N)");
		Scanner option = new Scanner(System.in);
		String sOption = option.nextLine();
		if (sOption.equals("Y") || sOption.equals("y")) {
			System.out.println("Enter thet time in minutes please");
			Scanner min = new Scanner(System.in);
			int intMin = min.nextInt();
			System.out.println(intMin);
			timeOutRecorder.setTimeOutInMin(intMin);
			timerListenerTemp = new TimerListener(intMin);
			timerAppTemp = new TimerApp(timerListenerTemp);
			timerAppTemp.doWork();
			// TimerApp timerApp1=new TimerApp(new TimerListener());
			// timerApp1.doWork();

		} else {
			MainMenu mainMenu = new MainMenu();
			mainMenu.displayUserOptions(timerListenerTemp);
		}

	}

	private void totalStatOptionDisplay() {
		System.out.println("*****************************************");
		System.out.println("*do you want to recieve total stat (Y|N)*");
		System.out.println("*****************************************");
		Scanner totalStatOption = new Scanner(System.in);
		String totalStatChoice = totalStatOption.nextLine();

		if (totalStatChoice.equals("Y") || totalStatChoice.equals("y")) {
			System.out.println("********************STAT*********************");
			System.out.println(statCalculator.getTotalStatic(recorder));
			System.out.println("*********************************************");
		} else {
			System.out.println("*** YOU CHOOSE NO**");
		}

	}

}
