package com.example.martincalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("g54mdp", "MainActivity onCreate");
		setContentView(R.layout.activity_main);
	}
	
    public void addNumbers(View v)
    {
        final EditText numberOne = (EditText) findViewById(R.id.editText1);
        int one = Integer.parseInt(numberOne.getText().toString());

        final EditText numberTwo = (EditText) findViewById(R.id.editText2);
        int two = Integer.parseInt(numberTwo.getText().toString());

        final EditText numberThree = (EditText) findViewById(R.id.editText3);
        numberThree.setText("" + (one + two));
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
