package com.TeamKeyLimePie.KeyLifePlanner;

public class Item {
	public int value;
	public boolean bought;
	
	public Item(int value, boolean bought)
	{
		this.value = value;
		this.bought = bought;
	}
	
	public boolean isBought()
	{
		return bought;
	}
	
	public int getValue()
	{
		return value;
	}
}
