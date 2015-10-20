package com.njb.test.audio;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayActivity extends Activity {

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
		Uri uri = Uri.parse("http://ziran-yun-test001.d.wcsapi.biz.matocloud.com/720p.mp4");
		VideoView videoView = (VideoView) this.findViewById(R.id.video_view);
		videoView.setMediaController(new MediaController(this));
		videoView.setVideoURI(uri);
		videoView.start();
		videoView.requestFocus();
	}
}