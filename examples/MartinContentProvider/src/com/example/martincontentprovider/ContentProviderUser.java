package com.example.martincontentprovider;

import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ContentProviderUser extends ListActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		String columns[] = new String[]
		{
			ContactsContract.Contacts._ID,
			ContactsContract.Contacts.DISPLAY_NAME,
			ContactsContract.Contacts.STARRED
		};
		
		String colsToDisplay [] = new String[]
		{
			ContactsContract.Contacts.DISPLAY_NAME
		};
		
		int[] colResIds = new int[]
		{
			R.id.name
		};

		ContentResolver cr = getContentResolver();
		
		Cursor c = cr.query(ContactsContract.Contacts.CONTENT_URI, columns, ContactsContract.Contacts.STARRED + "=0", null, null);
		
		setListAdapter(new SimpleCursorAdapter(this, R.layout.activity_content_provider_user, c,colsToDisplay, colResIds));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.content_provider_user, menu);
		return true;
	}

}
