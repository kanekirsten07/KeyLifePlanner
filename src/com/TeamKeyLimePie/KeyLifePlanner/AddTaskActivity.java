package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;



import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.Activity;

import android.content.Intent;

public class AddTaskActivity extends Activity implements OnClickListener{

	private ArrayList<Task> Sunday ;
	private ArrayList<Task> Monday ;
	private ArrayList<Task> Tuesday;
	private ArrayList<Task> Wednesday;
	private ArrayList<Task> Thursday;
	private ArrayList<Task> Friday;
	private ArrayList<Task> Saturday ;
	private EditText taskedit;
	private Spinner daydue;
	private Spinner timedue;
	private Spinner typeoftask;
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
		taskedit = (EditText)findViewById(R.id.taskname);
		daydue = (Spinner)findViewById(R.id.day);
		timedue = (Spinner)findViewById(R.id.time_due);
		typeoftask = (Spinner)findViewById(R.id.task_spinner);
	       
Button submit = (Button)findViewById(R.id.submit);
		
		submit.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("Click", "clicked");
		switch (v.getId()){
    	case R.id.submit:
    		Log.d("Submit", "clicked");
    		String desc = taskedit.getText().toString();
    		String due = timedue.getSelectedItem().toString();
    		String type= typeoftask.getSelectedItem().toString();
    		String day = daydue.getSelectedItem().toString();
    		Log.d("description", desc);
    		Log.d("due", due);
    		Log.d("type", type);
    		Log.d("day", day);
    		break;
		}
		
	}

	

}
