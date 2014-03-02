package com.example.martinservice4;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.bindService(new Intent(this, MyBoundService.class), serviceConnection, Context.BIND_AUTO_CREATE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private Messenger messenger;
	
	public void startPlaying(View v)
	{
		Message message = Message.obtain(null, MyBoundService.START_PLAYING, 0, 0);
		
		try
		{
			messenger.send(message);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
	}
	
	public void stopPlaying(View v)
	{
		Message message = Message.obtain(null, MyBoundService.STOP_PLAYING, 0, 0);
		
		try
		{
			messenger.send(message);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
	}
	
	public void sendStuff(View v)
	{
		Message message = Message.obtain(null, MyBoundService.SEND_STUFF, 0, 0);
		
		MyParcelable p = new MyParcelable();
		p.x = 5;
		p.y = 10;
		p.name = "martin";
		
		Bundle b = new Bundle();
		b.putParcelable("myParcel", (Parcelable) p);
		message.setData(b);
		
		try
		{
			messenger.send(message);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		
	}
	   
	private ServiceConnection serviceConnection = new ServiceConnection()
	{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.d("g54mdp", "onServiceConnected");
			messenger = new Messenger(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.d("g54mdp", "onServiceDisconnected");
			messenger = null;
		}
	};
}
