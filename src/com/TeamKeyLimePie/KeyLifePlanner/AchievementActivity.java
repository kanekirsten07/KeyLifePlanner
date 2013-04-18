package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;

import com.TeamKeyLimePie.KeyLifePlanner.CalendarActivity.UserItemAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AchievementActivity extends Activity {

	public ListView achieve_view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_achievement);
		
		TextView title = (TextView)findViewById(R.id.achievementheading);	
		Typeface tf1 = Typeface.createFromAsset(getAssets(),
		        "fonts/governor.ttf");
		title.setTypeface(tf1);
		
		
		ArrayList<Achievement> ach = new ArrayList<Achievement>();
		
		Achievement a1 = new Achievement("use this app", false);
		Achievement a2 = new Achievement("Complete two hygiene tasks in one day", false);
		
		ach.add(a1);
		ach.add(a2);
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

}
