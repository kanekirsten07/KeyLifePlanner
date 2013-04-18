package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

public class AvatarActivity extends Activity implements OnClickListener{

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
				ArrayList<Item> i = ((GlobalApp)getApplication()).getItem();

				//checks if the item as been bought yet
				if(!(i.get(position).isBought()))
				{
					Toast.makeText(AvatarActivity.this, "Not bought yet!", Toast.LENGTH_SHORT).show();
				}
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

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i;
		Button b;
		if (v.getId() == R.id.store)
		{
			Log.d("click", "Store was clicked");
			i = new Intent (this, StoreActivity.class);
			startActivity(i);
		}
	}
}
