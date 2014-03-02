package com.example.martinservice4;

import android.util.Log;

public class AudioPlayer extends Thread implements Runnable
{
	public boolean playing = false;
	public boolean running = true;
	
	public AudioPlayer()
	{
		this.start();
	}
	
	public void run()
	{
		while(this.running)
		{
			try
			{
				Thread.sleep(2000);
				if(this.playing)
					Log.d("g54mdp", "audio playing4");
				else
					Log.d("g54mdp", "audio stopped4");
			}
			catch(Exception e)
			{
				return;
			}
		}
	}
}
