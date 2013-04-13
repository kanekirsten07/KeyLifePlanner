package com.TeamKeyLimePie.KeyLifePlanner;



import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CalendarActivity extends Activity {

	private CalendarView _calendarview;
	private ArrayList<Task> Sunday;
	private ArrayList<Task> Monday;
	private ArrayList<Task> Tuesday;
	private ArrayList<Task> Wednesday;
	private ArrayList<Task> Thursday;
	private ArrayList<Task> Friday;
	private ArrayList<Task> Saturday;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		_calendarview = (CalendarView)findViewById(R.id.calendarView); 
        _calendarview.setController(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
		return true;
	}

}
