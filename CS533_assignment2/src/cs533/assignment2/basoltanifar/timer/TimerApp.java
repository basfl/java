package cs533.assignment2.basoltanifar.timer;

import java.io.IOException;

import cs533.assignment2.basoltanifar.main.MainMenu;
import cs533.assignment2.basoltanifar.main.QuestonAndAnswer;
import cs533.assignment2.basoltanifar.main.SameFileMainMenu;
import cs533.assignment2.basoltanifar.utils.LogRecorder;
import cs533.assignment2.basoltanifar.utils.Recorder;
import cs533.assignment2.basoltanifar.utils.TimeOutRecorder;

public class TimerApp {
	// B2 b;
	TimerListener timerListener;
	TimeOutRecorder timeOutRecorder = new TimeOutRecorder();
	LogRecorder logRecorder=new LogRecorder();
	boolean flag = false;
	Recorder r;

	public TimerApp(TimerListener t) {
		this.timerListener = t;
	}

	public Recorder getR() {
		return r;
	}

	public void setR(Recorder r) {
		this.r = r;
	}

	public void doWork() throws IOException {

		flag = true;
		timerListener.setListener(this);
		// b.startTimer();
		timerListener.start();
		MainMenu mainMenu = new MainMenu();
		while (flag) {

			mainMenu.displayUserOptions(timerListener);
		}
		

	}
	public void doWorkNewSession() throws IOException {

		flag = true;
		timerListener.setListener(this);
		// b.startTimer();
		timerListener.start();
		QuestonAndAnswer questionAndAnswerView = new QuestonAndAnswer();
		while (flag) {
			
			questionAndAnswerView.questionAndAnswerView(r, timerListener);
			
		}
		

	}
	public void doWorkForSameFile(String qaFilePath) throws IOException {

		flag = true;
		timerListener.setListener(this);
		// b.startTimer();
		timerListener.start();
		//QuestonAndAnswer questionAndAnswerView = new QuestonAndAnswer();
		SameFileMainMenu sameFileMainMenu=new SameFileMainMenu();
		while (flag) {
			
		//	questionAndAnswerView.questionAndAnswerView(r, timerListener);
			sameFileMainMenu.displayUserOptions(timerListener, qaFilePath);
			
		}
		

	}



	public void stopWork() {
		flag = false;
		System.out.println("Sorry Time is up!!!!");
		System.out.println(timeOutRecorder.getTimeOutStat());
		logRecorder.recordLog(timeOutRecorder.getTimeOutStat());
		
		System.exit(0);

	}
}
