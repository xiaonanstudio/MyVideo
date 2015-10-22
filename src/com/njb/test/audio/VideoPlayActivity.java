package com.njb.test.audio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.MediaController;

import com.njb.test.audio.model.MyConst;
import com.njb.test.audio.view.MyVideoView;

/**
 * 
 * @author XiaoNan
 * 
 * @see xiaonanstudio@163.com
 */
public class VideoPlayActivity extends Activity implements Handler.Callback, MediaPlayer.OnPreparedListener {
	private static final int WHAT = 10222226;
	private Handler mHandler;
	private MyVideoView mVideoView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_videoplay);
		// http://wany.s.wcsapi.biz.matocloud.com/jianxinwen 3 2015.10.17.flv

		// rtmp://lv1.ts33.net:1935/tv/ttv03
		// rtmp://lv1.ts33.net:1935/tv/ttv04
		// rtmp://1011.lssplay.aodianyun.com/demo/monitor

		// http://down.233.com/2013_2014/2014/cy/kuaijijichu_jingjiang_quanguoban_ldd/1_zirf6m9fk2wtjhp2ya21rzwtucmtjd51lrq520jv.mp4
		// http://ziran-yun-test001.d.wcsapi.biz.matocloud.com/app01.mp4
		// http://ziran-yun-test001.d.wcsapi.biz.matocloud.com/1080p.mp4
		// http://ziran-yun-test001.d.wcsapi.biz.matocloud.com/720p.mp4
		Uri uri = Uri.parse(getIntent().getStringExtra(MyConst.URL));
		mVideoView = (MyVideoView) this.findViewById(R.id.video_view);
		mVideoView.setMediaController(new MediaController(this));
		mVideoView.setOnPreparedListener(this);

		mVideoView.setVideoURI(uri);
		mVideoView.start();
		mVideoView.requestFocus();

		mHandler = new Handler(this);
		mHandler.sendEmptyMessageDelayed(WHAT, 4000);
	}

	@Override
	public boolean handleMessage(Message msg) {
		switch (msg.what) {
		case WHAT:
			Log.i(MyConst.TAG,
					"VideoView width: " + mVideoView.getWidth() + " VideoView height:" + mVideoView.getHeight());
			break;

		default:
			return false;
		}
		return true;
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		Log.i(MyConst.TAG,
				"onPrepared >> getVideoWidth: " + mp.getVideoWidth() + " getVideoHeight:" + mp.getVideoHeight());
	}
}