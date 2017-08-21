package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class MainActivity extends Activity {
	private Context context = this;
	private PopupWindow mPopupWindowFirst;
	private PopupWindow mPopupWindowSecond;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/**
	 * 第一个button点击事件，弹出下方够位置的popwindow
	 * 
	 * @param v
	 */
	public void btn_first_click(final View v) {
		final List<String> localList = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			localList.add("欢迎加" + i);
		}
		PopAdapter localAdapter = new PopAdapter(context, localList, "欢迎加");

		OnItemClickListener localOnItemClickListener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> view, View arg1, int position, long arg3) {
				Toast.makeText(context, localList.get(position), Toast.LENGTH_SHORT).show();
				if (mPopupWindowFirst != null && mPopupWindowFirst.isShowing()) {
					mPopupWindowFirst.dismiss();
				}
			}
		};

		mPopupWindowFirst = PopWindowUtils.showListPopWindow(context, R.layout.pop_list_layout, v,
				localOnItemClickListener, localAdapter, localList.size(), 0);
	}

	/**
	 * 第二个button点击事件，弹出下方不够位置的popwindow
	 * 
	 * @param v
	 */
	public void btn_second_click(View v) {
		final List<String> localList = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			localList.add("欢迎" + i);
		}
		PopAdapter localAdapter = new PopAdapter(context, localList, "欢迎加入android达人（121169081)----6");

		OnItemClickListener localOnItemClickListener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> view, View arg1, int position, long arg3) {
				Toast.makeText(context, localList.get(position), Toast.LENGTH_SHORT).show();
				if (mPopupWindowSecond != null && mPopupWindowSecond.isShowing()) {
					mPopupWindowSecond.dismiss();
				}
			}
		};

		mPopupWindowSecond = PopWindowUtils.showListPopWindow(context, R.layout.pop_list_layout, v,
				localOnItemClickListener, localAdapter, 6, 0);
	}
}
