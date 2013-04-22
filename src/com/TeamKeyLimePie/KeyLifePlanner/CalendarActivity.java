package com.TeamKeyLimePie.KeyLifePlanner;



import java.util.ArrayList;
import java.util.Date;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.OnEditorActionListener;

public class CalendarActivity extends Activity implements OnClickListener{


	EditText taskedit;
	MediaPlayer backgroundCalendar;
	MediaPlayer success;
	public ArrayList<Task> Sunday ;
	public ArrayList<Task> Monday ;
	public ArrayList<Task> Tuesday ;
	public ArrayList<Task> Wednesday ;
	public ArrayList<Task> Thursday ;
	public ArrayList<Task> Friday ;
	public ArrayList<Task> Saturday ;
	public ListView task_listview;
	public int position = 0;
	public String activelist ;
	Context myContext;
	public int bank;
	String value = "";
	int reward = 0;
	String taskName; 
	public ArrayList<Task>activearraylist;
	UserItemAdapter u;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);


		backgroundCalendar = MediaPlayer.create(CalendarActivity.this, R.raw.neogardens);
		backgroundCalendar.setLooping(true);
		backgroundCalendar.start();
		activelist="Sunday";
		myContext =this;

		Button addTask = (Button)findViewById(R.id.addtask);		

		Button sun = (Button)findViewById(R.id.sunday);
		Button mon = (Button)findViewById(R.id.monday);
		Button tue = (Button)findViewById(R.id.tuesday);
		Button wed = (Button)findViewById(R.id.wednesday);
		Button thur = (Button)findViewById(R.id.thursday);
		Button fri = (Button)findViewById(R.id.friday);
		Button sat = (Button)findViewById(R.id.saturday);
		Typeface tf2 = Typeface.createFromAsset(getAssets(),
				"fonts/Lorenabold.ttf");
		sun.setTypeface(tf2);
		mon.setTypeface(tf2);
		tue.setTypeface(tf2);
		wed.setTypeface(tf2);
		thur.setTypeface(tf2);
		fri.setTypeface(tf2);
		sat.setTypeface(tf2);

		sun.setOnClickListener(this);
		mon.setOnClickListener(this);
		tue.setOnClickListener(this);
		wed.setOnClickListener(this);
		thur.setOnClickListener(this);
		fri.setOnClickListener(this);
		sat.setOnClickListener(this);
		addTask.setOnClickListener(this);

		Sunday = ((GlobalApp)getApplication()).getSunday();
		Monday = ((GlobalApp)getApplication()).getMonday();
		Tuesday = ((GlobalApp)getApplication()).getTuesday();
		Wednesday = ((GlobalApp)getApplication()).getWednesday();
		Thursday = ((GlobalApp)getApplication()).getThursday();
		Friday = ((GlobalApp)getApplication()).getFriday();
		Saturday = ((GlobalApp)getApplication()).getSaturday();
		bank = ((GlobalApp)getApplication()).getmoney();

		activearraylist=Sunday;


		task_listview = (ListView) findViewById(R.id.task_list);
		//Task t1 = new Task("hi", "6", "school", 0);
		//Sunday.add(t1);



		task_listview.setOnItemClickListener(new ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int i, long l) {
				position = i;
				try {

					DialogInterface.OnClickListener yesnobox = new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							switch(which){
							case DialogInterface.BUTTON_POSITIVE:
								success = MediaPlayer.create(CalendarActivity.this, R.raw.success);
								success.start();
								((GlobalApp)getApplication()).incmoney(reward);
								activearraylist.remove(position);
								
								u.notifyDataSetChanged();
								Toast.makeText(getApplicationContext(), "You've earned " + reward + " coins!", Toast.LENGTH_LONG).show();
								
								for(int i = 0; i <((GlobalApp)getApplication()).getAch().size(); i++ ){
									if(((GlobalApp)getApplication()).getAch().get(i).hascompleted==true )
									{
										Toast.makeText(getApplicationContext(), "You've earned a new achievement!", Toast.LENGTH_LONG).show();
										success = MediaPlayer.create(CalendarActivity.this, R.raw.success);
										success.start();
										((GlobalApp)getApplication()).setHasAchieved(false); 
									}
								}

								break;
							case DialogInterface.BUTTON_NEGATIVE:
								break;
							}

						}
					};
					AlertDialog.Builder builder = new AlertDialog.Builder(myContext);
					builder.setMessage("Have you Completed This activity?").setPositiveButton("Yes", yesnobox).setNegativeButton("No", yesnobox).show();
					// Remembers the selected Index
					if(activelist.equalsIgnoreCase("Sunday"))
					{
						reward = Sunday.get(i).monetary_reward;
						value = Integer.toString(reward);
						taskName = Sunday.get(i).typeoftask; 
						
						
					}else if(activelist.equalsIgnoreCase("Monday"))
					{
						reward = Monday.get(i).monetary_reward;
						value = Integer.toString(reward);
						taskName = Monday.get(i).typeoftask; 

					}else if(activelist.equalsIgnoreCase("Tuesday"))
					{
						reward = Tuesday.get(i).monetary_reward;
						value = Integer.toString(reward);
						taskName = Tuesday.get(i).typeoftask; 

					}else if(activelist.equalsIgnoreCase("Wednesday"))
					{
						reward = Wednesday.get(i).monetary_reward;
						value = Integer.toString(reward);
						taskName = Wednesday.get(i).typeoftask; 

					}else if(activelist.equalsIgnoreCase("Thursday"))
					{
						reward = Thursday.get(i).monetary_reward;
						value = Integer.toString(reward);
						taskName = Thursday.get(i).typeoftask; 

					}else if(activelist.equalsIgnoreCase("Friday"))
					{
						reward = Friday.get(i).monetary_reward;
						value = Integer.toString(reward);
						taskName = Friday.get(i).typeoftask; 

					}else if(activelist.equalsIgnoreCase("Saturday"))
					{
						reward = Saturday.get(i).monetary_reward;
						value = Integer.toString(reward);
						taskName = Saturday.get(i).typeoftask; 

					}
					Log.d("Reward", value);

				}
				catch(Exception e) {
					System.out.println("Nay, cannot get the selected index");
				}
				
				if(taskName.equalsIgnoreCase("Hygiene")){
					
					((GlobalApp)getApplication()).incNumHygiene() ;
					((GlobalApp)getApplication()).incNumTotalTasks();
				}
				else if(taskName.equalsIgnoreCase("Work")){
					((GlobalApp)getApplication()).incNumWork();
					((GlobalApp)getApplication()).incNumTotalTasks();
				}
				else if(taskName.equalsIgnoreCase("School")){
					((GlobalApp)getApplication()).incNumSchool();
					((GlobalApp)getApplication()).incNumTotalTasks();
				}
				else if(taskName.equalsIgnoreCase("Travel")){
					((GlobalApp)getApplication()).incNumTravel();
					((GlobalApp)getApplication()).incNumTotalTasks();
				}
				else if(taskName.equalsIgnoreCase("Custom")){
					((GlobalApp)getApplication()).incNumTravel();
					((GlobalApp)getApplication()).incNumTotalTasks();
				}


			}
		});


		task_listview.setAdapter(new UserItemAdapter(this, android.R.layout.simple_list_item_1, Sunday));
		u = (UserItemAdapter) task_listview.getAdapter();
	}

	public class UserItemAdapter extends ArrayAdapter<Task>{

		private ArrayList<Task> tasks;

		public UserItemAdapter(Context context, int textViewResourceId,
				ArrayList<Task> tasks) {
			super(context, textViewResourceId, tasks);

			this.tasks = tasks;
			// TODO Auto-generated constructor stub
		}



		@Override 
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View v = convertView;
			if(v == null){
				Log.d("view", "isnull");
				LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.listitem,null);
			}


			Task t = tasks.get(position);



			//Log.d("timedue", t.timedue);
			if(t != null){
				TextView description = (TextView)v.findViewById(R.id.description);
				TextView timedue = (TextView)v.findViewById(R.id.timedue);
				ImageView taskimage = (ImageView)v.findViewById(R.id.taskimage);
				if(t.typeoftask.equalsIgnoreCase("School")){
					taskimage.setImageResource(R.drawable.homework);
				}
				else if(t.typeoftask.equalsIgnoreCase("Work")){
					taskimage.setImageResource(R.drawable.workicon); 
				}
				else if(t.typeoftask.equalsIgnoreCase("Hygiene")){
					taskimage.setImageResource(R.drawable.iconhygiene); 
				}
				//No graphic for "Travel" Tasks 
				//				else if (t.typeoftask.equalsIgnoreCase("Travel")){
				//					taskimage.setImageResource(R.drawable.othericon);
				//				}
				else{
					taskimage.setImageResource(R.drawable.iconother); 
				}
				taskimage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);



				if(description != null){
					description.setText(t.description);
				}

				if(timedue != null)
				{
					timedue.setText("DO BY: "+t.timedue);
				}



			}

			return v;

		}

	}




	@Override
	protected void onPause()
	{
		super.onPause();
		backgroundCalendar.pause();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		backgroundCalendar.start();
		u.notifyDataSetChanged();
	}
	public void setInactive()
	{
		Button b;
		b = (Button) findViewById(R.id.sunday);
		b.setBackgroundDrawable(getResources().getDrawable(R.drawable.inactiveday));
		b = (Button) findViewById(R.id.monday);
		b.setBackgroundDrawable(getResources().getDrawable(R.drawable.inactiveday));
		b = (Button) findViewById(R.id.tuesday);
		b.setBackgroundDrawable(getResources().getDrawable(R.drawable.inactiveday));
		b = (Button) findViewById(R.id.wednesday);
		b.setBackgroundDrawable(getResources().getDrawable(R.drawable.inactiveday));
		b = (Button) findViewById(R.id.thursday);
		b.setBackgroundDrawable(getResources().getDrawable(R.drawable.inactiveday));
		b = (Button) findViewById(R.id.friday);
		b.setBackgroundDrawable(getResources().getDrawable(R.drawable.inactiveday));
		b = (Button) findViewById(R.id.saturday);
		b.setBackgroundDrawable(getResources().getDrawable(R.drawable.inactiveday));
	}


	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i;
		Button b;
		switch (v.getId()){
		case R.id.addtask:
			Log.d("click", "Add Task was clicked");

			i = new Intent (this, AddTaskActivity.class);
			startActivity(i);
			break;
		case R.id.sunday:
			b = (Button) findViewById(R.id.sunday);
			activearraylist=Sunday;
			setInactive();
			b.setBackgroundDrawable(getResources().getDrawable(R.drawable.activeday));
			task_listview.setAdapter(new UserItemAdapter(this, android.R.layout.simple_list_item_1, Sunday));
			activelist="Sunday";
			break;
		case R.id.monday:
			b = (Button) findViewById(R.id.monday);
			setInactive();
			activearraylist=Monday;
			task_listview.setAdapter(new UserItemAdapter(this, android.R.layout.simple_list_item_1, Monday));
			b.setBackgroundDrawable(getResources().getDrawable(R.drawable.activeday));
			activelist="Monday";
			break;
		case R.id.tuesday:
			b = (Button) findViewById(R.id.tuesday);
			setInactive();
			activearraylist=Tuesday;
			b.setBackgroundDrawable(getResources().getDrawable(R.drawable.activeday));
			task_listview.setAdapter(new UserItemAdapter(this, android.R.layout.simple_list_item_1, Tuesday));
			activelist="Tuesday";
			break;
		case R.id.wednesday:
			b = (Button) findViewById(R.id.wednesday);
			setInactive();
			activearraylist=Wednesday;
			b.setBackgroundDrawable(getResources().getDrawable(R.drawable.activeday));
			task_listview.setAdapter(new UserItemAdapter(this, android.R.layout.simple_list_item_1, Wednesday));
			activelist="Wednesday";
			break;
		case R.id.thursday:
			b = (Button) findViewById(R.id.thursday);
			setInactive();
			activearraylist=Thursday;
			b.setBackgroundDrawable(getResources().getDrawable(R.drawable.activeday));
			task_listview.setAdapter(new UserItemAdapter(this, android.R.layout.simple_list_item_1, Thursday));
			activelist="Thursday";
			break;
		case R.id.friday:
			b = (Button) findViewById(R.id.friday);
			setInactive();
			activearraylist=Friday;
			b.setBackgroundDrawable(getResources().getDrawable(R.drawable.activeday));
			task_listview.setAdapter(new UserItemAdapter(this, android.R.layout.simple_list_item_1, Friday));
			activelist="Friday";
			break;
		case R.id.saturday:
			b = (Button) findViewById(R.id.saturday);
			activearraylist=Saturday;
			setInactive();
			b.setBackgroundDrawable(getResources().getDrawable(R.drawable.activeday));
			task_listview.setAdapter(new UserItemAdapter(this, android.R.layout.simple_list_item_1, Saturday));
			activelist="Saturday";
			break;
		}
	}



}

