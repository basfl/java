package cs533.assignment4.basoltanifar.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cs533.assignment4.basoltanifar.utils.Recorder;
import cs533.assignment4.basoltanifar.utils.StatCalculator;

public class ThirdActivity extends ActionBarActivity {
	// Recorder recorder = (Recorder)
	// getIntent().getSerializableExtra("recorder");
	@Override
	public void onBackPressed() {
		moveTaskToBack(true);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		setTitle("Third Activity");
		final Recorder recorder = (Recorder) getIntent().getSerializableExtra("recorder");
		Button stat = (Button) findViewById(R.id.button1);
		final TextView statView = (TextView) findViewById(R.id.textView1);
		final StatCalculator statCalculator = new StatCalculator();
		stat.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String statText = statCalculator.getStatic(recorder);
				statView.setText(statText);

			}
		});
		Button totalStat = (Button) findViewById(R.id.button2);
		totalStat.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// finish();
				// startActivity(getIntent());
				String totalSatText = statCalculator.getTotalStatic(recorder);
				statView.setText(totalSatText);
				// Intent intClass = new Intent(getApplicationContext(),
				// FourthActivity.class);
				// startActivity(intClass);

			}
		});
		Button sameCriteria = (Button) findViewById(R.id.button3);
		sameCriteria.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				if (recorder.alredayChoosen.size() == recorder.getFileMapFromOrgizer().size()) {
					Toast.makeText(getApplicationContext(), "No More Question left", Toast.LENGTH_LONG).show();

				} else {
					recorder.setViewNumber(1);
					recorder.setStartTime(System.currentTimeMillis());
					recorder.random.clear();
					recorder.correctAndWorngQuestionsMap.clear();
					
					int n = recorder.getFileMapFromOrgizer().size() - recorder.alredayChoosen.size();
					if (n < recorder.getQnumber()) {

						Toast.makeText(getApplicationContext(),
								"you choose " + recorder.getQnumber() + "for this session." + n
										+ " questions left which will be use for this session  ",
								Toast.LENGTH_LONG).show();
						recorder.setQnumber(n);
					} else {

						Toast.makeText(getApplicationContext(), "" + n + " questions left", Toast.LENGTH_LONG).show();
					}
					// recorder.setCntMin(0);
					// recorder.setCntSec(0);
					recorder.getFileMapFromOrgizer().size();
					Intent intClass = new Intent(getApplicationContext(), SecondActivity.class);
					intClass.putExtra("recorder", recorder);
					startActivity(intClass);

				} // end of else

			}
		});
		Button newOptions = (Button) findViewById(R.id.button4);
		newOptions.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent intN1 = new Intent(getApplicationContext(), OptionActivity.class);
				intN1.putExtra("path", recorder.getPath());
				startActivity(intN1);

			}
		});
		Button startNew = (Button) findViewById(R.id.button5);
		startNew.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent newMain = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(newMain);

			}
		});
		Button exit = (Button) findViewById(R.id.button6);
		exit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				// int pid = android.os.Process.myPid();
				// android.os.Process.killProcess(pid);
				// System.exit(0);
				moveTaskToBack(true);

			}
		});
	}

}
