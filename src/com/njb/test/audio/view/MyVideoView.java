package com.njb.test.audio.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.WindowManager;
import android.widget.VideoView;

import com.njb.test.audio.model.MyConst;

public class MyVideoView extends VideoView {

	private WindowManager mWinMgr;
	private Point mPoint;

	public MyVideoView(Context context) {
		this(context, null);
	}

	public MyVideoView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyVideoView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mWinMgr = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		mPoint = new Point();
		mWinMgr.getDefaultDisplay().getSize(mPoint);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Log.i(MyConst.TAG, "widthMeasureSpec: " + widthMeasureSpec + " heightMeasureSpec:" + heightMeasureSpec);
		Log.i(MyConst.TAG,
				"getDefaultSizeW: " + getDefaultSize(0, widthMeasureSpec) + " H:"
						+ getDefaultSize(0, heightMeasureSpec));
		Log.i(MyConst.TAG, "pointwidth: " + mPoint.x + " pointheight:" + mPoint.y);
		Log.i(MyConst.TAG, "pointwidth: " + (mPoint.x * 1.0 / widthMeasureSpec) + " pointheight:"
				+ (mPoint.y * 1.0 / heightMeasureSpec));
		setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
	}
}
