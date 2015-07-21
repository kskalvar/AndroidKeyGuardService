package com.mycompany.androidkeyguard;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i("MainActivity", "onResume");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i("MainActivity", "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("MainActivity", "onDestroy");
	}

}
