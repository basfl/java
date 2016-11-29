package cs533.assignment1.basoltanifar.swing;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DisplayLog extends JFrame {
	JMenuBar menuBar;
	JMenu exitMen;
	JMenuItem exitItem;

	public DisplayLog() {
		this.getContentPane().setLayout(null);
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 930, 30);
		exitMen = new JMenu("Exit");
		exitMen.setBounds(0, 0, 100, 50);
		getContentPane().add(exitMen);
		exitItem = new JMenuItem("exit");
		menuBar.add(exitMen);
		exitMen.add(exitItem);
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		getContentPane().add(menuBar);
		JLabel logLabel = new JLabel("*****LOG MESSAGES*******");
		logLabel.setForeground(Color.RED);
		logLabel.setBounds(55, 100, 1000, 14);
		getContentPane().add(logLabel);

		TextArea logMesg = new TextArea();
		logMesg.setBounds(55, 170, 890, 328);
		try {
			logMesg.setText(getLogMesg());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getContentPane().add(logMesg);
		this.setVisible(true);
		this.setBounds(5, 5, 1400, 797);
		this.setTitle("Cs533 Assignmnet-developer:Babak Soltanifar");
	}

	private String getLogMesg() throws IOException {
		java.io.FileReader f = null;
		BufferedReader br = null;
		try {

			f = new java.io.FileReader(getPath());
			br = new BufferedReader(f);
			String sCurrentLine;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");
			while ((sCurrentLine = br.readLine()) != null) {
				stringBuilder.append(sCurrentLine);
				stringBuilder.append(ls);
			}
		
			return stringBuilder.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			f.close();
			br.close();
		}
		return null;
	}

	private String getPath() {
		String userHome = System.getProperty("user.home");
		String workingDir = System.getProperty("user.dir");
		String path;
		String logPlace = userHome + "\\log";
		
		if (logPlace.equals(workingDir)) {
			// new File(userHome + "\\logs\\log\\temp").mkdirs();
			String ext = "\\log\\temp";
			path = userHome + ext + "\\quizlog.dat";
		} else {
			// new File(userHome + "\\logs\\log").mkdirs();
			String ext = "\\log";
			path = userHome + ext + "\\quizlog.dat";
		}

		return path;

	}

}
