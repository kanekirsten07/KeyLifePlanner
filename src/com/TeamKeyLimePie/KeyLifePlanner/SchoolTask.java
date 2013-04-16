package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.Date;

import android.graphics.Bitmap;

public class SchoolTask extends Task{
	
	protected Bitmap iconimage;
	public SchoolTask(Bitmap icon, String description, Date timedue)
	{
		super(description, timedue);
		this.iconimage = icon;
		
	}

}
