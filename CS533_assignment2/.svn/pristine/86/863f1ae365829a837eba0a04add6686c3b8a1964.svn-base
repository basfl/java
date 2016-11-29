package cs533.assignment2.basoltanifar.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogRecorder {
	private static final Logger LOGGER = Logger.getLogger(LogRecorder.class.getName());
	public void recordLog(String mesg) {
		Handler fileHandler = null;
		Formatter simpleFormatter = null;
		File f;
		String userHome = System.getProperty("user.home");
		String workingDir = System.getProperty("user.dir");
		int n = userHome.indexOf("home/");
		String user = userHome.substring(n + 5, userHome.length());
		String logPlace=userHome+"/log";
		String path;
		
		try {
			new File(logPlace).mkdir();
			path=logPlace+"/.log.dat";
			System.out.println(path);
			fileHandler = new FileHandler(path, true);
			f = new File(path);
			Runtime.getRuntime().exec("chmod go-rwx " + path);
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
