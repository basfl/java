package com.example.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, "mydb", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS Record(Id INT,Weight DOUBLE,Date VARCHAR(255));");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public int getTotal() {
		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT *  FROM Record";
		Cursor resultSet = db.rawQuery(sql, null);
		int n = resultSet.getCount();
		return n;

	}

	public int getMax() {
		int id = 0;
		SQLiteDatabase db = this.getReadableDatabase();
		String MY_QUERY = "SELECT MAX(Id)  FROM Record";
		Cursor mCursor = db.rawQuery(MY_QUERY, null);
		try {
			if (mCursor.getCount() > 0) {
				mCursor.moveToFirst();
				// id = mCursor.getInt(mCursor.getColumnIndex(MY_QUERY));
				id = mCursor.getInt(0);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			db.close();
		}

		return (id);
	}

	public int getDate(String s) {
		SQLiteDatabase db = this.getReadableDatabase();
		String q="select * from Record where Date='" + s+"'";
		Log.d("date is ", s +" q is "+q);
		Cursor res = db.rawQuery("select * from Record where Date='" + s+"'" , null);
		// res.getCount();

		return res.getCount();
	}

	public void insert(int Id, double Weight, String Date) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("Id", Id);

		contentValues.put("Weight", Weight);
		contentValues.put("Date", Date);
		long f = db.insert("Record", null, contentValues);
		Log.d("******", "enter " + f +"date is "+Date);
	}
	 public Cursor getSingleRecord(int id){
	      SQLiteDatabase db = this.getReadableDatabase();
	      String sql="select * from Record where Id="+id+"";
	      Cursor res =  db.rawQuery( sql, null );
	      return res;
	   }

}
