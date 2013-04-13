package com.TeamKeyLimePie.KeyLifePlanner;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class KeyLifePlanner_Main extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_key_life_planner__main);
		Button viewCalendar = (Button)findViewById(R.id.calendarActivity);
		Button viewAvatar = (Button)findViewById(R.id.viewAvatar);
		
		viewCalendar.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.key_life_planner__main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent i;
    	
    	switch (v.getId()){
    	case R.id.calendarActivity:
    		i = new Intent (this, CalendarActivity.class);
    		
    		startActivity(i);
    		break;
    		/*
    	case R.id.viewAvatar:
    		i = new Intent(this, OptionsActivity.class);
    		startActivity(i);
    		break;
    		*/
    	
    	}
		
	}

}
