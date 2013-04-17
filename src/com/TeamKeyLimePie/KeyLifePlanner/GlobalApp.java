package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;



import android.app.Application;

public class GlobalApp extends Application {
	private ArrayList<Task> Sunday ;
	private ArrayList<Task> Monday ;
	private ArrayList<Task> Tuesday;
	private ArrayList<Task> Wednesday;
	private ArrayList<Task> Thursday;
	private ArrayList<Task> Friday;
	private ArrayList<Task> Saturday ;
	private int money;
	public void setmoney(int num)
	{
		this.money = num;
	}
	public int getmoney()
	{
		return this.money;
	}
	
	public void setSunday(ArrayList<Task> sun){
		this.Sunday = sun;
	}
	public void setMonday(ArrayList<Task> mon)
	{
		this.Monday = mon;
	}
	public void setTuesday(ArrayList<Task> tues)
	{
		this.Tuesday = tues;
	}
	public void setWednesday(ArrayList<Task> wed)
	{
		this.Wednesday = wed;
	}
	
	public void setThursday(ArrayList<Task> thurs)
	{
		this.Thursday = thurs;
	}
	public void setFriday(ArrayList<Task> fri)
	{
		this.Friday = fri;
	}
	
	public ArrayList<Task> getSunday(){
		return Sunday;
	}
	public ArrayList<Task> getMonday(){
		return Monday;
	}
	public ArrayList<Task> getTuesday(){
	return Tuesday;
	}
	public ArrayList<Task> getWednesday(){
	return Wednesday;
	}	
	public ArrayList<Task> getThursday(){
		return Thursday;
	}
	public ArrayList<Task> getFriday(){
	return Friday;
	}
	public ArrayList<Task> getSaturday(){
	return Saturday;
	}

}
