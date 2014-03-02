package com.example.martinnotepad;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
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
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		Log.d("g54mdp", "MainActivity onRestoreInstanceState");
		
		if(savedInstanceState!=null)
		{
	        final EditText textBox = (EditText) findViewById(R.id.editText1);
			String text = savedInstanceState.getString("mytext");
			textBox.setText(text);
		}
		
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);

		Log.d("g54mdp", "MainActivity onSaveInstanceState");
		
        final EditText textBox = (EditText) findViewById(R.id.editText1);
        String text = textBox.getText().toString();
		outState.putString("mytext", text);
		
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
