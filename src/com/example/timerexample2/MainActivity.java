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

	private long justnow =0;  // 繰り返しの間隔（単位：msec）
	private long[] delay1= {1000,3000,6000};
	private long[] delay2={3000,4000};
	private long[] delay3={3000,4000};
	private long[] delay4={3000,4000};
	
	Timer timer =new Timer();

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
				
				TimerTask timerTask1 = new Task1(MainActivity.this);
				timer.schedule(timerTask1, justnow);
				
				
				// タイマー2(イメージボタン1)をセット
				for(int i=0;i<2;i++) {	
					TimerTask timerTask2 = new Task2(MainActivity.this,handler);
					timer.schedule(timerTask2, delay1[i]);
				}
			
				// タイマー3(イメージボタン2)をセット
				for(int i=0;i<2;i++) {
					TimerTask timerTask3 = new Task3(MainActivity.this,handler);
					timer.schedule(timerTask3, delay2[i]);
				}
				
				// タイマー4(イメージボタン3)をセット
				for(int i=0;i<2;i++) {
					TimerTask timerTask4 = new Task4(MainActivity.this,handler);
					timer.schedule(timerTask4, delay3[i]);
				}
				
				// タイマー5(イメージボタン4)をセット
				for(int i=0;i<2;i++) {
					TimerTask timerTask5 = new Task5(MainActivity.this,handler);
					timer.schedule(timerTask5, delay4[i]);
				}
				
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
