package com.TeamKeyLimePie.KeyLifePlanner;



import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
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
		
		 
		initCalendarView();
	}

	
	
	public void initCalendarView(){
		setFocusable(true);
	}



	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void setController(CalendarActivity calendar)
    {
    	this.cal=calendar;
    }
}
