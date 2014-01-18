package com.example.memorizer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Objective extends Activity {

	TextView t;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.objective);
		t=(TextView)findViewById(R.id.textView1);
		t.setTextSize(25);
	}
}
