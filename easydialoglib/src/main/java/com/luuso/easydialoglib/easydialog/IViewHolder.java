package com.luuso.easydialoglib.easydialog;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;

/**
 * @project： NiceDialog
 * @package： com.timotech.watch.child.nicedialog.easydialog
 * @class: IViewHolder
 * @author: 陆伟
 * @Date: 2017/9/5 12:29
 * @desc： TODO
 */

public interface IViewHolder {

    public View getRootView();

    public <T extends View> T getView(int viewId);

    IViewHolder setOnClickListener(View.OnClickListener listener, int... ids);

    public IViewHolder setBackgroundColor(int viewId, int color);

    public IViewHolder setBackground(int viewId, Drawable drawable);

    public IViewHolder setBackgroundResource(int viewId, @DrawableRes int resId);

    public IViewHolder setText(int viewId, CharSequence text);

    public IViewHolder setText(int viewId, @StringRes int resId);

    public IViewHolder setTextColor(int viewId, int color);

    public IViewHolder setTextColor(int viewId, ColorStateList colors);

    public IViewHolder setImage(int viewId, Bitmap bm);

    public IViewHolder setImage(int viewId, Drawable drawable);

    public IViewHolder setImage(int viewId, @DrawableRes int resId);
}
