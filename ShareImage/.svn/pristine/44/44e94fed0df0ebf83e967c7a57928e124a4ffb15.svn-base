package com.shareimage;

import android.support.v7.app.ActionBarActivity;

import java.io.IOException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SelectImage extends ActionBarActivity {
	Button select;
	private int PICK_IMAGE_REQUEST = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_image);
		select=(Button)findViewById(R.id.button1);
		select.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent intent = new Intent();
				// Show only images, no videos or anything else
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				// Always show the chooser (if there are multiple options available)
				startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	 
	    if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
	 
	        Uri uri = data.getData();
	 
	        try {
	        	Toast.makeText(getApplicationContext(), uri.getPath(), Toast.LENGTH_LONG).show();
	            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
	            // Log.d(TAG, String.valueOf(bitmap));
	 
	            ImageView imageView = (ImageView) findViewById(R.id.imageView);
	            imageView.setImageBitmap(bitmap);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_image, menu);
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
