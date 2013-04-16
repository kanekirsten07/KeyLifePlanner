package com.TeamKeyLimePie.KeyLifePlanner;



import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class CalendarActivity extends Activity implements OnClickListener{

	private CalendarView _calendarview;
	private ArrayList<Task> Sunday;
	private ArrayList<Task> Monday;
	private ArrayList<Task> Tuesday;
	private ArrayList<Task> Wednesday;
	private ArrayList<Task> Thursday;
	private ArrayList<Task> Friday;
	private ArrayList<Task> Saturday;
	EditText taskedit;
	MediaPlayer backgroundCalendar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar_view);
		
		backgroundCalendar = MediaPlayer.create(CalendarActivity.this, R.raw.neogardens);
		backgroundCalendar.setLooping(true);
		backgroundCalendar.start();
		
		Button addTask = (Button)findViewById(R.id.addtask);
		
		addTask.setOnClickListener(this);
       /*taskedit = (EditText)findViewById(R.id.taskname);
       
       taskedit.setOnEditorActionListener(new OnEditorActionListener() {
    	   

		@Override
		public boolean onEditorAction(TextView v, int actionId, KeyEvent arg2) {
			if(actionId == EditorInfo.IME_ACTION_DONE){
				String strvalue = taskedit.getText().toString();
	    		   Log.d("EditText value:", strvalue);
	    		   Log.d("Done", "pressed");
	    		   return true;
			}else
			{
				return false;
			}
		}
       });
       */
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		backgroundCalendar.stop();
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		backgroundCalendar.start();
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
Intent i;
    	
    	switch (v.getId()){
    	case R.id.addtask:
    		Log.d("click", "Add Task was clicked");
    		//i = new Intent (this, CalendarActivity.class);
    		
    		//startActivity(i);
    		break;
		
    	}
	}

	

}
