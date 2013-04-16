package com.TeamKeyLimePie.KeyLifePlanner;




import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class KeyLifePlanner_Main extends Activity implements OnClickListener{

	//initializes background music
	MediaPlayer backgroundMain;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_key_life_planner__main);
		
		//starts background music
		backgroundMain = MediaPlayer.create(KeyLifePlanner_Main.this, R.raw.beginnings);
		backgroundMain.setLooping(true);
		backgroundMain.start();
		
		Button viewCalendar = (Button)findViewById(R.id.calendarActivity);
		Button viewAvatar = (Button)findViewById(R.id.viewAvatar);
		Button viewAchievements = (Button)findViewById(R.id.viewAchievements);
		
		viewCalendar.setOnClickListener(this);
		
	}
	
	
	
	@Override
	protected void onPause()
	{
		super.onPause();
		backgroundMain.stop();
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		backgroundMain.start();
	}
	
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.key_life_planner__main, menu);
		return true;
	}
*/
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent i;
    	
    	switch (v.getId()){
    	case R.id.calendarActivity:
    		i = new Intent (this, CalendarActivity.class);
    		
    		startActivity(i);
    		break;
    	case R.id.viewAvatar:
    		i = new Intent (this, AvatarActivity.class);
    		
    		startActivity(i);
    		break;
    	
    	
    	}
		
	}

}
