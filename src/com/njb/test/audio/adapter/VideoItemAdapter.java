package com.njb.test.audio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.njb.test.audio.R;

public class VideoItemAdapter extends BaseAdapter {

	private Context mContext;
	private String[] mTitles;

	public VideoItemAdapter(Context context, String[] titles) {
		mContext = context;
		mTitles = titles;
	}

	@Override
	public int getCount() {
		return mTitles == null ? 0 : mTitles.length;
	}

	@Override
	public Object getItem(int position) {
		return mTitles[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_video, null);
			((TextView) convertView.findViewById(R.id.item_video_name)).setText((String) getItem(position));
		}
		return convertView;
	}

}
