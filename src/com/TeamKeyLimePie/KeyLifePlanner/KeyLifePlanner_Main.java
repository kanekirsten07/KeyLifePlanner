package com.TeamKeyLimePie.KeyLifePlanner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class KeyLifePlanner_Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_key_life_planner__main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.key_life_planner__main, menu);
		return true;
	}

}
