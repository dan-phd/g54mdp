package com.example.martinthreads;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText textField;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        textField = (EditText) findViewById(R.id.editText1);
	}
	
	
	public String doWork(long time)
	{
		try{Thread.sleep(time);}catch(Exception e){;}
		return "" + Math.random();
	}
	
	
	public void onClickDoSomething(View v)
	{
		textField.setText(doWork(0));
	}
	
	public void onClickTakeTimeBadly(View v)
	{
		textField.setText(doWork(10000));
	}
	
	public void onClickPostRunnable(View v)
	{
	    new Thread(new Runnable()
	    {
	        public void run()
	        {
	        	final String myData = doWork(5000);
	    		
	    		runOnUiThread(new Runnable()
	    		{
	                public void run()
	                {
	            		textField.setText("worker: " + myData);
	                }
	            });
	        	
	        }
	    }).start();
		
	}

	private Handler h;
	
	public void onClickPostHandler(View v)
	{
		h = new Handler();
		
	    new Thread(new Runnable()
	    {
	        public void run()
	        {
	        	final String myData = doWork(5000);
	        	
	    		h.postDelayed(new Runnable()
	    		{
	                public void run()
	                {
	            		textField.setText("worker: " +myData);
	                }
	            }, 5000);
	        	
	        }
	    }).start();		
	}
	
	
	public void onClickPostMessage(View v)
	{
	    new Thread(new Runnable()
	    {
	        public void run()
	        {
	        	String myData = doWork(5000);
	    		
	    		Message msg = new Message();
	    		Bundle b = new Bundle();
	    		b.putString("data", ""+myData);
	    		msg.setData(b);
	    		h2.sendMessage(msg);
	        }
	    }).start();		

	}
	
	private Handler h2 = new Handler()
	{
		public void handleMessage(Message msg)
		{
			Bundle b = msg.getData();
			String data = b.getString("data");
			textField.setText("worker: " + data);
		}
	};
	
	
	
	public void onClickAsyncTask(View v)
	{
	    new MyAsyncTask().execute(new Long(5000));
	}	

	private class MyAsyncTask extends AsyncTask<Long, Void, String> {

	    protected String doInBackground(Long... time)
	    {
	    	return doWork(time[0]);
	    }

	    protected void onPostExecute(String result)
	    {
			textField.setText("worker: " + result);
	    }
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
