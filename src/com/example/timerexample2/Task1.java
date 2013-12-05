package com.example.timerexample2;

import java.util.TimerTask;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class Task1 extends TimerTask {
	
	private Handler handler;
	private Context context;
	
	public Task1(Context context) {
		handler = new Handler();
		this.context = context;
	}

	@Override
	public void run() {
		// Viewの操作だけじゃなくてトーストを出すのにもHandler使わないといけないのか
		handler.post(new Runnable() {
			 @Override
			 public void run() {
			        // トーストを出す。
			        Toast myToast = Toast.makeText(
			            context, "Hello, How are you?",
			            Toast.LENGTH_SHORT);
			        myToast.show();
			      }
			    });
			  }
			}

