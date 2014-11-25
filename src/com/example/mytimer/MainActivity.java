package com.example.mytimer;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.TaskStackBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Timer mTimer;
	Handler mHandler = new Handler();
	long mStart = 0;
	TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ウィジェット
		mTextView = (TextView)findViewById(R.id.textView1);
		
		// タイマー（定期実行）作成
		mStart = System.currentTimeMillis();
		mTimer = new Timer(true); // daemon
		mTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						long t = System.currentTimeMillis() - mStart;
						String s = "" + t;
						mTextView.setText(s);
					}
				});
			}
		}, 0, 10); // 0ミリ秒後に開始。10ミリ秒毎に実行
	}

}
