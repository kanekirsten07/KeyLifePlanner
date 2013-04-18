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
	private ArrayList<Item> item = new ArrayList<Item>();
	
	
	
	
	
	
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
	public ArrayList<Item> getItem(){
		return item;
	}

	
	private int numHygiene = 0;
	private int numWork = 0;
	private int numSchool = 0;
	private int numTravel = 0; 
	private int numCustom = 0; 
	private int numTotalTasks = 0;
	
	public void setNumHygiene(int num){this.numHygiene = num;}
	public void incNumHygiene(){this.numHygiene = numHygiene +1;}
	public int getNumHygiene(){return numHygiene;}
	
	public void setNumWork(int num){this.numWork = num;}
	public void incNumWork(){this.numWork = numWork +1;}
	public int getNumWork(){return numWork;}
	
	public void setNumSchool(int num){this.numSchool = num;}
	public void incNumSchool(){this.numSchool = numSchool +1;}
	public int getNumSchool(){return numSchool;}
	
	public void setNumTravel(int num){this.numTravel = num;}
	public void incNumTravel(){this.numTravel = numTravel +1;}
	public int getNumTravel(){return numTravel;}
	
	public void setNumCustom(int num){this.numCustom = num;}
	public void incNumCustom(){this.numCustom = numCustom +1;}
	public int getNumCustom(){return numCustom;}
	
	public void setNumTotalTasks(){this.numTotalTasks = numHygiene + numWork + numSchool + numCustom;}
	public void incNumTotalTasks(){this.numTotalTasks = getNumTotalTasks() +1; }
	public int getNumTotalTasks(){return numTotalTasks;}

}
