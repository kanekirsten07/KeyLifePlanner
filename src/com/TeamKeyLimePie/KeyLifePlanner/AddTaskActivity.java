package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;
import java.util.Random;



import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import android.content.Intent;
import android.graphics.Typeface;

public class AddTaskActivity extends Activity implements OnClickListener{

	public ArrayList<Task> Sunday ;
	public ArrayList<Task> Monday ;
	public ArrayList<Task> Tuesday ;
	public ArrayList<Task> Wednesday ;
	public ArrayList<Task> Thursday ;
	public ArrayList<Task> Friday ;
	public ArrayList<Task> Saturday ;
	private EditText taskedit;
	private Spinner daydue;
	private Spinner timedue;
	private Spinner typeoftask;
	Random randomvalue = new Random();
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
		
		TextView title = (TextView)findViewById(R.id.addtask_title);	
		Typeface tf1 = Typeface.createFromAsset(getAssets(),
		        "fonts/governor.ttf");
		title.setTypeface(tf1);
		submit.setTypeface(tf1);
		
		TextView namelabel = (TextView)findViewById(R.id.namelabel);
		TextView category_label = (TextView)findViewById(R.id.category_label);
		TextView dueby_label = (TextView)findViewById(R.id.dueby_label);
		Typeface tf2 = Typeface.createFromAsset(getAssets(),
		        "fonts/Lorenabold.ttf");
		namelabel.setTypeface(tf2);
		category_label.setTypeface(tf2);
		dueby_label.setTypeface(tf2);
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
    		int value = randomvalue.nextInt(25)+1;
    		Task t = new Task(desc, due, type, value);
    		Log.d("value", Integer.toString(value));
    		if(day.equalsIgnoreCase("Sunday"))
    		{
    			Sunday.add(t);
    			((GlobalApp)getApplication()).setSunday(Sunday);
    		}else if(day.equalsIgnoreCase("Monday")){
    			Monday.add(t);
    			((GlobalApp)getApplication()).setMonday(Monday);
    		}else if(day.equalsIgnoreCase("Tuesday"))
    		{
    			Tuesday.add(t);
    			((GlobalApp)getApplication()).setTuesday(Tuesday);
    			
    		}else if(day.equalsIgnoreCase("Wednesday"))
    		{
    			Wednesday.add(t);
    			((GlobalApp)getApplication()).setWednesday(Wednesday);
    		}else if(day.equalsIgnoreCase("Thursday"))
    		{
    			Thursday.add(t);
    			((GlobalApp)getApplication()).setThursday(Thursday);
    		}else if(day.equalsIgnoreCase("Friday"))
    		{
    			Friday.add(t);
    			((GlobalApp)getApplication()).setFriday(Friday);
    		}else if(day.equalsIgnoreCase("Saturday"))
    		{
    			Saturday.add(t);
    			((GlobalApp)getApplication()).setSaturday(Saturday);
    		}

    		Toast.makeText(getApplicationContext(), "Task Added to " + day, Toast.LENGTH_LONG).show();
    		break;
		}
		
	}

	

}
