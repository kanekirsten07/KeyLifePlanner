package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;

import com.TeamKeyLimePie.KeyLifePlanner.CalendarActivity.UserItemAdapter;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AchievementActivity extends Activity {

	MediaPlayer backgroundAchievement;
	
	public ListView achieve_view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_achievement);
		
		backgroundAchievement = MediaPlayer.create(AchievementActivity.this, R.raw.sailingintoabyss);
		backgroundAchievement.setLooping(true);
		backgroundAchievement.start();
		
		ArrayList<Achievement> ach = new ArrayList<Achievement>();
		
		Achievement a1 = new Achievement("First Day!" + "\n"+ " Welcome to Key Life Planner!", false);
		Achievement a2 = new Achievement("Clean!" + "\n"+" You Have Completed a Hygiene Tasks", false);
		Achievement a3 = new Achievement("Hard Working!" + "\n"+" You have completed a Work task", false);
		Achievement a4 = new Achievement("Good Student!" + "\n"+" You have compeleted a School task", false);
		Achievement a5 = new Achievement("Clean as a Whistle!" + "\n"+" You Have Completed all Hygiene Tasks For One Day", false);
		Achievement a6 = new Achievement("Far Voyager!"+ "\n"+"You Have Completed a Travel Task", false);
		Achievement a7 = new Achievement("Well Rounded!" + "\n"+" You Have Completed a Hygiene Task, a Work Task and a School Task", false);
		Achievement a8 = new Achievement("Just Getting Started!" + "\n"+" You Have Completed All Your Tasks For One Day", false);
		Achievement a9 = new Achievement("Keep it Up!" + "\n"+" You Have Completed All Your Tasks For Two Days ", false);
		Achievement a10 = new Achievement("Doing Great!" + "\n"+" You Have Completed All Your Tasks For 30 Days", false);
		Achievement a11 = new Achievement("Epic!" + "\n"+" You Have Completed All Your Tasks for 365 Days",false);
		Achievement a12 = new Achievement("Customize!" + "\n"+" You Have Changed Your Avatar", false);
		Achievement a13 = new Achievement("Making Money!" + "\n"+" You Have Earned Your First Coin", false);
		Achievement a14 = new Achievement("Cashing In!" + "\n"+" You Have Earned 25 Coins", false);
		Achievement a15 = new Achievement("Centenial Cash!"+ "\n"+"You Have Earned 100 Coins", false);
		Achievement a16 = new Achievement("Shopper!"+ "\n"+"You Have Bought an Item From the Store", false);
		Achievement a17 = new Achievement("Task Apprentice!"+ "\n"+"You Have Completed 8 Tasks", false);
		Achievement a18 = new Achievement("Task Journeyman!"+ "\n"+"You Have Completed 64 Tasks", false);
		Achievement a19 = new Achievement("Task Master!"+ "\n"+"You Have Completed 128 Tasks", false);
		Achievement a20 = new Achievement("Task Sage!"+ "\n"+"You Have Completed 512 Tasks", false);

		

		
		ach.add(a1);
		ach.add(a2);
		ach.add(a3);
		ach.add(a4);
		ach.add(a5);
		ach.add(a6);
		ach.add(a7);
		ach.add(a8);
		ach.add(a9);
		ach.add(a10);
		ach.add(a11);
		ach.add(a12);
		ach.add(a13);
		ach.add(a14); 
		ach.add(a15);
		ach.add(a16);
		ach.add(a17);
		ach.add(a18);
		ach.add(a19);
		ach.add(a20); 
		
		
		achieve_view = (ListView)findViewById(R.id.achievementlist);
		achieve_view.setAdapter(new UserItemAdapter(this, android.R.layout.simple_list_item_1, ach));
	}

	
	public class UserItemAdapter extends ArrayAdapter<Achievement>{

		private ArrayList<Achievement> a;
		
		public UserItemAdapter(Context context, int textViewResourceId,
				ArrayList<Achievement> a) {
			super(context, textViewResourceId, a);
			
			this.a = a;
			// TODO Auto-generated constructor stub
		}
		
		@Override 
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View v = convertView;
			if(v == null){
				Log.d("view", "isnull");
				LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.achievementitem,null);
			}
			
			
			Achievement a1 = a.get(position);
			if(a1 != null){
				TextView description = (TextView)v.findViewById(R.id.achievedescription);
				
				if(description != null){
					description.setText(a1.description);
				}
				
				
			
			
		}
			
			return v;

		}

	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		backgroundAchievement.stop();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		backgroundAchievement.start();
	}

}
