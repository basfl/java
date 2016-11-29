package com.shareimage;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	EditText tv1;
	EditText tv2;
	Button insert;
	String user;
	String pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1=(EditText)findViewById(R.id.editText1);
		tv2=(EditText)findViewById(R.id.editText2);
		insert=(Button)findViewById(R.id.button1);
		user=tv1.getText().toString();
		pass=tv2.getText().toString();
		Log.d("user", user);
		Log.d("pass", pass);
		
		insert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		//		if(user.equals("root")&&pass.equals("root")){
					Intent intent = new Intent(getApplicationContext(), SelectImage.class);
					startActivity(intent);

		//		}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
