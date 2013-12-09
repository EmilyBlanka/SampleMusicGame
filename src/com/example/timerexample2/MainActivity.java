/*http://into.cocolog-nifty.com/pulog/2012/01/timertimertask-.html
*/
package com.example.timerexample2;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private long repeatInterval =5000; 
	private long delay =0;  // 繰り返しの間隔（単位：msec）
	Timer timer1;
	Timer timer2;
	Timer timer3;
	Handler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		handler = new Handler();
		
		// タイマー開始ボタンの処理
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// タイマー1をセット
				/*timer1 = new Timer();
				TimerTask timerTask1 = new Task1(MainActivity.this);
				timer1.scheduleAtFixedRate(timerTask1, repeatInterval, repeatInterval);*/
					
				// タイマー2をセット
				timer2 = new Timer();
				TimerTask timerTask2 = new Task2(MainActivity.this);
				timer2.schedule(timerTask2, delay);
				
				// タイマー3をセット
				timer3 = new Timer();
				TimerTask timerTask3 = new Task3(MainActivity.this,handler);
				timer3.schedule(timerTask3, delay);
				
				
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
			if (timer1 != null) {
				 timer1.cancel();
			} else if (timer2 != null) {
				timer2.cancel();
			} else if (timer3 != null) {
				timer3.cancel();
			}
		}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
