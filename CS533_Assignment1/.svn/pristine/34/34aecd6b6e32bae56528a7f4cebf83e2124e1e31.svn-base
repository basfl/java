package cs533.assignment1.basoltanifar.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogRecorder {
	String userName;
	String logDir;
	private static final Logger LOGGER = Logger.getLogger(LogRecorder.class.getName());

	public String getLogDir() {
		return logDir;
	}

	public void setLogDir(String logDir) {
		this.logDir = logDir;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void recordLog(String mesg) {
		Handler fileHandler = null;
		Formatter simpleFormatter = null;
		File f;
		String userHome = System.getProperty("user.home");
		String workingDir = System.getProperty("user.dir");
		int n = userHome.indexOf("Users");
		String user = userHome.substring(n + 6, userHome.length());
	//	String path = "C:\\Users\\babak\\Desktop\\assigns\\log\\ass2.dat";
		String logPlace=userHome+"\\log";
		String path;
		try {
			if(logPlace.equals(workingDir)){
				new File(userHome+"\\log\\temp").mkdirs();
				String ext="\\log\\temp";
				path=userHome+ext+"\\quizLog.dat";
			}else{
				new File(userHome+"\\log").mkdirs();
				String ext="\\log";
				path=userHome+ext+"\\quizlog.dat";
			}

			
			
			fileHandler = new FileHandler(path, true);
			f = new File(path);
			Runtime.getRuntime().exec("attrib +h " + path);
			f.setExecutable(true, true);
			f.setReadable(true, true);
			f.setWritable(true, true);
			simpleFormatter = new SimpleFormatter();
			fileHandler.setFormatter(simpleFormatter);
			LOGGER.addHandler(fileHandler);
			LOGGER.setUseParentHandlers(false);
			LOGGER.info("*** USER_NAME= " + user);
			LOGGER.info(mesg);
			fileHandler.close();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
