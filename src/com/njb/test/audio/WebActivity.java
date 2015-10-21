package com.njb.test.audio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;

/**
 * 
 * @author XiaoNan
 * 
 * @see xiaonanstudio@163.com
 */
public class WebActivity extends Activity {
	private WebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		mWebView = (WebView) findViewById(R.id.webview);
		mWebView.setFocusable(true);
		mWebView.requestFocus();

		WebSettings webSettings = mWebView.getSettings();
		webSettings.setPluginState(PluginState.ON);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setUseWideViewPort(true);
		webSettings.setSupportZoom(false);
		webSettings.setLoadWithOverviewMode(true);

		// mWebView.loadUrl("http://down.233.com/2013_2014/2014/cy/kuaijijichu_jingjiang_quanguoban_ldd/1_zirf6m9fk2wtjhp2ya21rzwtucmtjd51lrq520jv.mp4");
		mWebView.loadUrl("http://quanjiantv.com/index.html");
		// mWebView.loadUrl("http://v.youku.com/v_show/id_XMjU5ODMyMTMy.html");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
			if (mWebView.canGoBack()) {
				mWebView.goBack();
			} else {
				finish();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void onTestA(View view) {
		startActivity(new Intent(this, TestA.class));
	}

	public void onTestB(View view) {
		startActivity(new Intent(this, TestB.class));
	}
}
