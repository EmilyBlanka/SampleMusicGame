/*http://into.cocolog-nifty.com/pulog/2012/01/timertimertask-.html
*/
package com.example.timerexample2;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private long repeatInterval =5000;  // �J��Ԃ��̊Ԋu�i�P�ʁFmsec�j
	Timer timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*final EditText editText1 = (EditText)findViewById(R.id.editText1);*/
		// �^�C�}�[�J�n�{�^���̏���
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// �^�C�}�[���Z�b�g
				timer = new Timer();
				TimerTask timerTask = new Task1(MainActivity.this);
				timer.scheduleAtFixedRate(timerTask, repeatInterval, repeatInterval);
				
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
