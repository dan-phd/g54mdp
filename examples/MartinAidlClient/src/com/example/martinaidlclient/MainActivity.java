package com.example.martinaidlclient;

import com.example.martinaidlservice.KeyGenerator;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	public void onClickButton(View v)
	{
        final EditText textBox = (EditText) findViewById(R.id.editText1);

		try
		{
			textBox.setText(service.getKey());
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
	}
	

	private KeyGenerator service;
	private boolean bound;

	private ServiceConnection connection = new ServiceConnection()
	{
		public void onServiceConnected(ComponentName className, IBinder iservice)
		{
			service = KeyGenerator.Stub.asInterface(iservice);
			bound = true;
		}

		public void onServiceDisconnected(ComponentName className)
		{
			service = null; bound = false;
		}
	};
	

	@Override
	protected void onStart()
	{
		super.onStart();
		Intent intent = new Intent(KeyGenerator.class.getName());
		intent.setFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
		bindService(intent,	this.connection, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onStop()
	{
		if (bound)
			unbindService(this.connection);
		super.onStop();
	}

}
