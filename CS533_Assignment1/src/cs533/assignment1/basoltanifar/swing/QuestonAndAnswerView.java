package cs533.assignment1.basoltanifar.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import cs533.assignment1.basoltanifar.file.operations.FileSlicer;
import cs533.assignment1.basoltanifar.utils.LogRecorder;
import cs533.assignment1.basoltanifar.utils.Recorder;
import cs533.assignment1.basoltanifar.utils.StatCalculator;
import cs533.assignment1.basoltanifar.utils.TimeOutRecorderHolder;

@SuppressWarnings("serial")
public class QuestonAndAnswerView extends JFrame {
	public int qViewCounter;
	public int questionNumber;
	public String correctAnswer;
	StatCalculator statCalculator = new StatCalculator();
	private int maxCharacterPerLine = 75;
	Timer timer;
	TimeOutRecorderHolder timeOutRecorderHolder = new TimeOutRecorderHolder();
	LogRecorder logRecorder = new LogRecorder();
	// boolean flag = false;

	///// this varible is for keeping the answer it is -1 in case if user did
	///// not choose any answer ///////////
	public int finalAnswer = -1;
	////////////////////////////////////////////////////////
	Recorder recorder;
	FileSlicer fileSlicer;

	@SuppressWarnings("unused")
	public QuestonAndAnswerView(Recorder record1) {
		this.recorder = record1;
		this.getContentPane().setLayout(null);
		////////////////////////////////////////////////
		TextArea question = new TextArea();
		
		///////////////////////////////////////////////

		JLabel timerLabel = new JLabel();
		timerLabel.setForeground(Color.RED);
		timerLabel.setBounds(50, 20, 1000, 14);
		this.getContentPane().add(timerLabel);
		if (recorder.isTimerChoosen() == true) {

			timer = new Timer(1000, new ActionListener() {
				int cnt = recorder.getCntSec();
				int m = recorder.getCntMin();

				@Override
				public void actionPerformed(ActionEvent e) {
					if (recorder.isClearTimer() == true) {
						
						timer.stop();
						// cnt=0;
						// m=0;
						// recorder.setCntMin(m);
						// recorder.setCntSec(cnt);
					}
					if (cnt == 60) {
						cnt = 0;
						m++;
					}
					cnt++;
					recorder.setCntMin(m);
					recorder.setCntSec(cnt);
					timerLabel.setText("Timer: " + m + ":" + cnt);
					

					if ((recorder.getMin() == m) && (cnt == 1)) {

						timer.stop();
						recorder.setTimeFlagTemp(true);
						logRecorder
								.recordLog("****Time Out !!!! *** \n" + timeOutRecorderHolder.getTimeOutStat(recorder));
						TimeOutRecord timeOutRecord = new TimeOutRecord(timeOutRecorderHolder);
						timeOutRecord.setVisible(true);
						setVisible(false);
						// timer.stop();

					}

					
					// timer.stop();

				}
			});
			timer.start();
			if (recorder.isClearTimer() == true) {
				
				// timer.stop();
				// timer.restart();
				recorder.setClearTimer(false);
				timer.start();
			}

		}

		/////////////////////////////////////////////

		if (recorder.getViewNumber() <= recorder.getQnumber()) {

			this.setTitle("Question # " + recorder.getViewNumber());
			///////////////////////////////
			int index = (recorder.getViewNumber() - 1);

			////////////////// this is the generated number
			int numberGen = recorder.randomGenerator().get(index);

			//////////////////////////////// just for title///
			//////////////////////////////////////////////////
			qViewCounter = recorder.getViewNumber() + 1;
			recorder.setViewNumber(qViewCounter);
			////////////////////////////////////////////
			fileSlicer = new FileSlicer(recorder.getFileMapFromOrgizer());
			fileSlicer.slice(numberGen);
			List<String> finalAnswers = new ArrayList<>();
			//////////////////
			for (int i = 0; i < fileSlicer.answers.length; i++) {
				if (i == 0) {
					// removing correct answer
					correctAnswer = fileSlicer.answers[i];
				} else {
					finalAnswers.add(fileSlicer.answers[i]);
				}
			}

			////////////////
			question.setText(fileSlicer.questionWithoutAnswer);
			this.qViewCounter = qViewCounter;
			this.getContentPane().setLayout(null);
			question.setBounds(55, 74, 1000, 109);
			this.getContentPane().add(question);
			////////////
			JLabel questionLabel = new JLabel("Question");
			questionLabel.setBounds(55, 40, 100, 14);
			this.getContentPane().add(questionLabel);
			//////////////////
			JButton btnNext = new JButton("Next");
			btnNext.setBounds(204, 620, 109, 23);
			this.getContentPane().add(btnNext);

			////////////////////////
			JRadioButton[] bl = new JRadioButton[10];
			ButtonGroup group = new ButtonGroup();
			int y = 209;
			JPanel panel = new JPanel();
			panel.setBounds(50, 220, 800, 350);
			panel.setBorder(BorderFactory.createTitledBorder("Answers"));
			GridLayout gridLayout = new GridLayout(7, 1);
			panel.setLayout(gridLayout);
			this.getContentPane().add(panel);
			// @SuppressWarnings("unused")
			List<JRadioButton> radioButtons = new ArrayList<>();
			if (finalAnswers.size() == 0) {
				JOptionPane.showMessageDialog(null, "No answers are provided for this question in the loaded file  ");
			}
			for (int i = 0; i < finalAnswers.size(); i++) {

				int cnt = i;
				int aindex = i + 1;
				// final answer length must be check to make sure it does not
				// exceed max line character
				int finalAnswersSize = finalAnswers.get(i).length();
				String finalAnswerText;
				if (finalAnswersSize > maxCharacterPerLine) {
					finalAnswerText = finalAnswers.get(i).substring(0, 75);
					JOptionPane.showMessageDialog(null,
							" Answer " + aindex + " length exceed one line only 75 characters will be display here");

				} else {
					finalAnswerText = finalAnswers.get(i);
				}

				bl[i] = new JRadioButton("(" + aindex + ")" + finalAnswerText);
				// aindex++;
				bl[i].setLayout(new FlowLayout());

				// bl[i].setLocation(10, y);
				// bl[i].setBounds(10, 10, 1000, 50);
				bl[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						if (bl[cnt].isSelected()) {

							finalAnswer = cnt;

						}

					}
				});
				// setLayout(new SpringLayout());

				panel.add(bl[i]);
				group.add(bl[i]);
				// setLayout(new BorderLayout());

			}
			btnNext.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (finalAnswer == -1) {
						JOptionPane.showMessageDialog(null, "you need to select an answer!");

					} else {

						/*
						 * adding question to map with identifyier either true
						 * or false so i can show the record
						 */
						int ca = 0;
						if (correctAnswer.length() > 1) {
							JOptionPane.showMessageDialog(null,
									" the answer you provided in text should be a number please validate you text and try again");

						} else {
							ca = Integer.parseInt(correctAnswer.intern().trim());
							if (ca == 0) {
								JOptionPane.showMessageDialog(null,
										" Correct answer provide for this question in text file is 0 please check your file and try again");

							}
						}
						if ((finalAnswer + 1) == ca) {
							JOptionPane.showMessageDialog(null, "Correct answer !!");
							recorder.setCorrectAndWorngQuestionsMap(recorder.random.get(index), true);
							recorder.setCorrectAndWorngQuestionsMapForEntireSession(recorder.random.get(index), true);

						} else if (ca == 0) {
							// in this case nothing to do
						} else {
							JOptionPane.showMessageDialog(null,
									"your answer was worng , the correct answer is answer # " + ca);
							recorder.setCorrectAndWorngQuestionsMap(recorder.random.get(index), false);
							recorder.setCorrectAndWorngQuestionsMapForEntireSession(recorder.random.get(index), false);

						}

						timeOutRecorderHolder.setTimeOutStat(timeOutRecorderHolder.getTimeOutStat(recorder));
						QuestonAndAnswerView questionAndAnswerView = new QuestonAndAnswerView(recorder);
						questionAndAnswerView.setVisible(true);
						setVisible(false);

					}

				}

			});
			/////////////////////////////////

		} else {
			/*
			 * 
			 */

			/*
			 * this part suppose to take care of out of index
			 */
			// static boolean showStat=false;
			///////////////////////////////
			logRecorder.recordLog(statCalculator.getStatic(recorder));
			if (recorder.isTimerChoosen() == true) {
				recorder.setTimerChoosen(false);
				
				timerLabel.setVisible(false);
				recorder.setClearTimer(true);
			}

			//////////////////////////////
			JButton continueSession = new JButton("Continue with another Session with same criteria");
			continueSession.setBounds(124, 620, 400, 23);
			this.getContentPane().add(continueSession);
			/////////////////////////////////////////////
			TextArea showStatTextArea = new TextArea();
			showStatTextArea.setBounds(55, 270, 690, 98);
			///////////////////////////////////////////////
			JPanel panels = new JPanel();
			panels.setBounds(40, 150, 800, 350);
			panels.setBorder(BorderFactory.createTitledBorder("Stats"));
			////////////////////////////////////////////////
			JMenuBar menuBar;
			JMenu newSessionM;
			JMenuItem newSessionItem;
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 1400, 30);
			newSessionM = new JMenu("New Session With New Criteria");
			newSessionM.setBounds(0, 0, 100, 50);
			getContentPane().add(newSessionM);
			newSessionItem = new JMenuItem("New Session");
			menuBar.add(newSessionM);
			newSessionM.add(newSessionItem);
			JMenu TotalStat;
			JMenuItem totalStatItem;
			TotalStat = new JMenu("Total Stat For This Session from Beginning");
			getContentPane().add(TotalStat);
			menuBar.add(TotalStat);
			totalStatItem = new JMenuItem("Total Stat");
			TotalStat.add(totalStatItem);
			//////////////////////////////////////
			JMenu option;
			JMenuItem optionItem;
			option = new JMenu("Set new Options for Same File");
			getContentPane().add(option);
			menuBar.add(option);
			optionItem = new JMenuItem("Set new options");
			option.add(optionItem);
			optionItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					InitializeSessionViewNewOption initializeSessionViewNewOption = new InitializeSessionViewNewOption(
							recorder.getPath());
					setVisible(false);
					dispose();

				}
			});
			////////////////////////////////
			JMenu log;
			JMenuItem logItem;
			log = new JMenu("Display Log");
			getContentPane().add(log);
			menuBar.add(log);
			logItem = new JMenuItem("log");
			log.add(logItem);
			logItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					DisplayLog displayLog = new DisplayLog();
					setVisible(false);
					dispose();

				}
			});
			///////////////////////////////
			JMenu exit;
			JMenuItem exitItem;
			exit = new JMenu("Exit");
			getContentPane().add(exit);
			menuBar.add(exit);
			exitItem = new JMenuItem("Exit");
			exit.add(exitItem);
			exitItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);

				}
			});

			///////////////////////////////////////

			totalStatItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showStatTextArea.setText(statCalculator.getTotalStatic(recorder));
					getContentPane().add(showStatTextArea);
					getContentPane().add(panels);
					repaint();

				}

			});

			newSessionItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					View v = new View();
					setVisible(false);
					dispose();

				}
			});
			getContentPane().add(menuBar);

			///////////////////////////////////////////////////////

			continueSession.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (recorder.alredayChoosen.size() == recorder.getFileMapFromOrgizer().size()) {
						JOptionPane.showMessageDialog(null, "No more question left");
						showStatTextArea.setText(statCalculator.getStatic(recorder));
						getContentPane().add(showStatTextArea);
						getContentPane().add(panels);
						repaint();

					} else {
						recorder.setViewNumber(1);
						recorder.setStartTime(System.currentTimeMillis());
						recorder.random.clear();
						recorder.correctAndWorngQuestionsMap.clear();
						if (recorder.isOriginalTimerFalge() == true) {

							recorder.setTimerChoosen(true);
							recorder.setCntMin(0);
							recorder.setCntSec(0);

						}

						int n = recorder.getFileMapFromOrgizer().size() - recorder.alredayChoosen.size();
						// JOptionPane.showMessageDialog(null, "" + n + "
						// questions left");

						if (n < recorder.getQnumber()) {
							JOptionPane.showMessageDialog(null, "you choose " + recorder.getQnumber()
									+ "for this session." + n + " questions left which will be use for this session  ");
							recorder.setQnumber(n);
						} else {
							JOptionPane.showMessageDialog(null, "" + n + " questions left");
						}
						recorder.setCntMin(0);
						recorder.setCntSec(0);
						timeOutRecorderHolder.setTimeOutStat(timeOutRecorderHolder.getTimeOutStat(recorder));
						QuestonAndAnswerView qt = new QuestonAndAnswerView(recorder);
						qt.setVisible(true);
						setVisible(false);

					}

				}

			});

			JButton statBtn = new JButton("Current Session Stats");
			statBtn.setBounds(684, 620, 300, 23);
			this.getContentPane().add(statBtn);
			statBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					showStatTextArea.setText(statCalculator.getStatic(recorder));
					getContentPane().add(showStatTextArea);
					getContentPane().add(panels);
					repaint();

				}

			});

		}
		setLayout(new BorderLayout());

		this.setBounds(5, 5, 1400, 797);

		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
