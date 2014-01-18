package com.example.memorizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SetLevel extends Activity implements OnCheckedChangeListener{

	RadioGroup rg;
	Button start;
	int level=0;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setlevel);
		start=(Button)findViewById(R.id.start);
		rg=(RadioGroup)findViewById(R.id.radioGroup1);
		rg.setOnCheckedChangeListener(this);
		start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle b=new Bundle();
				b.putInt("lev", level);
				Intent i=new Intent(SetLevel.this,MainMemo.class);
				i.putExtras(b);
				startActivity(i);
			}
		});
	}
	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		case R.id.radio1:
			level=1;
			break;
		case R.id.radio2:
			level=2;
			break;
		case R.id.radio3:
			level=3;
			break;
		case R.id.radio4:
			level=4;
			break;
		case R.id.radio5:
			level=5;
			break;
		}
	}
}
