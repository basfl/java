package cs533.assignment1.basoltanifar.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import cs533.assignment1.basoltanifar.file.operations.FileOrganizer;
import cs533.assignment1.basoltanifar.utils.Recorder;

@SuppressWarnings("serial")
public class InitializeSessionViewNewOption extends JFrame {
	String path = "";
	int numberOfQuestion;
	// pro = new Properties();
	Recorder recorder = new Recorder();
	Map<Integer, String> fileOrgMap;
	private FileOrganizer fileOrganizer;
	//////////////////////////////////////////////
	JMenuBar menuBar;
	JMenu newM;
	JMenuItem setTimer;

	////////////////////////////////////////////
	public InitializeSessionViewNewOption(String filePath) {
		fileOrganizer = new FileOrganizer();
		// Reading large file , it cash it in memory i need to release it
		// manually //
		fileOrganizer.questionAndAnswerMap.clear();
		getContentPane().setLayout(null);
		/////////////////////////////////////
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 930, 30);
		newM = new JMenu("Timer");
		newM.setBounds(0, 0, 100, 50);
		getContentPane().add(newM);
		setTimer = new JMenuItem("Set Timer");
		menuBar.add(newM);
		newM.add(setTimer);
		getContentPane().add(menuBar);
		setTimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String smin = JOptionPane.showInputDialog("Enter how many minutes you want to run session ");

				try {
					int min = Integer.parseInt(smin.trim().intern());
					if(min>0){
					recorder.setMin(min);
					recorder.setTimerChoosen(true);
					recorder.setOriginalTimerFalge(true);
					}else{
						JOptionPane.showMessageDialog(null, "your input  have discarded");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "you need to only enter number here please");
				}

			}
		});

		//////////////////////////////////////
		JTextField qNumbers;
		JLabel lblNewLabel = new JLabel("Enter Number of Question You Like For This Session\r\n");
		lblNewLabel.setBounds(70, 100, 332, 14);
		this.getContentPane().add(lblNewLabel);
		// question per session
		qNumbers = new JTextField();
		qNumbers.setBounds(66, 125, 64, 20);
		this.getContentPane().add(qNumbers);
		qNumbers.setColumns(10);
		recorder.setPath(filePath);

		try {
			fileOrgMap = fileOrganizer.readFile(filePath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean isValid = fileOrganizer.validat();

		if (isValid == false) {
			JOptionPane.showMessageDialog(null,
					"Validation of file failed!! Please make sure your file format is correct");
		} else {
			JOptionPane.showMessageDialog(null, " The file contains " + fileOrgMap.size() + " questions");
		}

		JButton insert = new JButton("Insert");
		insert.setBounds(173, 185, 89, 23);
		this.getContentPane().add(insert);

		insert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				qNumbers.getText();
				if (qNumbers.getText().equals(null) || qNumbers.getText().equals("")) {
					qNumbers.setText("1");
					JOptionPane.showMessageDialog(null,
							" You did not select any number of question system default it as one");
				}
				try {
					numberOfQuestion = Integer.parseInt(qNumbers.getText().trim().intern());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "you need to only enter number here please");
					numberOfQuestion = 0;

				}
				if (numberOfQuestion < 0) {
					JOptionPane.showMessageDialog(null, "you can not choose negative number");
				}else if (numberOfQuestion==0) {
					JOptionPane.showMessageDialog(null, " select number of questions again please");
				} else {

					if (filePath.equals(null) || filePath.equals("")) {
						JOptionPane.showMessageDialog(null, "please select the file");
					} else {
						// pro.setPath(path);
						recorder.setQnumber(numberOfQuestion);
						recorder.setViewNumber(1);
						recorder.setFileMapFromOrgizer(fileOrgMap);
						recorder.setStartTime(System.currentTimeMillis());
						recorder.setStartSessionTime(System.currentTimeMillis());
						if (numberOfQuestion > fileOrgMap.size()) {
							JOptionPane.showMessageDialog(null,
									" Number of question you choosed , is out of index of questions in your file ,currently you have "
											+ fileOrgMap.size() + "numbers of questions");
						} else {
							// have random generator here , so it is not out of
							// index
							recorder.randomGenerator();
							QuestonAndAnswerView questonAndAnswerView = new QuestonAndAnswerView(recorder);
							questonAndAnswerView.setVisible(true);
							setVisible(false);
						} // end of inner else

					} // end of path if else

				} // end of qnumber else
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 23, 414, 206);
		this.getContentPane().add(panel);
		this.setVisible(true);
		this.setBounds(100, 100, 500, 450);
		this.setTitle("Cs533 Assignmnet#1-developer:Babak Soltanifar");
	}

}
