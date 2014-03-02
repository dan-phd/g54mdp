package com.example.martinservice;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	int jobNumber = 1;
	
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
		Intent msgIntent = new Intent(this, MyIntentService.class);
		msgIntent.putExtra("jobNumber", jobNumber);
		startService(msgIntent);
		jobNumber++;
		(Toast.makeText(this, "hello", Toast.LENGTH_SHORT)).show();
    }
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("g54mdp", "MainActivity onDestroy");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("g54mdp", "MainActivity onPause");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("g54mdp", "MainActivity onResume");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("g54mdp", "MainActivity onStart");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("g54mdp", "MainActivity onStop");
	}


}
