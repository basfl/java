package com.example.bmi1;

import java.io.File;
import java.util.Calendar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	SQLiteDatabase mydatabase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button weight = (Button) findViewById(R.id.wieght);
		Button calculateBMI = (Button) findViewById(R.id.initial);
		Button monitor = (Button) findViewById(R.id.monitor);
		Calendar cal1 = Calendar.getInstance();
		Log.d("original calender", cal1.toString());
		int currentDaycmp = cal1.get(Calendar.DAY_OF_MONTH);
		int currentMonthcmp = cal1.get(Calendar.MONTH);
		int currentYearcmp = cal1.get(Calendar.YEAR);
		Log.d("calendar", "" + currentYearcmp + "/" + currentMonthcmp + "/" + currentDaycmp);
		
		// try {
		// File dbtest = new File("/data/data/com.example.bmi1/databases/mydb");
		// if (dbtest.exists()) {
		// Toast msg1 = Toast.makeText(getApplicationContext(), "File exist",
		// Toast.LENGTH_LONG);
		// msg1.show();
		// // this.deleteDatabase("mydb");
		//
		// } else {
		// Toast msg2 = Toast.makeText(getApplicationContext(), "File does not
		// exist", Toast.LENGTH_LONG);
		// msg2.show();
		//
		// mydatabase = openOrCreateDatabase("mydb", MODE_PRIVATE, null);
		// mydatabase.execSQL(
		// "CREATE TABLE IF NOT EXISTS Record(Id INT,Wight DOUBLE,Date
		// VARCHAR(255));");
		// // mydatabase.execSQL(
		// // "DROP TABLE Record");
		// }

		// } catch (Exception ioException) {
		//
		// }
		calculateBMI.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intClass = new Intent(getApplicationContext(), SecondActivity.class);

				startActivity(intClass);

			}
		});
		weight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intClass = new Intent(getApplicationContext(), ThirdActivity.class);

				startActivity(intClass);

			}
		});
		monitor.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intClass = new Intent(getApplicationContext(), FourthActivity.class);

				startActivity(intClass);
				// try{
				// mydatabase = openOrCreateDatabase("mydb", MODE_PRIVATE,
				// null);

				// //////////////////////////////////////////
				// mydatabase = openOrCreateDatabase("mydb", MODE_PRIVATE,
				// null);
				// String sql1="INSERT INTO Record (Id,Wight,Date) VALUES
				// (0,0,"+'0'+")";
				// mydatabase.execSQL(sql1);
				// //////////////////////////////////////////
				// String sql="SELECT * FROM Record";
				// Cursor resultSet =mydatabase.rawQuery(sql, null);
				// resultSet.moveToFirst();
				// int n=resultSet.getCount();
				// int r1 = resultSet.getInt(0);
				// double r2 = resultSet.getDouble(1);
				// String r3 = resultSet.getString(2);
				// String com=r1+" "+r2+" "+r3;
				// Toast msg2 = Toast.makeText(getApplicationContext(),
				// "******** "+n+" "+com, Toast.LENGTH_LONG);
				// msg2.show();
				//
				//////////////////////////////////////////////////////////
				/*
				 * 
				 */
				// String sql="SELECT MAX(Id) FROM Record";
				// Cursor resultSet =mydatabase.rawQuery(sql, null);
				// resultSet.moveToFirst();
				// int n=resultSet.getCount();
				// Toast msg2 = Toast.makeText(getApplicationContext(),
				// "******** "+n, Toast.LENGTH_LONG);
				// msg2.show();
				/*
				 * 
				 */

				//
				// String sql="INSERT INTO Record (Id,Weight,Date) VALUES
				// (0,0,"+'0'+")";
				// mydatabase.execSQL(sql);

				// Toast msg2 = Toast.makeText(getApplicationContext(),
				// "******** done"+mydatabase.isOpen(), Toast.LENGTH_LONG);
				// msg2.show();
				// }catch(NullPointerException e){
				// mydatabase = openOrCreateDatabase("mydb", MODE_PRIVATE,
				// null);
				// String sql="INSERT INTO Record (Id,Weight,Date) VALUES
				// (0,0,"+'0'+")";
				// mydatabase.execSQL(sql);
				// Toast msg2 = Toast.makeText(getApplicationContext(),
				// "******** done", Toast.LENGTH_LONG);
				// msg2.show();
				//
				// }

			}
		});

	}

}
