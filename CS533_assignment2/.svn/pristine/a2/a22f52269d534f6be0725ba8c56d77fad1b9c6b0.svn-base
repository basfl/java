package cs533.assignment2.basoltanifar.timer;

public class TimerListener extends Thread {
	TimerApp timerApp;
	public int min;

	public TimerListener(int m) {
		this.min = m;
	}

	public void setListener(TimerApp tp) {
		this.timerApp = tp;
	}

	public void startTimer() {
		int seconds = min * 60;

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		notifyListener();

	}

	public void run() {
		startTimer();
	}

	public void notifyListener() {
		timerApp.stopWork();
	}

}
