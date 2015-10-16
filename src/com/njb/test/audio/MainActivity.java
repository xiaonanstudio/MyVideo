package com.njb.test.audio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.njb.test.audio.model.MyConst;

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
		Intent intent = new Intent(this, VideoListActivity.class);
		switch (view.getId()) {
		case R.id.btn_news:
			intent.putExtra(MyConst.TITLE, "权健新闻");
			intent.putExtra(MyConst.NAME_LIST, new String[] { "权健新闻 2015.10.17", "权健新闻 2015.10.17", "权健新闻 2015.9.17",
					"权健新闻 2015.9.17", "权健新闻 2015.10.1", "权健新闻 2015.10.1" });
			intent.putExtra(
					MyConst.URL_LIST,
					new String[] {
							"http://quanjiantv.com/quanjian/meizhouxinwen/2015/1015/28.html",
							"http://www.CuPlayer.com/player/player.swf?JcScpVideoPath=http://wany.s.wcsapi.biz.matocloud.com/jianxinwen 3 2015.10.17.flv",
							"http://quanjiantv.com/quanjian/meizhouxinwen/2015/0917/16.html",
							"http://quanjiantv.com/quanjian/meizhouxinwen/2015/0917/16.html",
							"http://quanjiantv.com/quanjian/meizhouxinwen/2015/0930/26.html",
							"http://www.CuPlayer.com/player/player.swf?JcScpVideoPath=http://wany.s.wcsapi.biz.matocloud.com/quanjinanxinwen-2-2015.10.1.flv" });
			break;

		default:
			Toast.makeText(this, "I am working hard to develop ...", Toast.LENGTH_SHORT).show();
		}
		startActivity(intent);
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
