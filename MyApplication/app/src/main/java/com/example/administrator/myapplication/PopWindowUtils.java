package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

/**
 * PopupWindow公共类
 * 
 * @author Sunny
 * @contact qq交流群：android达人（121169081） Mar 22, 2014
 */
public class PopWindowUtils {

	/**
	 * 
	 * @param context
	 * @param layoutId
	 *            布局文件
	 * @param paramView
	 *            点击控件
	 * @param paramOnItemClickListener
	 *            item点击事件
	 * @param paramAdapter
	 *            Adapter
	 * @param count
	 *            item个数
	 * @param yoff
	 *            y方向偏移量
	 * @return
	 */
	public static PopupWindow showListPopWindow(Context context, int layoutId, View paramView,
			OnItemClickListener paramOnItemClickListener, BaseAdapter paramAdapter, int count, int yoff) {
		LayoutInflater mInflater = LayoutInflater.from(context);
		View localView = mInflater.inflate(layoutId, null);
		ListView localListView = (ListView) localView.findViewById(R.id.lv_pop_list);
		localListView.setOnItemClickListener(paramOnItemClickListener);
		localListView.setAdapter(paramAdapter);
		PopupWindow localPopupWindow = new PopupWindow(localView, 400, paramView.getHeight() * count,
				true);
		localPopupWindow.setBackgroundDrawable(DrawableUtils.getPopUpListDrawable(context, R.mipmap.bg_white_round,
				R.mipmap.bg_white_top_open));// 设置弹出窗口的背景
		localListView.setTag(localPopupWindow);
		localPopupWindow.showAsDropDown(paramView, 0, yoff);
		localPopupWindow.update();

		return localPopupWindow;
	}

}
