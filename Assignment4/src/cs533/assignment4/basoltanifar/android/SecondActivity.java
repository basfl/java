package cs533.assignment4.basoltanifar.android;

import java.util.ArrayList;
import java.util.List;

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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import cs533.assignment4.basoltanifar.file.operations.FileSlicer;
import cs533.assignment4.basoltanifar.utils.Recorder;

public class SecondActivity extends ActionBarActivity implements OnItemSelectedListener {
	int spinerPosInt;
	@Override
	public void onBackPressed() {
	    moveTaskToBack(true);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		setTitle("Second Activity");
		// EditText questionTV = (EditText) findViewById(R.id.question);
		TextView questionTV = (TextView) findViewById(R.id.textView1);
		// ListView listView = (ListView) findViewById(R.id.listView);
		final Spinner spin = (Spinner) findViewById(R.id.spinner1);
		Button insert = (Button) findViewById(R.id.insert);

		final Recorder recorder = (Recorder) getIntent().getSerializableExtra("recorder");
		
		recorder.alreadyChoosen();
		int qViewCounter;
		int questionNumber;
		String correctAnswer = null;
		int spinerPos;
		final int ca;
		if (recorder.getViewNumber() <= recorder.getQnumber()) {

			final int index = (recorder.getViewNumber() - 1);
			int numberGen = recorder.randomGenerator().get(index);
			Log.d("***number gen****","&& "+ numberGen);
			qViewCounter = recorder.getViewNumber() + 1;
			recorder.setViewNumber(qViewCounter);
			////////////////////////////////////////
			FileSlicer fileSlicer = new FileSlicer(recorder.getFileMapFromOrgizer());

			fileSlicer.slice(numberGen);
			List<String> finalAnswers = new ArrayList<>();
			String question = fileSlicer.questionWithoutAnswer;
			// slicing the question line
			String[] qlines = question.split("\r\n|\r|\n");
			StringBuilder sb = new StringBuilder();
			for (String qline : qlines) {
				if (qline.length() > 79) {
					String cutQuestion = qline.substring(0, 79);
					sb.append(qline);
					// questionTV.setText(cutQuestion);
				} else {
					sb.append(qline);
					// questionTV.setText(qline);
				}
			}
			questionTV.setText(sb);

			for (int i = 0; i < fileSlicer.answers.length; i++) {
				if (i == 0) {
					// removing correct answer
					correctAnswer = fileSlicer.answers[i];

				} else {
					finalAnswers.add(fileSlicer.answers[i]);
				}
			}
			ca = Integer.parseInt(correctAnswer.intern().trim());
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_single_choice, finalAnswers);
			spin.setAdapter(adapter);
			spin.setOnItemSelectedListener(this);

			// TextView tv1 = (TextView) spin.getSelectedView();
			// String result = tv1.getText().toString();
			// Log.d("*******", "select "+ result);

			// listView.setAdapter(adapter);
			// listView.setOnItemClickListener(new OnItemClickListener() {
			//
			// @Override
			// public void onItemClick(AdapterView<?> parent, View view, int
			// position, long id) {
			// Log.d("cliecked on ", "pos" + position);
			// // Intent refresh = new Intent(getApplicationContext(),
			// // Second_Activity.class);
			// // startActivity(refresh);
			//
			// }
			// });

			///////////////////////////////////////
			insert.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Log.d("POS ID", "POSITION IS " + spinerPosInt + "correct answer is " + ca);
					recorder.setCorrectAndWorngQuestionsMap(recorder.random.get(index), true);
					recorder.setCorrectAndWorngQuestionsMapForEntireSession(recorder.random.get(index), true);
					// int ca = Integer.parseInt(correctAnswer.intern().trim());
					if (spinerPosInt + 1 == ca) {
						Log.d("answer correctly", "answer correctly");
						Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_LONG).show();
						recorder.setCorrectAndWorngQuestionsMap(recorder.random.get(index), true);
						recorder.setCorrectAndWorngQuestionsMapForEntireSession(recorder.random.get(index), true);
					} else {
						Toast.makeText(getApplicationContext(),
								"your answer was worng , the correct answer is answer # " + ca, Toast.LENGTH_LONG)
								.show();
						recorder.setCorrectAndWorngQuestionsMap(recorder.random.get(index), false);
						recorder.setCorrectAndWorngQuestionsMapForEntireSession(recorder.random.get(index), false);
					}
					Intent intClass = new Intent(getApplicationContext(), SecondActivity.class);
					intClass.putExtra("recorder", recorder);
					startActivity(intClass);

				}
			});
		} else {
			insert.setVisibility(Button.GONE);
			spin.setVisibility(Spinner.GONE);
			Log.d("****", "end");
			Intent intClass = new Intent(getApplicationContext(), ThirdActivity.class);
			intClass.putExtra("recorder", recorder);
			startActivity(intClass);

		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		String item = parent.getItemAtPosition(position).toString();

		// Showing selected spinner item

		spinerPosInt = position;

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}
