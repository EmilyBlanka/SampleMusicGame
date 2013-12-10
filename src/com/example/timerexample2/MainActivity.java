/*http://into.cocolog-nifty.com/pulog/2012/01/timertimertask-.html
*/
package com.example.timerexample2;

import java.util.Timer;
import java.util.TimerTask;

import org.w3c.dom.Text;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener {

	SoundPool BD;
	SoundPool snare;
	SoundPool hihat;
	SoundPool open;
	int sound_id1;
	int sound_id2;
	int sound_id3;
	int sound_id4;
	ImageButton BD_button;
	ImageButton snare_button;
	ImageButton hihat_button;
	ImageButton open_button;
	
	private long justnow =0;  // 繰り返しの間隔（単位：msec）
	private long[] delay1= {2327,5964,9600};
	private long[] delay2={10509,11191,11873,12595,13236,13691};
	private long[] delay3={2555,6191,9827,10509,11191,11873,12595,13236,13691};
	private long Touch1TimeMillis;
	private long StartTimeMillis;
	private long Time ;
	
	Timer timer =new Timer();
	Handler handler;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BD = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        snare = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        hihat = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        sound_id1 = BD.load(this, R.raw.bd01, 1 );
        sound_id2 = snare.load(this, R.raw.ride_01, 1 );
        sound_id3 = hihat.load(this, R.raw.toms132, 1 );
        BD_button = (ImageButton) findViewById(R.id.MusicIconButton1);
        snare_button =(ImageButton) findViewById(R.id.MusicIconButton2);
        hihat_button =(ImageButton) findViewById(R.id.MusicIconButton3);
        BD_button.setOnTouchListener(this);
        snare_button.setOnTouchListener(this);
        hihat_button.setOnTouchListener(this);
        

		
        handler = new Handler();
		
		// タイマー開始ボタンの処理
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//現在時刻を取得
				StartTimeMillis = System.currentTimeMillis();
				String valueToString = String.valueOf(StartTimeMillis);
				TextView textView = (TextView) findViewById(R.id.textView1);
				textView.setText(valueToString);
				
				// タイマー1をセット
				TimerTask timerTask1 = new Task1(MainActivity.this);
				timer.schedule(timerTask1, justnow);
				
				
				// タイマー2(イメージボタン1)をセット
				for(int i=0; i < delay1.length; i++) {	
					TimerTask timerTask2 = new Task2(MainActivity.this,handler);
					timer.schedule(timerTask2, delay1[i]); 
				}
			
				// タイマー3(イメージボタン2)をセット
				for(int i=0; i < delay2.length;i++) {
					TimerTask timerTask3 = new Task3(MainActivity.this,handler);
					timer.schedule(timerTask3, delay2[i]);
				}
				
				// タイマー4(イメージボタン3)をセット
				for(int i=0; i < delay3.length;i++) {
					TimerTask timerTask4 = new Task4(MainActivity.this,handler);
					timer.schedule(timerTask4, delay3[i]);
				}
				
				// タイマー5(イメージボタン4)をセット
				/*for(int i=0;i<1;i++) {
					TimerTask timerTask5 = new Task5(MainActivity.this,handler);
					timer.schedule(timerTask5, delay4[i]);
				}
				*/
				// トーストでタイマー開始を通知
				Toast toast = Toast.makeText(MainActivity.this, R.string.timer_start,Toast.LENGTH_LONG);
				toast.show();
			}
		});
	}
	
		/**
		 * 終了処理
		 */
		@Override
		protected void onDestroy() {
			 super.onDestroy();
			 cancelTimer();
		}
		
		/**
		 * タイマーをキャンセルする。
		 */
		private void cancelTimer() {
			if (timer != null) {
				 timer.cancel();
			} 
		}
	
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			
			
			if(event.getAction() == MotionEvent.ACTION_DOWN) {
				switch (v.getId()) {
				case R.id.MusicIconButton1:
					Touch1TimeMillis = System.currentTimeMillis();
					
					String valueToString = String.valueOf(Touch1TimeMillis);
					TextView textView1 = (TextView) findViewById(R.id.textView2);
					textView1.setText(valueToString);
					
					Time =Touch1TimeMillis-StartTimeMillis;
					String valueToString1 = String.valueOf(Time);
					TextView textView2 = (TextView) findViewById(R.id.textView3);
					textView2.setText(valueToString1);
					
					BD.play(sound_id1, 1.0F, 1.0F, 0, 0, 1.0F);
					
					for( int i=0; i<delay1.length; i++){
						//100mscの猶予
						if( delay1[i]+400-100 <= Time && Time <= delay1[i]+400+100 ) {
							TextView textView3 = (TextView) findViewById(R.id.textView4);
							textView3.setText("Great!");
							
						//400mscの猶予
						} else if ((delay1[i]+400-500) <= Time && Time < (delay1[i]+400-100)) {
							TextView textView4 = (TextView) findViewById(R.id.textView4);
							textView4.setText("Good!");
						} else if ((delay1[i]+400+100) < Time && Time <= (delay1[i]+400+500)) {
							TextView textView4 = (TextView) findViewById(R.id.textView4);
							textView4.setText("Good!");
						}else  {
								TextView textView5 = (TextView) findViewById(R.id.textView4);
								textView5.setText("Bad.");
						}
					}
					break;
					
				case R.id.MusicIconButton2:
					snare.play(sound_id2, 1.0F, 1.0F, 0, 0, 1.0F);
					break;
				case R.id.MusicIconButton3:
					hihat.play(sound_id3, 1.0F, 1.0F, 0, 0, 1.0F);
					break;
				}
				return true;
			}else if(event.getAction() == MotionEvent.ACTION_POINTER_UP) {
				switch (v.getId()) {
				case R.id.MusicIconButton1:
					BD.stop(sound_id1);
					break;
				case R.id.MusicIconButton2:
					snare.stop(sound_id2);
					break;
				case R.id.MusicIconButton3:
					hihat.stop(sound_id3);
					break;
				}
	            return true;
	        }
			return false;
		}
		
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
