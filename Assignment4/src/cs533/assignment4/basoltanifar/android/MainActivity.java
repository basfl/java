package cs533.assignment4.basoltanifar.android;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import cs533.assignment4.basoltanifar.file.operations.FileOrganizer;
import cs533.assignment4.basoltanifar.file.operations.FileValidator;
import cs533.assignment4.basoltanifar.utils.Recorder;

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener {
	Spinner spin;
	String fileName;
	String path;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final FileOrganizer fileOrganizer = new FileOrganizer();
		final FileValidator fileValidator = new FileValidator();
		final Recorder recorder = new Recorder();
		final EditText questionNumber = (EditText) findViewById(R.id.qn);
		final Button insert = (Button) findViewById(R.id.insert);
		final Button insertFile = (Button) findViewById(R.id.fileInsert);
		final EditText filePath = (EditText) findViewById(R.id.filePathTextEditor);
		filePath.setVisibility(filePath.INVISIBLE);
		fileOrganizer.questionAndAnswerMap.clear();
		spin = (Spinner) findViewById(R.id.spinner1);
		////////////////////////////////////////////////////////////
		File dir = new File("/mnt/sdcard/");
		Toast mesg;
		List<String> arryAdapter = new ArrayList<>();
		if (dir.isDirectory() && dir.exists()) {
			mesg = Toast.makeText(getApplicationContext(), "directory exist", Toast.LENGTH_LONG);
			mesg.show();
		} else {
			mesg = Toast.makeText(getApplicationContext(), "directory not  exist", Toast.LENGTH_LONG);
			mesg.show();
			dir.mkdir();
		}
		File[] list = dir.listFiles();
		for (File f : list) {
			Log.d("***my***", "****" + f.getName() + "*** absolut**" + f.getAbsolutePath());

			arryAdapter.add(f.getName());

		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,
				arryAdapter);
		spin.setAdapter(adapter);
		spin.setOnItemSelectedListener(this);

		///////////////////////////////////////////////////////////
		// final EditText qalabel=(EditText)findViewById(R.id.textView2);
		// qalabel.setBackgroundColor(Color.RED);
		insertFile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("file enter is ", filePath.getText().toString());
				// just to test on my phone
				// filePath.setText(Environment.getDataDirectory().toString());
				// Toast tp = Toast.makeText(getApplicationContext(),
				// Environment.getDataDirectory().toString(),
				// Toast.LENGTH_LONG);
				// tp.show();
				// Intent intClass = new Intent(getApplicationContext(),
				// FourthActivity.class);
				// startActivity(intClass);
				////////////////////////
				path = "/mnt/sdcard/" + fileName;
				
				getFileDirectory(path);

				//////////////////////

			}
/*
 * 
 */
			private void getFileDirectory(String path) {
				
				recorder.setPath(path);
				if (new File(path).exists()) {
					Log.d("*******File", "file exist");
				} else {
					Log.d("******************", "does not exist");
				}
				try {
					Map<Integer, String> fileOrgMap = null;
					fileOrgMap = fileOrganizer.readFile(path);
					final int qn = fileOrgMap.size();
					fileValidator.validate(fileOrgMap);
					boolean isValid = fileOrganizer.validat();
					recorder.setFileMapFromOrgizer(fileOrgMap);
					if (isValid == true) {
						Log.d("***** IS VALID", "********* IS VALID");
						Toast toast = Toast.makeText(getApplicationContext(), "Number of questions available is" + qn,
								Toast.LENGTH_SHORT);
						toast.show();
						insert.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View v) {
								// int qn =
								// Integer.parseInt(insert.getText().toString().intern().trim());
								// insert.getText();
//								final int qn = fileOrgMap.size();
//								fileValidator.validate(fileOrgMap);
//								boolean isValid = fileOrganizer.validat();
//								recorder.setFileMapFromOrgizer(fileOrgMap);

								String s = questionNumber.getText().toString();
								int qnchoosen = Integer.parseInt(s.trim().intern());

								if (qnchoosen > qn) {

									Toast mesg = Toast.makeText(getApplicationContext(), "Sorry your number is out of bound",
											Toast.LENGTH_LONG);
									mesg.show();
								} else if (qnchoosen < 0 || qnchoosen == 0) {

									Toast mesg1 = Toast.makeText(getApplicationContext(),
											"Sorry your number can not be negative or zero", Toast.LENGTH_LONG);
									mesg1.show();
								} else {

									recorder.setQnumber(qnchoosen);
									recorder.setViewNumber(1);
									recorder.setStartTime(System.currentTimeMillis());
									recorder.setStartSessionTime(System.currentTimeMillis());
									Intent intClass = new Intent(getApplicationContext(), SecondActivity.class);
									intClass.putExtra("recorder", recorder);
									startActivity(intClass);
								}

							}

						});
					} else {
						Log.d("NOT VALID", "NOT VALID");
						Toast fMesg=Toast.makeText(getApplicationContext(), "system can not validate your file", Toast.LENGTH_LONG);
						fMesg.show();
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
/*
 * 			
 */
		});
//		 path = "/mnt/sdcard/sample.txt";
//		// System.out.println("***before*** " + path);
//		recorder.setPath(path);
//		if (new File(path).exists()) {
//			Log.d("*******File", "file exist");
//		} else {
//			Log.d("******************", "does not exist");
//		}
//		try {
//			Map<Integer, String> fileOrgMap = null;
//			fileOrgMap = fileOrganizer.readFile(path);
//			final int qn = fileOrgMap.size();
//			fileValidator.validate(fileOrgMap);
//			boolean isValid = fileOrganizer.validat();
//			recorder.setFileMapFromOrgizer(fileOrgMap);
//			if (isValid == true) {
//				Log.d("***** IS VALID", "********* IS VALID");
//				Toast toast = Toast.makeText(getApplicationContext(), "Number of questions available is" + qn,
//						Toast.LENGTH_SHORT);
//				toast.show();
//				insert.setOnClickListener(new OnClickListener() {
//
//					@Override
//					public void onClick(View v) {
//						// int qn =
//						// Integer.parseInt(insert.getText().toString().intern().trim());
//						// insert.getText();
////						final int qn = fileOrgMap.size();
////						fileValidator.validate(fileOrgMap);
////						boolean isValid = fileOrganizer.validat();
////						recorder.setFileMapFromOrgizer(fileOrgMap);
//
//						String s = questionNumber.getText().toString();
//						int qnchoosen = Integer.parseInt(s.trim().intern());
//
//						if (qnchoosen > qn) {
//
//							Toast mesg = Toast.makeText(getApplicationContext(), "Sorry your number is out of bound",
//									Toast.LENGTH_LONG);
//							mesg.show();
//						} else if (qnchoosen < 0 || qnchoosen == 0) {
//
//							Toast mesg1 = Toast.makeText(getApplicationContext(),
//									"Sorry your number can not be negative or ero", Toast.LENGTH_LONG);
//							mesg1.show();
//						} else {
//
//							recorder.setQnumber(qnchoosen);
//							recorder.setViewNumber(1);
//							recorder.setStartTime(System.currentTimeMillis());
//							recorder.setStartSessionTime(System.currentTimeMillis());
//							Intent intClass = new Intent(getApplicationContext(), SecondActivity.class);
//							intClass.putExtra("recorder", recorder);
//							startActivity(intClass);
//						}
//
//					}
//
//				});
//			} else {
//				Log.d("NOT VALID", "NOT VALID");
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		fileName = spin.getSelectedItem().toString();
		

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}
