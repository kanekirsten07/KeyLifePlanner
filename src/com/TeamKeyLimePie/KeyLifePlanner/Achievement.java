package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Achievement {
	
	public String description;
	public boolean hascompleted;
	
	public Achievement(String description, Boolean hascompleted)
	{
		this.description=description;
		this.hascompleted = hascompleted;
	}
	
	

}
