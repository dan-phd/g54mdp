package com.example.martindata;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{

	DBHelper dbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbHelper = new DBHelper(this, "martinDB", null, 1);
		dbHelper.getWritableDatabase();
		
		queryDB();
		
		getPreference();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public static String CONFIG_STORAGE_NAME = "my preferences";
	public static String CONFIG_PREFERENCE_1 = "preference 1";
	
	public void getPreference()
	{
        SharedPreferences settings = getSharedPreferences(CONFIG_STORAGE_NAME, 0);
        
        String pref = settings.getString(CONFIG_PREFERENCE_1, "not set");

        final EditText textBox = (EditText) findViewById(R.id.editText3);
        textBox.setText(pref);
		
	}
	
	public void setPreference(View v)
	{
        SharedPreferences settings = getSharedPreferences(CONFIG_STORAGE_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();

        final EditText textBox = (EditText) findViewById(R.id.editText3);
        
        editor.putString(CONFIG_PREFERENCE_1, textBox.getText()+"");

        editor.commit();
	}
	
	public void queryDB()
	{
		StringBuilder sb = new StringBuilder();
		TextView tv = (TextView)findViewById(R.id.editText2);
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		//String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
		Cursor c = db.query("myList", new String[] { "id", "name" }, null, null, null, null, null);
		
		if(c.moveToFirst())
		{
			do
			{
				int id = c.getInt(0);
				String name = c.getString(1);
				
				sb.append(""+id+ ": " + name);
				sb.append("\n");

				Log.d("g54mdp", id + " " + name);
			}
			while(c.moveToNext());
		}
		
		tv.setText(sb);
	}
	
	public void add(View v)
	{
		final EditText inputField = (EditText) findViewById(R.id.editText1);
		String input = inputField.getText().toString();

		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		db.execSQL("INSERT INTO myList (name) " +
				   "VALUES " +
				   "('" + input + "');");
		
		queryDB();
	}
	
}
