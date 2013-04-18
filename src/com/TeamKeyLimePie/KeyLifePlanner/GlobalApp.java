package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;



import android.app.Application;

public class GlobalApp extends Application {
	private ArrayList<Task> Sunday = new ArrayList<Task>();
	private ArrayList<Task> Monday  = new ArrayList<Task>();
	private ArrayList<Task> Tuesday = new ArrayList<Task>();
	private ArrayList<Task> Wednesday = new ArrayList<Task>();
	private ArrayList<Task> Thursday = new ArrayList<Task>();
	private ArrayList<Task> Friday = new ArrayList<Task>();
	private ArrayList<Task> Saturday= new ArrayList<Task>();
	private int money = 0;
	private ArrayList<Item> store = new ArrayList<Item>();
	
	
	public void setmoney(int num)
	{
		this.money = num;
	}
	public void incmoney(int num)
	{
		this.money = money + num;
	}
	public void decmoney(int num)
	{
		this.money = money - num;
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
	public void setSaturday(ArrayList<Task> sat)
	{
		this.Saturday=sat;
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
