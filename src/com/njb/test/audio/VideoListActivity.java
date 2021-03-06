package com.njb.test.audio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.njb.test.audio.adapter.VideoItemAdapter;
import com.njb.test.audio.model.MyConst;

/**
 * 
 * @author XiaoNan
 * 
 * @see xiaonanstudio@163.com
 */
public class VideoListActivity extends Activity implements AdapterView.OnItemClickListener {

	private GridView mGridView;
	private VideoItemAdapter mAdapter;

	private String[] mNameList;
	private String[] mUrlList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_videolist);
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		if (intent != null) {
			String title = intent.getStringExtra(MyConst.TITLE);
			if (title != null) {
				((TextView) findViewById(R.id.title)).setText(title);
			}

			mNameList = intent.getStringArrayExtra(MyConst.NAME_LIST);
			mUrlList = intent.getStringArrayExtra(MyConst.URL_LIST);
		}

		mAdapter = new VideoItemAdapter(this, mNameList);
		mGridView = (GridView) findViewById(R.id.gridview);
		mGridView.setAdapter(mAdapter);
		mGridView.setOnItemClickListener(this);
	}

	public void onBack(View view) {
		finish();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// Toast.makeText(this, mUrlList[position], Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, VideoPlayActivity.class);
		intent.putExtra(MyConst.URL, mUrlList[position]);
		startActivity(intent);
	}
}
