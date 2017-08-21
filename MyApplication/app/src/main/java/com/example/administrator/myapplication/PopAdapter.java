package com.example.administrator.myapplication;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 
 * @author Sunny
 * @contact qq交流群：android达人（121169081） Mar 22, 2014
 */
public class PopAdapter extends BaseAdapter {
	private LayoutInflater mLayoutInflater;
	private Context mContext;
	private List<String> mList;
	private String mChooseString;

	public PopAdapter(Context context, List<String> paramList, String paramChoosedItem) {
		this.mLayoutInflater = LayoutInflater.from(context);
		this.mContext = context;
		this.mList = paramList;
		this.mChooseString = paramChoosedItem;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHoldPop mViewHoldPop;
		if (convertView == null) {
			mViewHoldPop = new ViewHoldPop();
			convertView = mLayoutInflater.inflate(R.layout.item_pop_layout, null);
			mViewHoldPop.tv_item_content = (TextView) convertView.findViewById(R.id.tv_item_content);
			mViewHoldPop.view_line = (View) convertView.findViewById(R.id.view_line);

			convertView.setTag(mViewHoldPop);
		} else {
			mViewHoldPop = (ViewHoldPop) convertView.getTag();
		}
		String localString = mList.get(position);
		mViewHoldPop.tv_item_content.setText(localString);
//		if (localString.equals(mChooseString)) {
//			mViewHoldPop.tv_item_content.setTextColor(mContext.getResources().getColor(R.color.little_blue));
//		} else {
//			mViewHoldPop.tv_item_content.setTextColor(mContext.getResources().getColor(R.color.little_white));
//		}
		if (position == mList.size() - 1) {// 最后一项
			mViewHoldPop.view_line.setVisibility(View.GONE);
		} else {
			mViewHoldPop.view_line.setVisibility(View.VISIBLE);
		}

		return convertView;
	}

	class ViewHoldPop {
		TextView tv_item_content;
		View view_line;
	}

}
