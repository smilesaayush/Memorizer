package com.example.memorizer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity implements Runnable{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Thread tim=new Thread(this);		
		tim.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(2500);
		}catch (InterruptedException e) {}
		finally{
			Intent i=new Intent("com.example.memorizer.MainMenu");
			startActivity(i);
		}
	}

}
