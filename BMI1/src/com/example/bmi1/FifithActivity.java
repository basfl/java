package com.example.bmi1;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.text.DecimalFormat;
import java.util.Calendar;

import com.example.model.DatabaseHelper;
import com.example.model.Record;

import android.R.color;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FifithActivity extends ActionBarActivity {
	double acceptedWeight;
	DatabaseHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fifith);
		final Record recorder = (Record) getIntent().getSerializableExtra("record");
		Log.d(" fifith Record ####", recorder.getWeight() + "bmi " + recorder.getBmi() + "femal" + recorder.isFemaleFlag()
				+ "male " + recorder.isMaleFlag());
		/*
		 * 
		 */
		db = new DatabaseHelper(this);	
		final String ymd;
		Calendar cal1 = Calendar.getInstance();
		int currentDaycmp = cal1.get(Calendar.DAY_OF_MONTH);
		int currentMonthcmp = cal1.get(Calendar.MONTH);
		int currentYearcmp = cal1.get(Calendar.YEAR);
		//Log.d("calendar", "" + currentYearcmp + "/" + currentMonthcmp + "/" + currentDaycmp);
		currentMonthcmp++;
		ymd=currentYearcmp+"-"+currentMonthcmp+"-"+currentDaycmp;
		Log.d("calendar", "" + ymd);
		/*
		 * 
		 */
		TextView tv = (TextView) findViewById(R.id.result);
		TextView under = (TextView) findViewById(R.id.under);
		TextView healthy = (TextView) findViewById(R.id.healthy);
		TextView over = (TextView) findViewById(R.id.over);
		TextView obese = (TextView) findViewById(R.id.Obese);
		Button insert=(Button)findViewById(R.id.insert);
		String underDisplay = "Underweight:BMI  less than 18.5";
		String healthyDisplay = "Healthy weight:  BMI  18.5 to 24.9";
		String overDisplay = "Overweight: BMI  25 to 29.9";
		String ObeseDisplay = "Obese: Your BMI  30 or highe";
		under.setText(underDisplay);
		healthy.setText(healthyDisplay);
		over.setText(overDisplay);
		obese.setText(ObeseDisplay);
		if (recorder.getBmi() < 18.5) {
			under.setTextColor(Color.GREEN);
		}
		if (recorder.getBmi() > 18.5 && recorder.getBmi() <= 24.9) {
			healthy.setTextColor(Color.GREEN);
		}
		if (recorder.getBmi() >= 25 && recorder.getBmi() < 29.99) {
			over.setTextColor(Color.RED);
		}
		if (recorder.getBmi() >= 30) {
			obese.setTextColor(Color.RED);
		}

		String display = "YOR WEIGHT IS " + recorder.getWeight() + "\n YOUR BMI IS " + recorder.getBmi();
		tv.setText("" + display);
		tv.setTextColor(Color.GREEN);
		if (recorder.isKgFlag() == true) {
			Double temp = recorder.getWeight() * 2.20462262185;
			DecimalFormat twoDForm = new DecimalFormat("#.##");
			acceptedWeight = Double.valueOf(twoDForm.format(temp));
			Log.d("##### convert is", "" + acceptedWeight);

		}else{
			acceptedWeight=recorder.getWeight();
		}
		insert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			int dn = db.getDate(ymd);
			Log.d("here1","here1 date is "+dn);
			if(dn==0){
				int maxId=db.getMax();
				Log.d("here2","here1 maxid is "+maxId);
				db.insert(++maxId, acceptedWeight, ymd);
				
			}else{
				Toast.makeText(getApplicationContext(), "record for today already exist", Toast.LENGTH_LONG).show();
				
			}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fifith, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
