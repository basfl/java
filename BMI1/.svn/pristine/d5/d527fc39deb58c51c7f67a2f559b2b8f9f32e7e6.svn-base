package com.example.bmi1;

import android.support.v7.app.ActionBarActivity;
import android.text.InputType;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.example.model.Record;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ThirdActivity extends ActionBarActivity {
	EditText meterText;
	EditText centText;
	EditText weightText;
	RadioButton male;
	RadioButton female;
	Button bmi;
	boolean maleFlag;
	boolean femaleFlag;
	double wieght;
	double totalHeightInMeters;
	Record record;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);

		meterText = (EditText) findViewById(R.id.meterText);
		centText = (EditText) findViewById(R.id.centTxt);
		weightText = (EditText) findViewById(R.id.weightText);
		weightText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
		male = (RadioButton) findViewById(R.id.male);
		female = (RadioButton) findViewById(R.id.female);
		bmi = (Button) findViewById(R.id.bmi);
		male.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (male.isChecked()) {
					Toast msg = Toast.makeText(getApplicationContext(), "checked ", Toast.LENGTH_LONG);
					msg.show();
					maleFlag = true;
					femaleFlag = false;
				}

			}
		});
		female.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (female.isChecked()) {
					Toast msg = Toast.makeText(getApplicationContext(), "female ", Toast.LENGTH_LONG);
					msg.show();
					femaleFlag = true;
					maleFlag = false;
				}

			}
		});
		bmi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try{
					record = new Record();
					// height in meter
					String ht = meterText.getText().toString();
					// height in cent
					String ct = centText.getText().toString();
					// weight in lbs
					String wt = weightText.getText().toString();
					Float f = Float.parseFloat(ct);
					// f1=inch
					double f1;
					// dw=double weight
					double dw;
					if (ct.length() == 1) {
						f1 = f / 10;
					} else {
						f1 = f / 100;
					}
					int h = Integer.parseInt(ht);
					DecimalFormat twoDForm = new DecimalFormat("#.##");
					totalHeightInMeters = Double.valueOf(twoDForm.format(totalMeters(h, f1)));

					DecimalFormat twoDFormForWeight = new DecimalFormat("#.##");
					double wtemp = new BigDecimal(wt).doubleValue();
					dw = Double.valueOf(twoDFormForWeight.format(wtemp));
					double bmiRes = calculateBmi(totalHeightInMeters, dw);
					record.setMaleFlag(maleFlag);
					record.setFemaleFlag(femaleFlag);
					record.setBmi(bmiRes);
					record.setWeight(dw);
					record.setKgFlag(true);
					Intent intClass = new Intent(getApplicationContext(), FifithActivity.class);
					intClass.putExtra("record", record);
					startActivity(intClass);
					
				}catch(Exception e){
					Toast msg = Toast.makeText(getApplicationContext(),
							"wrong input !!! " , Toast.LENGTH_LONG);
					msg.show();
					
				}

				

			}

			private double calculateBmi(double totalHeightInMeters, double dw) {
				double height = Math.pow(totalHeightInMeters, 2);
				double div = dw / height;
				DecimalFormat twoDForm = new DecimalFormat("#.##");
				Double bmiRes = Double.valueOf(twoDForm.format(div));
				return bmiRes;
			}

			private double totalMeters(int h, double f1) {
				double t = h;
				double t1 = f1;
				DecimalFormat twoDForm = new DecimalFormat("#.##");
				double result = t + Double.valueOf(twoDForm.format(t1));
				return result;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
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
