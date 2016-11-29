package cs533.assignment1.basoltanifar.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cs533.assignment1.basoltanifar.utils.LogRecorder;

@SuppressWarnings("serial")
public class View extends JFrame {
	JMenuBar menuBar;
	JMenu newM;
	JMenuItem startSession;
	JMenu logMenu;
	JMenuItem logMenuItem;

	public View() {
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 930, 30);
		newM = new JMenu("start");
		newM.setBounds(0, 0, 100, 50);
		getContentPane().add(newM);
		startSession = new JMenuItem("start");
		menuBar.add(newM);
		newM.add(startSession);
		getContentPane().add(menuBar);
		logMenu=new JMenu("Show log");
		logMenuItem=new JMenuItem("Show log");
		logMenu.add(logMenuItem);
		menuBar.add(logMenu);
		getContentPane().setLayout(null);
		startSession.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				@SuppressWarnings("unused")
				InitializeSessionView initializeSessionView = new InitializeSessionView();
				View.this.setVisible(false);

			}
		});
		logMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LogRecorder logRecorder=new LogRecorder();
				logRecorder.recordLog("*********************************");
				DisplayLog displayLog=new DisplayLog();
				View.this.setVisible(false);
				
			}
		});
		this.setVisible(true);
		this.setBounds(100, 100, 450, 300);
		this.setTitle("Cs533 Assignmnet#1-developer:Babak Soltanifar");
	}

}
