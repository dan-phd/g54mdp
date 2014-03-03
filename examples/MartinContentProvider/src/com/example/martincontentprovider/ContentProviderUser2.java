package com.example.martincontentprovider;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ContentProviderUser2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content_provider_user2);
		queryContentProvider();
	}
	
	
	String columns[] = new String[]
	{
		MyProviderContract._ID,
		MyProviderContract.NAME
	};

	
	public void queryContentProvider()
	{
		StringBuilder sb = new StringBuilder();
		TextView tv = (TextView)findViewById(R.id.editText3);

		String[] projection = new String[] { MyProviderContract._ID, MyProviderContract.NAME };

		Uri contacts =  MyProviderContract.PEOPLE_URI;

		ContentResolver cr = getContentResolver();

		Cursor c = cr.query(MyProviderContract.PEOPLE_URI, columns, null, null, null);
		
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
	
	
	public void add2(View v)
	{
		final EditText inputField = (EditText) findViewById(R.id.editText4);
		String input = inputField.getText().toString();
		
		Uri uri;
		ContentValues newValues = new ContentValues();
		newValues.put(MyProviderContract.NAME, input);

		uri = getContentResolver().insert(MyProviderContract.PEOPLE_URI, newValues);
	
		queryContentProvider();
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.content_provider_user2, menu);
		return true;
	}

}
