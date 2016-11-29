package com.example.bmi1;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.example.model.Record;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SecondActivity extends ActionBarActivity {

	EditText inchText;
	EditText weightText;
	EditText feetText;
	RadioButton male;
	RadioButton female;
	Button bmi;
	boolean maleFlag;
	boolean femaleFlag;
	double wieght;
	double totalHeightInInch;
	Record record;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		// Button bmi = (Button) findViewById(R.id.button4);
		feetText = (EditText) findViewById(R.id.feetText);
		inchText = (EditText) findViewById(R.id.inchText);
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
					// height in feet
					String ht = feetText.getText().toString();
					// height in inch
					String inct = inchText.getText().toString();
					// weight in lbs
					String wt = weightText.getText().toString();
					Float f = Float.parseFloat(inct);
					// f1=inch
					double f1;
					// dw=double weight
					double dw;
					if (inct.length() == 1) {
						f1 = f / 10;
					} else {
						f1 = f / 100;
					}

					int h = Integer.parseInt(ht);
					DecimalFormat twoDForm = new DecimalFormat("#.##");
					totalHeightInInch = Double.valueOf(twoDForm.format(feetToInch(h, f1)));

					DecimalFormat twoDFormForWeight = new DecimalFormat("#.##");
					double wtemp = new BigDecimal(wt).doubleValue();
					dw = Double.valueOf(twoDFormForWeight.format(wtemp));
					double bmiRes = calculateBmi(totalHeightInInch, dw);
					record.setMaleFlag(maleFlag);
					record.setFemaleFlag(femaleFlag);
					record.setBmi(bmiRes);
					record.setWeight(dw);
					record.setKgFlag(false);
					Intent intClass = new Intent(getApplicationContext(), FifithActivity.class);
					intClass.putExtra("record", record);
					startActivity(intClass);
					
				}catch(Exception e){
					Toast msg = Toast.makeText(getApplicationContext(),
							"wrong input !!! " , Toast.LENGTH_LONG);
					msg.show();
					
				}
				

				/////////////////////

				// bmiCalculator(totalHeightInInch,)

			}

			private double calculateBmi(double totalHeightInInch, double dw) {
				double height = Math.pow(totalHeightInInch, 2);
				double div = dw / height;
				double res = div * 703;
				DecimalFormat twoDForm = new DecimalFormat("#.##");
				Double bmiRes = Double.valueOf(twoDForm.format(res));
				//////////////////////////////////////

				Log.d("********", "hight power of twi is " + height + " div is " + div + " res is " + res);
				/////////////////////////////////////
				return bmiRes;

			}

			private double feetToInch(double h, double f1) {
				double t = h * 12;
				double t1 = f1 * 12;
				DecimalFormat twoDForm = new DecimalFormat("#.##");
				double result = t + Double.valueOf(twoDForm.format(t1));
				return result;
			}
		});
		// Imperial.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// if (Imperial.isChecked()) {
		// Toast msg = Toast.makeText(getApplicationContext(), "checked ",
		// Toast.LENGTH_LONG);
		// msg.show();
		// gender.setText("FUCK");
		// // feet.setText("Meter");
		// }
		//
		// }
		// });
		// Toast msg = Toast.makeText(getApplicationContext(),
		// ""+Imperial.isChecked(), Toast.LENGTH_LONG);
		// msg.show();
		// if(Imperial.isChecked()){
		// Toast msg = Toast.makeText(getApplicationContext(), "checked ",
		// Toast.LENGTH_LONG);
		// msg.show();
		// }

		// bmi.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		//
		// String initialHieght=height.getText().toString();
		//
		// String some=""+initialHieght;
		// char[] charArray = some.toCharArray();
		// for(char c:charArray){
		// if(c=='.'){
		//
		// }
		// else{
		// Toast msg = Toast.makeText(getApplicationContext(), "character " +c,
		// Toast.LENGTH_LONG);
		// msg.show();
		// }
		//
		//
		// }
		// //////////////////////////////////////
		//
		// String[] n1 = some.split("&");
		// Imperial.isChecked();
		//
		// Toast msg = Toast.makeText(getApplicationContext(), "welcome to
		// second " +some+"length "+n1.length+"select "+Imperial.isChecked(),
		// Toast.LENGTH_LONG);
		// msg.show();
		// }
		// });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
