package com.example.martinservice3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBoundService extends Service
{
	private final IBinder binder = new MyBinder();
	
	private AudioPlayer audioPlayer = new AudioPlayer();

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onBind2"); 
		return binder;
	}
	
	public class MyBinder extends Binder
	{
		void startPlaying()
		{
			MyBoundService.this.startPlaying();
		}
		
		void stopPlaying()
		{
			MyBoundService.this.stopPlaying();
		}
		
		MyBoundService getService()
		{
			return MyBoundService.this;
		}
	}

	
	public void startPlaying()
	{
		audioPlayer.playing = true;
	}
	
	public void stopPlaying()
	{
		audioPlayer.playing = false;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onStartCommand2");
		return Service.START_STICKY;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "service onCreate2");
		super.onCreate();		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onDestroy2");
		audioPlayer.running = false;
		audioPlayer = null;
		super.onDestroy();
	}

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onRebind2");
		super.onRebind(intent);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onUnbind2");
		return super.onUnbind(intent);
	}
	
	
}