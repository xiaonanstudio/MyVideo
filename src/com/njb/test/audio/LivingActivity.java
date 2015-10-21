package com.njb.test.audio;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnBufferingUpdateListener;
import io.vov.vitamio.MediaPlayer.OnCompletionListener;
import io.vov.vitamio.MediaPlayer.OnPreparedListener;
import io.vov.vitamio.MediaPlayer.OnVideoSizeChangedListener;
import android.app.Activity;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.njb.test.audio.model.MyConst;

/**
 * 
 * @author XiaoNan
 * 
 * @see xiaonanstudio@163.com
 */
public class LivingActivity extends Activity implements OnBufferingUpdateListener, OnCompletionListener,
		OnPreparedListener, OnVideoSizeChangedListener, SurfaceHolder.Callback {

	private int mVideoWidth;
	private int mVideoHeight;
	private MediaPlayer mMediaPlayer;
	private SurfaceView mPreview;
	private SurfaceHolder holder;
	private String path;
	private boolean mIsVideoSizeKnown = false;
	private boolean mIsVideoReadyToBePlayed = false;

	/**
	 * 
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle icicle) {
		setContentView(R.layout.activity_living);
		super.onCreate(icicle);
		if (!LibsChecker.checkVitamioLibs(this)) {
			return;
		}
		mPreview = (SurfaceView) findViewById(R.id.surfaceview);
		holder = mPreview.getHolder();
		holder.addCallback(this);
		holder.setFormat(PixelFormat.RGBA_8888);
	}

	private void playVideo() {
		doCleanUp();
		try {
			path = "rtmp://1011.lssplay.aodianyun.com/demo/monitor";

			// Create a new media player and set the listeners
			Log.i(MyConst.TAG, path);
			mMediaPlayer = new MediaPlayer(this);
			mMediaPlayer.setDataSource(path);
			mMediaPlayer.setDisplay(holder);
			mMediaPlayer.prepareAsync();
			mMediaPlayer.setOnBufferingUpdateListener(this);
			mMediaPlayer.setOnCompletionListener(this);
			mMediaPlayer.setOnPreparedListener(this);
			mMediaPlayer.setOnVideoSizeChangedListener(this);
			setVolumeControlStream(AudioManager.STREAM_MUSIC);
		} catch (Exception e) {
			Log.e(MyConst.TAG, "error: " + e.getMessage(), e);
		}
	}

	public void onBufferingUpdate(MediaPlayer arg0, int percent) {
		Log.d(MyConst.TAG, "onBufferingUpdate percent:" + percent);
	}

	public void onCompletion(MediaPlayer arg0) {
		Log.d(MyConst.TAG, "onCompletion called");
	}

	public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
		Log.v(MyConst.TAG, "onVideoSizeChanged called");
		if (width == 0 || height == 0) {
			Log.e(MyConst.TAG, "invalid video width(" + width + ") or height(" + height + ")");
			return;
		}
		mIsVideoSizeKnown = true;
		mVideoWidth = width;
		mVideoHeight = height;
		if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
			startVideoPlayback();
		}
	}

	public void onPrepared(MediaPlayer mediaplayer) {
		Log.d(MyConst.TAG, "onPrepared called");
		mIsVideoReadyToBePlayed = true;
		if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
			startVideoPlayback();
		}
	}

	public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k) {
		Log.d(MyConst.TAG, "surfaceChanged called");

	}

	public void surfaceDestroyed(SurfaceHolder surfaceholder) {
		Log.d(MyConst.TAG, "surfaceDestroyed called");
	}

	public void surfaceCreated(SurfaceHolder holder) {
		Log.d(MyConst.TAG, "surfaceCreated called");
		playVideo();
	}

	@Override
	protected void onPause() {
		super.onPause();
		releaseMediaPlayer();
		doCleanUp();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		releaseMediaPlayer();
		doCleanUp();
	}

	private void releaseMediaPlayer() {
		if (mMediaPlayer != null) {
			mMediaPlayer.release();
			mMediaPlayer = null;
		}
	}

	private void doCleanUp() {
		mVideoWidth = 0;
		mVideoHeight = 0;
		mIsVideoReadyToBePlayed = false;
		mIsVideoSizeKnown = false;
	}

	private void startVideoPlayback() {
		Log.v(MyConst.TAG, "startVideoPlayback");
		holder.setFixedSize(mVideoWidth, mVideoHeight);
		mMediaPlayer.start();
	}
}
