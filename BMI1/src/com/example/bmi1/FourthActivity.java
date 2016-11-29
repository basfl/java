package com.example.bmi1;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.model.DatabaseHelper;
import com.example.model.TableRecords;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FourthActivity extends ActionBarActivity {
	DatabaseHelper db;
	Button fiveRecords;
	Button fourteens;
	Button thirty;
	TableRecords tabbleReords;
	Cursor res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fourth);
		fiveRecords = (Button) findViewById(R.id.five);
		fourteens = (Button) findViewById(R.id.fourteen);
		thirty = (Button) findViewById(R.id.thirty);
		tabbleReords = new TableRecords();
		
		db = new DatabaseHelper(this);
		// db.insert(4, 250.65, "09-17-2016");

		fiveRecords.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// int maxId=db.getMax();
				// int cnt=0;
				// List<String> local=new ArrayList<String>();
				// // Cursor res = null;
				// while(cnt<5){
				// res = db.getSingleRecord(maxId);
				// res.moveToFirst();
				// // double r2 = res.getDouble(1);
				// local.add(""+ res.getDouble(1));
				// // Log.d("record","record #"+" wieght is "+
				// res.getDouble(1));
				// cnt++;
				// maxId--;
				// res.close();
				// }
				//
				// tabbleReords.setWr(local);
				// Integer number=5;
				// Intent intClass = new Intent(getApplicationContext(),
				// TableDisplay.class);
				// intClass.putExtra("number", number);
				// startActivity(intClass);
				tabbleReords.setN(5);

				Intent intClass = new Intent(getApplicationContext(), TableDisplay.class);
				intClass.putExtra("tableRecord", tabbleReords);
				startActivity(intClass);

			}
		});
		fourteens.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tabbleReords.setN(14);

				Intent intClass = new Intent(getApplicationContext(), TableDisplay.class);
				intClass.putExtra("tableRecord", tabbleReords);
				startActivity(intClass);

			}
		});
		thirty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tabbleReords.setN(30);

				Intent intClass = new Intent(getApplicationContext(), TableDisplay.class);
				intClass.putExtra("tableRecord", tabbleReords);
				startActivity(intClass);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fourth, menu);
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

	public void onDestroy() {
		res.close();
		db.close();

	}
}
