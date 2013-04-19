package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

public class AvatarActivity extends Activity implements OnClickListener{

	MediaPlayer backgroundShop;
	public int bank;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_avatar);

		backgroundShop = MediaPlayer.create(AvatarActivity.this, R.raw.shop);
		backgroundShop.setLooping(true);
		backgroundShop.start();

		TextView avatar_title = (TextView)findViewById(R.id.avatar_banner);
		Typeface tf1 = Typeface.createFromAsset(getAssets(),
		        "fonts/governor.ttf");
		avatar_title.setTypeface(tf1);
		
		bank = ((GlobalApp)getApplication()).getmoney();

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));
		
		Button viewStore = (Button)findViewById(R.id.store);
		    viewStore.setOnClickListener(this);
		    
		    ArrayList<Item> i = new ArrayList<Item>();
		    Item i1 = new Item(100, false);
		    Item i2 = new Item(250, false);
		    Item i3 = new Item(150, false);
		    Item i4 = new Item(200, true);
		    Item i5 = new Item(200, false);
		    Item i6 = new Item(175, true);
		    Item i7 = new Item(150, true);
		    Item i8 = new Item(300, false);
		    Item i9 = new Item(250, false);
		    i.add(i1);
		    i.add(i2);
		    i.add(i3);
		    i.add(i4);
		    i.add(i5);
		    i.add(i6);
		    i.add(i7);
		    i.add(i8);
		    i.add(i9);

		gridview.setOnItemClickListener(new OnItemClickListener() 
		{
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
			{
				 ArrayList<Item> i = new ArrayList<Item>();
				         Item i1 = new Item(100, false);
				         Item i2 = new Item(250, false);
				         Item i3 = new Item(150, false);
				         Item i4 = new Item(200, false);
				         Item i5 = new Item(200, false);
				         Item i6 = new Item(175, false);
				         Item i7 = new Item(150, false);
				         Item i8 = new Item(300, false);
				         Item i9 = new Item(250, false);
				         Item i10 = new Item(150, false);
				         i.add(i1);
				         i.add(i2);
				         i.add(i3);
				         i.add(i4);
				         i.add(i5);
				         i.add(i6);
				         i.add(i7);
				         i.add(i8);
				         i.add(i9);
				         i.add(i10);
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
		backgroundShop.pause();
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
		if (v.getId() == R.id.store)
		{
			Log.d("click", "Store was clicked");
			i = new Intent (this, StoreActivity.class);
			startActivity(i);
		}
	}
}
