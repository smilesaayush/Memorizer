package com.example.memorizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity implements OnClickListener{

	Button newgame,setlevel,objective,exit;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		newgame=(Button)findViewById(R.id.button1);
		setlevel=(Button)findViewById(R.id.button2);
		objective=(Button)findViewById(R.id.button3);
		exit=(Button)findViewById(R.id.button4);
		newgame.setOnClickListener(this);
		setlevel.setOnClickListener(this);
		exit.setOnClickListener(this);
		objective.setOnClickListener(this);
		
	}
	
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.button1:
			Bundle b=new Bundle();
			b.putInt("lev", 0);
			Intent j=new Intent(MainMenu.this,MainMemo.class);
			j.putExtras(b);
			startActivity(j);
			break;
		case R.id.button2:
			Intent k=new Intent("com.example.memorizer.SetLevel");
			startActivity(k);
			break;
		case R.id.button3:
			Intent i=new Intent("com.example.memorizer.Objective");
			startActivity(i);
			break;
		case R.id.button4:
			finish();
			break;
		}
	}
}
