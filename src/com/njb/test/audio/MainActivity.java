package com.njb.test.audio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.njb.test.audio.model.MyConst;

public class MainActivity extends Activity {
	private static final long OUT_TIME = 2000;
	private static final long LEGAL_TIME = 1000 * 60 * 60 * 24 * 7;

	private long mTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SharedPreferences sp = getSharedPreferences(MyConst.SP, Context.MODE_PRIVATE);

		Log.i(MyConst.TAG, "timenew:" + System.currentTimeMillis());
		Log.i(MyConst.TAG, "timeold:" + sp.getLong(MyConst.LEGAL_TIME, -1));

		if (sp.contains(MyConst.LEGAL_TIME)) {
			if (System.currentTimeMillis() - sp.getLong(MyConst.LEGAL_TIME, Long.valueOf("1445435710252")) > LEGAL_TIME) {
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Out Of Time");
				builder.setMessage("The application can be used in 7 days, it is out of time now, please pay for it.");
				builder.setPositiveButton("OK", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				});
				builder.create().show();
			}
		} else {
			sp.edit().putLong(MyConst.LEGAL_TIME, System.currentTimeMillis()).commit();
		}
	}

	public void onLaunchWebActivity(View view) {
		startActivity(new Intent(this, WebActivity.class));
	}

	public void onBtnClick(View view) {
		Intent intent = new Intent(this, VideoListActivity.class);
		switch (view.getId()) {
		case R.id.btn_news:
			intent.putExtra(MyConst.TITLE, "权健新闻");
			intent.putExtra(MyConst.NAME_LIST, new String[] { "权健新闻 2015.10.17", "权健新闻 2015.10.1", "权健新闻 2015.9.17" });
			intent.putExtra(MyConst.URL_LIST, new String[] { "http://quanjiantv.s.wcsapi.biz.matocloud.com/A12.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/A11.mp4",
					"http://ziran-yun-test001.d.wcsapi.biz.matocloud.com/720p.mp4" });
			break;

		case R.id.btn_liveroom:
			intent = new Intent(this, LivingActivity.class);
			break;

		case R.id.btn_culture:
			intent.putExtra(MyConst.TITLE, "权健文化");
			intent.putExtra(MyConst.NAME_LIST, new String[] { "走进权健", "2014年权健大事记", "30秒企业简介" });
			intent.putExtra(MyConst.URL_LIST, new String[] { "http://quanjiantv.s.wcsapi.biz.matocloud.com/A15.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/A02.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/A01.mp4" });
			break;

		case R.id.btn_meetings:
			intent.putExtra(MyConst.TITLE, "权健会议集锦");
			intent.putExtra(MyConst.NAME_LIST, new String[] { "权健十一周年庆典", "权健战略委员会2015宝岛豪华之旅研讨会", "束总做客《参与》栏目",
					"2015壮行会束总专访", "权健十周年庆典", "权健十一周年精彩瞬间", "权健并购松江足球俱乐部新闻发布会" });
			intent.putExtra(MyConst.URL_LIST, new String[] { "http://quanjiantv.s.wcsapi.biz.matocloud.com/A09.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/bdy.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/A14.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/A03.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/A10.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/A08.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/sjfbh.mp4" });
			break;

		case R.id.btn_products:
			intent.putExtra(MyConst.TITLE, "权健产品");
			intent.putExtra(MyConst.NAME_LIST, new String[] { "权健活酵", "权健亲亲水", "权健综合治疗仪" });
			intent.putExtra(MyConst.URL_LIST, new String[] { "http://quanjiantv.s.wcsapi.biz.matocloud.com/A07.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/qqs.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/A13.mp4" });
			break;

		case R.id.btn_story:
			intent.putExtra(MyConst.TITLE, "权健人自己的故事");
			intent.putExtra(MyConst.NAME_LIST, new String[] { "讲述权健人自己的故事 朱晶 2015.10.17", "讲述权健人自己的故事 董惠菡 2015.10.1",
					"讲述权健人自己的故事 徐宝娟 2015.9.17" });
			intent.putExtra(MyConst.URL_LIST, new String[] { "http://quanjiantv.s.wcsapi.biz.matocloud.com/A06.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/A04.mp4",
					"http://quanjiantv.s.wcsapi.biz.matocloud.com/A05.mp4" });
			break;

		case R.id.btn_hospital:
			intent.putExtra(MyConst.TITLE, "权健肿瘤医院");
			break;

		case R.id.btn_health:
			intent.putExtra(MyConst.TITLE, "权健健康讲堂");
			intent.putExtra(MyConst.NAME_LIST, new String[] { "《中华医药》束总谈秘方" });
			intent.putExtra(MyConst.URL_LIST, new String[] { "http://quanjiantv.s.wcsapi.biz.matocloud.com/jkgs.mp4" });
			break;

		case R.id.btn_relatives:
			intent.putExtra(MyConst.TITLE, "权健一家亲");
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
