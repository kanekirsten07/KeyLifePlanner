package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.Date;



public class Task {
	protected String description;
	protected Date timedue;
	
	public Task(String description, Date timedue)
	{
		this.description = description;
		this.timedue = timedue;
	}

}
