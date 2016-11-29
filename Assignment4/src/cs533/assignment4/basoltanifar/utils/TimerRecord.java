package cs533.assignment4.basoltanifar.utils;

import java.io.Serializable;

public class TimerRecord implements Serializable{
	int min;
	boolean isTimerChoosen;
	boolean originalTimerFalge;
	boolean timeFlagTemp;
	boolean clearTimer;
	int cntMin;
	int cntSec;
	

	public boolean isTimeFlagTemp() {
		return timeFlagTemp;
	}

	public boolean isClearTimer() {
		return clearTimer;
	}

	public void setClearTimer(boolean clearTimer) {
		this.clearTimer = clearTimer;
	}

	public void setTimeFlagTemp(boolean timeFlagTemp) {
		this.timeFlagTemp = timeFlagTemp;
	}

	public boolean isOriginalTimerFalge() {
		return originalTimerFalge;
	}

	public void setOriginalTimerFalge(boolean originalTimerFalge) {
		this.originalTimerFalge = originalTimerFalge;
	}

	public int getCntMin() {
		return cntMin;
	}

	public void setCntMin(int cntMin) {
		this.cntMin = cntMin;
	}

	public int getCntSec() {
		return cntSec;
	}

	public void setCntSec(int cntSec) {
		this.cntSec = cntSec;
	}

	public int getMin() {
		return min;
	}

	public boolean isTimerChoosen() {
		return isTimerChoosen;
	}

	public void setTimerChoosen(boolean isTimerChoosen) {
		this.isTimerChoosen = isTimerChoosen;
	}

	public void setMin(int min) {
		this.min = min;
	}
	

}
