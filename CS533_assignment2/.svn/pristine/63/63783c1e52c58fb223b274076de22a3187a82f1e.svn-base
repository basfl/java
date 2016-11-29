package cs533.assignment2.basoltanifar.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import cs533.assignment2.basoltanifar.timer.TimerApp;
import cs533.assignment2.basoltanifar.timer.TimerListener;
import cs533.assignment2.basoltanifar.utils.TimeOutRecorder;

public class App {
	public static void main(String[] args) throws IOException {
		TimerListener timerListener = null;
		TimerApp timerApp;
		TimeOutRecorder timeOutRecorder = new TimeOutRecorder();
		
		if(args.length!=0){
			if(args[0].equals("log")){
				displayLog();
			}else{
				System.out.println("sorry wrong argument");
			}
		}else{
			System.out.println("Do you want to try your session with timer (Y|N)");
			Scanner option = new Scanner(System.in);
			String sOption = option.nextLine();
			if (sOption.equals("Y") || sOption.equals("y")) {
				System.out.println("Enter your desire time for entire session in minute");
				Scanner min = new Scanner(System.in);
				int intMin = min.nextInt();
				System.out.println(intMin);
				timeOutRecorder.setTimeOutInMin(intMin);
				timerListener = new TimerListener(intMin);
				timerApp = new TimerApp(timerListener);
				timerApp.doWork();
				// TimerApp timerApp1=new TimerApp(new TimerListener());
				// timerApp1.doWork();

			} else {
				MainMenu mainMenu = new MainMenu();
				mainMenu.displayUserOptions(timerListener);
			}
		}
		
	}

	private static void displayLog() throws IOException {
		java.io.FileReader f = null;
		BufferedReader br = null;
		String userHome = System.getProperty("user.home");
		String logPlace=userHome+"/log/.log.dat";
		try {

			f = new java.io.FileReader(logPlace);
			br = new BufferedReader(f);
			String sCurrentLine;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");
			while ((sCurrentLine = br.readLine()) != null) {
				stringBuilder.append(sCurrentLine);
				stringBuilder.append(ls);
			}
			System.out.println(stringBuilder.toString());
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			f.close();
			br.close();
		}
	
		
	}

}
