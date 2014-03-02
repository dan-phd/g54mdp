package com.example.martinservice4;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

public class MyBoundService extends Service {

    private Messenger messenger;
	private AudioPlayer audioPlayer = new AudioPlayer();
    
    public static final int START_PLAYING = 0;
    public static final int STOP_PLAYING = 1;
    public static final int SEND_STUFF = 2;
	
    private class MyHandler extends Handler {
    	@Override
        public void handleMessage(Message msg) {
            switch (msg.what)
            {
            	case START_PLAYING:
            		startPlaying();
            		break;
            	case STOP_PLAYING:
            		stopPlaying();
            		break;
            	case SEND_STUFF:
            		MyParcelable p = msg.getData().getParcelable("myParcel");
            		Log.d("g54mdp", p.x + " " + p.y + " " + p.name);
            		break;
            	default:
            		super.handleMessage(msg);
            }
        }
    }

    @Override
	public void onCreate()
    {
    	messenger = new Messenger(new MyHandler());
    }
 
    @Override
    public IBinder onBind(Intent intent)
    {
        return messenger.getBinder();
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
		throw new RuntimeException("You should not start this service");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onDestroy4");
		audioPlayer.running = false;
		audioPlayer = null;
		super.onDestroy();
	}

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onRebind4");
		super.onRebind(intent);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d("g54mdp", "onUnbind4");
		return super.onUnbind(intent);
	}
	   
    
}
