package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;



import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;

import android.content.Intent;

public class AddTaskActivity extends Activity {

	private ArrayList<Task> Sunday ;
	private ArrayList<Task> Monday ;
	private ArrayList<Task> Tuesday;
	private ArrayList<Task> Wednesday;
	private ArrayList<Task> Thursday;
	private ArrayList<Task> Friday;
	private ArrayList<Task> Saturday ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_task);
		
		Sunday = ((GlobalApp)getApplication()).getSunday();
		Monday = ((GlobalApp)getApplication()).getMonday();
		Tuesday = ((GlobalApp)getApplication()).getTuesday();
		Wednesday = ((GlobalApp)getApplication()).getWednesday();
		Thursday = ((GlobalApp)getApplication()).getThursday();
		Friday = ((GlobalApp)getApplication()).getFriday();
		Saturday = ((GlobalApp)getApplication()).getSaturday();
	}

	

}
