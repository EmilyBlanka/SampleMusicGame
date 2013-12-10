package com.example.timerexample2;

import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class Task2 extends TimerTask {
	
	private Handler handler;
	private Context context;
	ImageButton imgbtn1;		
	Animation anim1;
		
	public Task2(MainActivity activity,Handler handler) {
		this.context=context;
		this.handler = handler;
		anim1 = AnimationUtils.loadAnimation(activity,R.anim.img1_anim);
		imgbtn1 = (ImageButton)activity.findViewById(R.id.MusicIconButton1);

		
	}
	
	@Override
	public void run() {
		handler.post(new Runnable() {
			 @Override
			 public void run() {
				 imgbtn1.startAnimation(anim1);
			      }
			    });
	}
}

