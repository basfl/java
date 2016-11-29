package cs533.assignment4.basoltanifar.android;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cs533.assignment4.basoltanifar.file.operations.FileOrganizer;
import cs533.assignment4.basoltanifar.file.operations.FileValidator;
import cs533.assignment4.basoltanifar.utils.Recorder;

public class OptionActivity extends ActionBarActivity {
	@Override
	public void onBackPressed() {
	    moveTaskToBack(true);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option);
		setTitle("Option Activity");
		FileOrganizer fileOrganizer = new FileOrganizer();
		FileValidator fileValidator = new FileValidator();
		final Recorder recorder = new Recorder();
		Bundle extras = getIntent().getExtras();
		String value = extras.getString("path");
		//Toast toast = Toast.makeText(getApplicationContext(), " Different option for same file" , Toast.LENGTH_SHORT);
		//toast.show();
		final EditText questionNumber = (EditText) findViewById(R.id.et);
		final Button insert = (Button) findViewById(R.id.insert);
		String path =value;
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
				Toast toast1 = Toast.makeText(getApplicationContext(), "Number of questions available is" + qn,
						Toast.LENGTH_SHORT);
				toast1.show();
				insert.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// int qn =
						// Integer.parseInt(insert.getText().toString().intern().trim());
						// insert.getText();
						String s = questionNumber.getText().toString();
						int qn = Integer.parseInt(s.trim().intern());
						recorder.setQnumber(qn);
						recorder.setViewNumber(1);
						recorder.setStartTime(System.currentTimeMillis());
						recorder.setStartSessionTime(System.currentTimeMillis());
						Intent intClass = new Intent(getApplicationContext(), SecondActivity.class);
						intClass.putExtra("recorder", recorder);
						startActivity(intClass);

					}
				});
			} else {
				Log.d("NOT VALID", "NOT VALID");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}