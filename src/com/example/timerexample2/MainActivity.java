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
	private long delay =0;  // �J��Ԃ��̊Ԋu�i�P�ʁFmsec�j
	Timer timer1;
	Timer timer2;
	Timer timer3;
	Handler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		handler = new Handler();
		
		// �^�C�}�[�J�n�{�^���̏���
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// �^�C�}�[1���Z�b�g
				/*timer1 = new Timer();
				TimerTask timerTask1 = new Task1(MainActivity.this);
				timer1.scheduleAtFixedRate(timerTask1, repeatInterval, repeatInterval);*/
					
				// �^�C�}�[2���Z�b�g
				timer2 = new Timer();
				TimerTask timerTask2 = new Task2(MainActivity.this);
				timer2.schedule(timerTask2, delay);
				
				// �^�C�}�[3���Z�b�g
				timer3 = new Timer();
				TimerTask timerTask3 = new Task3(MainActivity.this,handler);
				timer3.schedule(timerTask3, delay);
				
				
				// �g�[�X�g�Ń^�C�}�[�J�n��ʒm
				Toast toast = Toast.makeText(MainActivity.this, R.string.timer_start,Toast.LENGTH_LONG);
				toast.show();
			}
		});
	}
		/**
		 * �I������
		 */
		@Override
		protected void onDestroy() {
			 super.onDestroy();
			 cancelTimer();
		}
		
		/**
		 * �^�C�}�[���L�����Z������B
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
