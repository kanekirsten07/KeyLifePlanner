package com.TeamKeyLimePie.KeyLifePlanner;

// BACK MAIN FOR ADD TASK VIEW

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class AddTaskView extends View implements OnTouchListener {

	private AddTaskActivity addNewTask;
	

	public AddTaskView(Context context, AttributeSet attrs) {
		super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.add_task_view, null);
		 
		initCalendarView();
		addNewTask.setContentView(R.layout.add_task_view);
	}

	public void initCalendarView(){
		setFocusable(true);
	}
	
	public void setController(AddTaskActivity newTask)
    {
    	this.addNewTask=newTask;
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int s = v.getId();
		Log.d("Click", Integer.toString(s));
		return true;
    	
	}
}
