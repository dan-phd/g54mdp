package com.example.martinservice3;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
 
	private MyBoundService.MyBinder myService = null;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.bindService(new Intent(this, MyBoundService.class), serviceConnection, Context.BIND_AUTO_CREATE);
	}

	public void startPlaying(View v)
	{
		myService.startPlaying();
	}
	
	public void stopPlaying(View v)
	{
		myService.stopPlaying();
	}
	
	private ServiceConnection serviceConnection = new ServiceConnection()
	{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.d("g54mdp", "onServiceConnected");
			myService = (MyBoundService.MyBinder) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.d("g54mdp", "onServiceDisconnected");
			myService = null;
		}
	};
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("g54mdp", "MainActivity onDestroy2");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("g54mdp", "MainActivity onPause2");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("g54mdp", "MainActivity onResume2");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("g54mdp", "MainActivity onStart2");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("g54mdp", "MainActivity onStop2");
	}

}
