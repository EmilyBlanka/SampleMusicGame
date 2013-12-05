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
		// View�̑��삾������Ȃ��ăg�[�X�g���o���̂ɂ�Handler�g��Ȃ��Ƃ����Ȃ��̂�
		handler.post(new Runnable() {
			 @Override
			 public void run() {
			        // �g�[�X�g���o���B
			        Toast myToast = Toast.makeText(
			            context, "Hello, How are you?",
			            Toast.LENGTH_SHORT);
			        myToast.show();
			      }
			    });
			  }
			}

