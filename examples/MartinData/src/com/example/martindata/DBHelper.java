package com.example.martindata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper
{

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		Log.d("g54mdp", "DBHelper");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("g54mdp", "onCreate");
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE myList (" +
				"id INTEGER PRIMARY KEY AUTOINCREMENT ," +
				"name VARCHAR(128) NOT NULL" +
				");");
		
		db.execSQL("INSERT INTO myList (name) " +
				   "VALUES " +
				   "('martin');");
		
		db.execSQL("INSERT INTO myList (name) " +
				   "VALUES " +
				   "('cat');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
	
}