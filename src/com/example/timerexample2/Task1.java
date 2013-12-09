package com.example.timerexample2;

import java.util.TimerTask;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;

public class Task1 extends TimerTask {
	
	private Handler handler;
	private MediaPlayer mediaPlayer;
	private Context context;
	
	public Task1(Context context) {
		this.context=context;
		handler = new Handler();
		mediaPlayer =MediaPlayer.create(context, R.raw.test0);
	}
	
	@Override
	public void run() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				mediaPlayer.start();
			}
		});
	}
	
	
}
