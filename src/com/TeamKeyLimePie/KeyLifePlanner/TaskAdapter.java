package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskAdapter extends ArrayAdapter<Task>{
	Context context;
	int layoutResourceId;
	ArrayList<Task> tasks;
	String desc;
	
	public TaskAdapter(Context context, int layoutResourceId, 
			ArrayList<Task> tasks){
		super(context, layoutResourceId, tasks);
		this.context = context;
		this.tasks = tasks;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
		TaskHolder holder = null;
		if(row == null)
		{
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			holder = new TaskHolder();
			
			holder.txtTitle = (TextView)row.findViewById(R.id.description);
			row.setTag(holder);
			
		}
		else
		{
			holder = (TaskHolder)row.getTag();
		}
		Task task = tasks.get(position);
		holder.txtTitle.setText(task.desc);
		
		return row;
	}
	static class TaskHolder
	{
		ImageView imgIcon;
		TextView txtTitle;
	}

}
