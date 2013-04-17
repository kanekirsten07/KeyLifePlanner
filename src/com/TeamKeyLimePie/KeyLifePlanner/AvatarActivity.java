package com.TeamKeyLimePie.KeyLifePlanner;

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
				//if item was already bought...
				Toast.makeText(AvatarActivity.this, "Avatar Updated!", Toast.LENGTH_SHORT).show();
				//update avatar
				
				//else
				Toast.makeText(AvatarActivity.this, "Item Bought!", Toast.LENGTH_SHORT).show();
				//add item and subtract money from user
				//update avatar
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
