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
		// http://down.233.com/2013_2014/2014/cy/kuaijijichu_jingjiang_quanguoban_ldd/1_zirf6m9fk2wtjhp2ya21rzwtucmtjd51lrq520jv.mp4
		Uri uri = Uri
				.parse("http://down.233.com/2013_2014/2014/cy/kuaijijichu_jingjiang_quanguoban_ldd/1_zirf6m9fk2wtjhp2ya21rzwtucmtjd51lrq520jv.mp4");
		VideoView videoView = (VideoView) this.findViewById(R.id.video_view);
		videoView.setMediaController(new MediaController(this));
		videoView.setVideoURI(uri);
		videoView.start();
		videoView.requestFocus();
	}
}