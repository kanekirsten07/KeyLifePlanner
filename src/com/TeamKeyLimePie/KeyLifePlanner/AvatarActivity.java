package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

public class AvatarActivity extends Activity{

	MediaPlayer backgroundShop;
	public int bank;
	private ArrayList<Item> i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_avatar);

		backgroundShop = MediaPlayer.create(AvatarActivity.this, R.raw.shop);
		backgroundShop.setLooping(true);
		backgroundShop.start();

		bank = ((GlobalApp)getApplication()).getmoney();
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() 
		{
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
			{
				//checks if the item as been bought yet
				if(!(i.isBought()))
				{
					Toast.makeText(AvatarActivity.this, "Not bought yet!", Toast.LENGTH_SHORT).show();
				}
				//updates avatar
				else
				{
					Toast.makeText(AvatarActivity.this, "Avatar Updated!", Toast.LENGTH_SHORT).show();
					//update avatar
				}
				
			}
		});
		
		TextView wallet = (TextView)findViewById(R.id.wallet);
		wallet.setText("Amount of Coins: " + bank);
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		backgroundShop.stop();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		backgroundShop.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.avatar, menu);
		return true;
	}

}
