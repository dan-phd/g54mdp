package com.example.martinservice2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBoundService extends Service
{
	//private final IBinder binder = new MyBinder();
	
	private AudioPlayer audioPlayer = new AudioPlayer();

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onBind");
		return null;
	}
	
	/*
	
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
	
	*/

	/*
	public void startPlaying()
	{
		audioPlayer.playing = true;
	}
	
	public void stopPlaying()
	{
		audioPlayer.playing = false;
	}
	
	*/

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onStartCommand");
		audioPlayer.playing = true;
		return Service.START_STICKY;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "service onCreate2");
		super.onCreate();
		
		NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.ic_launcher, "Notification message!", System.currentTimeMillis());
        
		PendingIntent i= PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
       
		notification.setLatestEventInfo(this, "Notification!", "This is the notification message", i);
        
		notificationManager.notify(9999, notification);
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onDestroy");
		audioPlayer.running = false;
		audioPlayer = null;
		super.onDestroy();
	}
	
	/*

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onRebind");
		super.onRebind(intent);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onUnbind");
		return super.onUnbind(intent);
	}
	
	*/
	
	
}