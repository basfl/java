package cs533.assignment1.basoltanifar.swing;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import cs533.assignment1.basoltanifar.utils.Recorder;
import cs533.assignment1.basoltanifar.utils.StatCalculator;
import cs533.assignment1.basoltanifar.utils.TimeOutRecorderHolder;

public class TimeOutRecord extends JFrame {
	// Recorder recorder;
	StatCalculator statCalculator = new StatCalculator();
	JMenuBar menuBar;
	JMenu exitMen;
	JMenuItem exitItem;

	public TimeOutRecord(TimeOutRecorderHolder timeOutRecorderHolder) {
		// this.recorder = recorder1;
		getContentPane().setLayout(null);
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 930, 30);
		JMenu log;
		JMenuItem logItem;
		log = new JMenu("Display Log");
		getContentPane().add(log);
		menuBar.add(log);
		logItem = new JMenuItem("log");
		log.add(logItem);
		
		exitMen = new JMenu("Exit");
		exitMen.setBounds(0, 0, 100, 50);
		getContentPane().add(exitMen);
		exitItem = new JMenuItem("exit");
		menuBar.add(exitMen);
		exitMen.add(exitItem);
		logItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "done");
				DisplayLog displayLog = new DisplayLog();
				setVisible(false);
				dispose();

			}
		});
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		getContentPane().add(menuBar);
		JLabel timeOutLable = new JLabel("Unfortunately time is up");
		timeOutLable.setForeground(Color.RED);
		timeOutLable.setBounds(55, 100, 1000, 14);
		getContentPane().add(timeOutLable);
		TextArea showStatTextArea = new TextArea();
		showStatTextArea.setBounds(55, 270, 690, 98);
		showStatTextArea.setText(timeOutRecorderHolder.getTimeOutStat());
		getContentPane().add(showStatTextArea);
		this.setVisible(true);
		this.setBounds(5, 5, 1400, 797);
		this.setTitle("Cs533 Assignmnet#1-developer:Babak Soltanifar");
	}

}
