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

	private long justnow =0;  // �J��Ԃ��̊Ԋu�i�P�ʁFmsec�j
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
		
		// �^�C�}�[�J�n�{�^���̏���
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			
					
				// �^�C�}�[1���Z�b�g
				
				TimerTask timerTask1 = new Task1(MainActivity.this);
				timer.schedule(timerTask1, justnow);
				
				
				// �^�C�}�[2(�C���[�W�{�^��1)���Z�b�g
				for(int i=0;i<2;i++) {	
					TimerTask timerTask2 = new Task2(MainActivity.this,handler);
					timer.schedule(timerTask2, delay1[i]);
				}
			
				// �^�C�}�[3(�C���[�W�{�^��2)���Z�b�g
				for(int i=0;i<2;i++) {
					TimerTask timerTask3 = new Task3(MainActivity.this,handler);
					timer.schedule(timerTask3, delay2[i]);
				}
				
				// �^�C�}�[4(�C���[�W�{�^��3)���Z�b�g
				for(int i=0;i<2;i++) {
					TimerTask timerTask4 = new Task4(MainActivity.this,handler);
					timer.schedule(timerTask4, delay3[i]);
				}
				
				// �^�C�}�[5(�C���[�W�{�^��4)���Z�b�g
				for(int i=0;i<2;i++) {
					TimerTask timerTask5 = new Task5(MainActivity.this,handler);
					timer.schedule(timerTask5, delay4[i]);
				}
				
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
