package cs533.assignment1.basoltanifar.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Recorder extends TimerRecord {
	int qnumber;
	int viewNumber;
	long startTime;
	long endTime;
	long startSessionTime;
	String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getStartSessionTime() {
		return startSessionTime;
	}

	public void setStartSessionTime(long startSessionTime) {
		this.startSessionTime = startSessionTime;
	}

	// record all generated random number
	public Set<Integer> alredayChoosen = new HashSet<>();
	// random number per session
	public List<Integer> random = new ArrayList<>();
	// track question status per session
	public Map<Integer, Boolean> correctAndWorngQuestionsMap = new HashMap<>();
	//// track question status for entire session
	public Map<Integer, Boolean> correctAndWorngQuestionsMapForEntireSession = new HashMap<>();

	public void setCorrectAndWorngQuestionsMapForEntireSession(int question, boolean answer) {
		correctAndWorngQuestionsMapForEntireSession.put(question, answer);

	}

	// file map from organizer
	Map<Integer, String> fileMapFromOrgizer;

	public long getEndTime() {
		return endTime;
	}

	public Map<Integer, String> getFileMapFromOrgizer() {
		return fileMapFromOrgizer;
	}

	public void setFileMapFromOrgizer(Map<Integer, String> fileMapFromOrgizer) {
		this.fileMapFromOrgizer = fileMapFromOrgizer;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public int getQnumber() {
		return qnumber;
	}

	public void setQnumber(int qnumber) {
		this.qnumber = qnumber;
	}

	public int getViewNumber() {
		return viewNumber;
	}

	public void setViewNumber(int viewNumber) {
		this.viewNumber = viewNumber;
	}

	public String sessionTime() {
		long elapsedTime = endTime - startTime;
		long elapsedSeconds = elapsedTime / 1000;
		@SuppressWarnings("unused")
		long secondsDisplay = elapsedSeconds % 60;
		long elapsedMinutes = elapsedSeconds / 60;
		String s = "this session took " + elapsedMinutes + " minutes and " + secondsDisplay + " seconds \n";
		return (s);
	}

	public String totalSessionTime() {
		long elapsedTime = endTime - startSessionTime;
		long elapsedSeconds = elapsedTime / 1000;
		@SuppressWarnings("unused")
		long secondsDisplay = elapsedSeconds % 60;
		long elapsedMinutes = elapsedSeconds / 60;
		String s = "this session took " + elapsedMinutes + " minutes and " + secondsDisplay + " seconds \n";
		return (s);
	}

	// randomly generate number and make sure it is not being used perivously
	public List<Integer> randomGenerator() {
		// here i check for random number test 10=qnumber
		while (random.size() < qnumber) {
			Random rand = new Random();
			Integer value = rand.nextInt(fileMapFromOrgizer.size());

			if (compare(value) == true) {
				
				random.add(value);
				alredayChoosen.add(value);

			}
		}
		return random;
	}

	public void setCorrectAndWorngQuestionsMap(int question, boolean answer) {
		correctAndWorngQuestionsMap.put(question, answer);

	}

	private boolean compare(Integer value) {
		for (Integer in : alredayChoosen) {
			if (value == in) {
				return false;
			}
		}
		return true;
	}

}
