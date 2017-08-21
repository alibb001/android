package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/**
 * 
 * @author Sunny
 * @contact qq交流群：android达人（121169081） Mar 22, 2014
 */
public class DrawableUtils {
	/**
	 * 
	 * @param context
	 *            上下文
	 * @param paramDrawableUpId
	 *            popwindow向下弹出时的背景图
	 * @param paramDrableBelowId
	 *            popwindow向上弹出时的背景图
	 * @return
	 */
	public static StateListDrawable getPopUpListDrawable(Context context, int paramDrawableUpId, int paramDrableBelowId) {
		StateListDrawable localStateListDrawable = new StateListDrawable();
		Drawable blow = context.getResources().getDrawable(paramDrableBelowId);
		Drawable above = context.getResources().getDrawable(paramDrawableUpId);
		localStateListDrawable.addState(new int[] { android.R.attr.state_above_anchor }, above);
		localStateListDrawable.addState(new int[] {}, blow);
		return localStateListDrawable;
	}
}
