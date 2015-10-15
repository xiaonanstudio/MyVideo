package com.njb.test.audio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final long OUT_TIME = 2000;
	private long mTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onLaunchWebActivity(View view) {
		startActivity(new Intent(this, WebActivity.class));
	}

	public void onBtnClick(View view) {
		startActivity(new Intent(this, WebActivity.class));
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
			if (System.currentTimeMillis() - mTime > OUT_TIME) {
				mTime = System.currentTimeMillis();
				Toast.makeText(this, "One more click to exit.", Toast.LENGTH_SHORT).show();
			} else {
				finish();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
