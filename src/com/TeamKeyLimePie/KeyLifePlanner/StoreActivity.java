package com.TeamKeyLimePie.KeyLifePlanner;

import java.util.ArrayList;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class StoreActivity extends Activity {
	MediaPlayer backgroundShop;
	public int bank;
	private ArrayList<Item> i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_avatar);

		backgroundShop = MediaPlayer.create(StoreActivity.this, R.raw.shop);
		backgroundShop.setLooping(true);
		backgroundShop.start();

		bank = ((GlobalApp)getApplication()).getmoney();

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() 
		{
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
			{

				//checks if the item is already bought
				if(i.isBought())
				{
					Toast.makeText(StoreActivity.this, "Already Bought!", Toast.LENGTH_SHORT).show();
				}
				//checks if enough money
				else if((((GlobalApp)getApplication()).getmoney() - i.getValue()) < 0)
				{
					Toast.makeText(StoreActivity.this, "Not enough money!", Toast.LENGTH_SHORT).show();
				}
				//decreases amount of money in wallet
				else
				{
					((GlobalApp)getApplication()).decmoney(i.getValue());
					Toast.makeText(StoreActivity.this, "Bought Item!", Toast.LENGTH_SHORT).show();
				}

			}
		});

		TextView wallet = (TextView)findViewById(R.id.wallet);
		wallet.setText("Amount of Coins: " + bank);
	}

}
