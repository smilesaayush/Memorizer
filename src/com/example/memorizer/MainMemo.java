package com.example.memorizer;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainMemo extends Activity implements OnClickListener{
	
	Thread t;
	int level=0;
	int chances=3;
	String code;
	TextView info,datacode;
	EditText usercode;
	Button result;
	String co="";
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmemo);
		initialize();
	}
	public void initialize(){
		Bundle getlevel=getIntent().getExtras();
		level=getlevel.getInt("lev");
		
		info=(TextView)findViewById(R.id.info);
		datacode=(TextView)findViewById(R.id.datacode);
		usercode=(EditText)findViewById(R.id.usercode);
		result=(Button)findViewById(R.id.result);
		result.setOnClickListener(this);
		datacode.setTextSize(45);
		usercode.setTextSize(45);
		datacode.setTextColor(Color.WHITE);
		datacode.setBackgroundColor(Color.BLACK);
		info.setText("level = "+level);
		usercode.setEnabled(false);
		result.setEnabled(false);
		initialalert();
		//makenewthread();
	}
	
	
	public void makenewthread(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int codelength=level+5;
				co="";
				start_game(codelength);		
			}
		}).start();	
	}
	
	
	public void start_game(int codelength){
		//String co="";
		try{
			//a //info.setText("level = "+level+"   chances = "+chances);
			a.sendEmptyMessage(0);
			Thread.sleep(1000);
			for(int i=1;i<=codelength;i++){
				Random rn=new Random();
				int num=rn.nextInt(26) + 1;
				int ch=num+64;
				co=co+(char)ch;
				//b //datacode.setText(""+co);
				b.sendEmptyMessage(0);
				
				Thread.sleep(1000);				
			}
			Thread.sleep(level*800);
			//c
			/*code=datacode.getText().toString();
			datacode.setText("");
			usercode.setEnabled(true);
			result.setEnabled(true);
			*/ c.sendEmptyMessage(0);
		}catch(InterruptedException e){}
	}
	
	Handler a=new Handler(){
		public void handleMessage(android.os.Message msg) {
			info.setText("level = "+level+"   chances = "+chances);
		};
	};
	Handler b=new Handler(){
		public void handleMessage(android.os.Message msg) {
			datacode.setText(""+co);
		};
	};
	Handler c=new Handler(){
		public void handleMessage(android.os.Message msg) {
			code=datacode.getText().toString();
			datacode.setText("");
			usercode.setEnabled(true);
			result.setEnabled(true);
		};
	};
	
	public void initialalert(){
		AlertDialog.Builder ap=new AlertDialog.Builder(this);
		ap.setTitle("status");
		ap.setMessage(" level = "+level+"\n chances = "+chances);
		ap.setPositiveButton("ok", new DialogInterface.OnClickListener() {
	
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				makenewthread();
			}
		});
		ap.show();
	}
	public void passedalert(){
		AlertDialog.Builder ap=new AlertDialog.Builder(this);
		ap.setTitle("status");
		ap.setMessage(" you PASSED!!"+"\n Next level = "+level+"\n chances = "+chances);
		ap.setPositiveButton("ok", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				usercode.setText("");
				usercode.setEnabled(false);
				result.setEnabled(false);
				makenewthread();
			}
		});
		ap.show();
	}
	public void failedalert(){
		AlertDialog.Builder ap=new AlertDialog.Builder(this);
		ap.setTitle("status");
		ap.setMessage(" you FAILED!!"+"\n correct CODE = "+code+"\n level = "+level+"\n chances = "+chances);
		ap.setPositiveButton("ok", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				usercode.setText("");
				usercode.setEnabled(false);
				result.setEnabled(false);
				makenewthread();
			}
		});
		ap.show();
	}
	public void gameoveralert(){
		AlertDialog.Builder ap=new AlertDialog.Builder(this);
		ap.setTitle("status");
		ap.setMessage(" GAME OVER!!"+"\n correct CODE = "+code);
		ap.setPositiveButton("ok", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		ap.show();
	}
	
	public void gamefinishalert(){
		AlertDialog.Builder ap=new AlertDialog.Builder(this);
		ap.setTitle("status");
		ap.setMessage("CONGRATULATIONS!! \nYOU HAVE SUCCESSFULLY FINISHED THE GAME!!");
		ap.setPositiveButton("ok", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		ap.show();
	}
	
	public void onClick(View arg0) {
		switch(arg0.getId()){
		case R.id.result:
			String a=usercode.getText().toString();
			a=a.trim();
			
			if(a.equalsIgnoreCase(code)){
				level++;
				//JOptionPane.showMessageDialog(fr," you PASSED \n"+" level = "+level+"    chances = "+chances );
				if(level==11){
					gamefinishalert();
				}
				else{
					passedalert();
				}
				
			}
			else{
				chances--;
				if(chances!=0){
					//JOptionPane.showMessageDialog(fr," you FAILED\n"+" correct CODE = "+code+" \n "+"chances left = "+chances);
					failedalert();
					
				}
				else{
					//JOptionPane.showMessageDialog(fr," GAME OVER!!\n"+" correct CODE = "+code);
					gameoveralert();
					
				}
			}
			break;
		}
	}
	
	
}

