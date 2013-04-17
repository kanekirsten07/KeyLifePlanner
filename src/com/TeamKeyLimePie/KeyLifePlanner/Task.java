package com.TeamKeyLimePie.KeyLifePlanner;

public class Task {

	public String description;
	public String timedue;
	public int monetary_reward;
	public String typeoftask;
	public Task(String description, String timedue, String type, int value)
	{
		this.description = description;
		this.timedue = timedue;
		this.monetary_reward = value;
		this.typeoftask = type;
		
	}
}
