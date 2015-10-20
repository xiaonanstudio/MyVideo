package com.njb.test.audio;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public abstract class TestActivity extends Activity implements Handler.Callback {
	private TextView mTextView;
	private View mLayout;
	private Handler mHandler;

	abstract String getOrientation();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_test);
		super.onCreate(savedInstanceState);

		mTextView = (TextView) findViewById(R.id.tv_test_info);
		mLayout = findViewById(R.id.layout_holder);

		mHandler = new Handler(this);
		mHandler.sendEmptyMessageDelayed(10202134, 2000);
	}

	@Override
	public boolean handleMessage(Message msg) {
		StringBuffer sb = new StringBuffer();
		sb.append("Orientation: ").append(getOrientation()).append("\n\n");

		sb.append("LayoutWidth: ").append(mLayout.getWidth()).append("\n");
		sb.append("LayoutHeight: ").append(mLayout.getHeight()).append("\n\n");

		Point point = new Point();
		getWindowManager().getDefaultDisplay().getSize(point);
		sb.append("DisplayWidth: ").append(point.x).append("\n");
		sb.append("DisplayHeight: ").append(point.y).append("\n\n");

		DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
		sb.append("MetricsWidth: ").append(displayMetrics.widthPixels).append("\n");
		sb.append("MetricsHeight: ").append(displayMetrics.heightPixels).append("\n");
		sb.append("MetricsDensity: ").append(displayMetrics.density).append("\n");
		mTextView.setText(sb);
		return true;
	}
}
