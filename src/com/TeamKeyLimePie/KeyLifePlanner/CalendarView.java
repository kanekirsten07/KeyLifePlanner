package com.TeamKeyLimePie.KeyLifePlanner;



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

public class CalendarView extends View implements OnTouchListener {

	private CalendarActivity cal;
	

	public CalendarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		// TODO Auto-generated constructor stub
        LayoutInflater.from(context).inflate(R.layout.activity_calendar_view, null);
		 
		initCalendarView();
		cal.setContentView(R.layout.activity_calendar_view);
	}

	
	
	public void initCalendarView(){
		setFocusable(true);
	}




	
	public void setController(CalendarActivity calendar)
    {
    	this.cal=calendar;
    }



	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int s = v.getId();
		Log.d("Click", Integer.toString(s));
		return true;
    	
	}
}
