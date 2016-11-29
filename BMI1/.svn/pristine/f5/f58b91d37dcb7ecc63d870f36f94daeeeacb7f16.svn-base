package com.example.bmi1;

import java.util.ArrayList;
import java.util.List;

import com.example.model.DatabaseHelper;
import com.example.model.TableRecords;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class TableDisplay extends ActionBarActivity {


	TableLayout tl;
	TableRow tr;
	TextView companyTV, valueTV;
	DatabaseHelper db;
	List<String> tw=new ArrayList<String>();
	int itNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_display);
		db = new DatabaseHelper(this);
		tl = (TableLayout) findViewById(R.id.maintable);
	//	Log.d("number is table is",""+tableRecords.getN());
		try{
			final TableRecords tableRecords = (TableRecords) getIntent().getSerializableExtra("tableRecord");
			Log.d("number is table is",""+tableRecords.getN());
			itNum=tableRecords.getN();
		}catch(Exception e){
		Log.d("number is table is","failed");
			
		}
		reterive(itNum);
		

		addHeaders();
		addData();
	}

	private void reterive(Integer itNumber2) {
		int maxId=db.getMax();
		int cnt=0;
		List<String> local=new ArrayList<String>();
		Cursor res = null;
		Log.d("condition is ", "maxid is "+maxId+" itNumber is "+itNum+ "condition is " );
		if(maxId>=itNumber2){
		while(cnt<itNumber2){
			  res = db.getSingleRecord(maxId);
			res.moveToFirst();
		//	double r2 = res.getDouble(1);
			local.add(""+ res.getDouble(1));
			Log.d("record","record ###@"+" wieght is "+ res.getDouble(1));
			tw.add(""+res.getDouble(1));
			cnt++;
			maxId--;
			res.close();
			
		}
		db.close();
		}
		else{
			 Toast.makeText(getApplicationContext(), " We do not have enough record", Toast.LENGTH_LONG).show();;
			
		}
		
		
	}

	@SuppressWarnings("deprecation")
	public void addData() {

	//	 for (int i = 0; i < companies.length; i++){
		int cnt=1;
		for (String r : tw) {
			/** Create a TableRow dynamically **/
			tr = new TableRow(this);
			tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

			/** Creating a TextView to add to the row **/
			companyTV = new TextView(this);
		//	companyTV.setText(companies[i]);
			companyTV.setText(""+cnt);
			cnt++;
			companyTV.setTextColor(Color.RED);
			companyTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			companyTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			companyTV.setPadding(5, 5, 5, 5);
			tr.addView(companyTV); // Adding textView to tablerow.

			/** Creating another textview **/
			valueTV = new TextView(this);
		//	valueTV.setText(os[i]);
			valueTV.setText(r);
			valueTV.setTextColor(Color.GREEN);
			valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			valueTV.setPadding(5, 5, 5, 5);
			valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			tr.addView(valueTV); // Adding textView to tablerow.

			// Add the TableRow to the TableLayout
			tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		}
	}

	@SuppressWarnings("deprecation")
	public void addHeaders() {

		/** Create a TableRow dynamically **/
		tr = new TableRow(this);
		tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

		/** Creating a TextView to add to the row **/
		TextView companyTV = new TextView(this);
		companyTV.setText("Record#");
		companyTV.setTextColor(Color.GRAY);
		companyTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		companyTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		companyTV.setPadding(5, 5, 5, 0);
		tr.addView(companyTV); // Adding textView to tablerow.

		/** Creating another textview **/
		TextView valueTV = new TextView(this);
		valueTV.setText("Weight");
		valueTV.setTextColor(Color.GRAY);
		valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		valueTV.setPadding(5, 5, 5, 0);
		valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(valueTV); // Adding textView to tablerow.

		// Add the TableRow to the TableLayout
		tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

		// we are adding two textviews for the divider because we have two
		// columns
		tr = new TableRow(this);
		tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

		/** Creating another textview **/
		TextView divider = new TextView(this);
		divider.setText("-----------------");
		divider.setTextColor(Color.GREEN);
		divider.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		divider.setPadding(5, 0, 0, 0);
		divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(divider); // Adding textView to tablerow.

		TextView divider2 = new TextView(this);
		divider2.setText("-------------------------");
		divider2.setTextColor(Color.GREEN);
		divider2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		divider2.setPadding(5, 0, 0, 0);
		divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(divider2); // Adding textView to tablerow.

		// Add the TableRow to the TableLayout
		tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.table_display, menu);
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
