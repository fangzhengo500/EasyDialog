package com.luuso.easydialoglib.easydialog;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @project： NiceDialog
 * @package： com.timotech.watch.child.nicedialog.easydialog
 * @class: ViewHolder
 * @author: 陆伟
 * @Date: 2017/9/5 14:26
 * @desc： TODO
 */

public class ViewHolder implements IViewHolder {
    private final View mRootView;
    private final SparseArray<View> mViews;

    public ViewHolder(View rootView) {
        this.mRootView = rootView;
        this.mViews = new SparseArray<>(8); //一般不会超过8个吧
    }

    @Override
    public View getRootView() {
        return this.mRootView;
    }

    @Override
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mRootView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    @Override
    public IViewHolder setOnClickListener(View.OnClickListener listener, int... ids) {
        if (ids == null || ids.length <= 0) {
            return this;
        }

        for (int id : ids) {
            getView(id).setOnClickListener(listener);
        }
        return this;
    }

    @Override
    public IViewHolder setBackground(int viewId, Drawable drawable) {
        try {
            View view = getView(viewId);
            view.setBackground(drawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public IViewHolder setBackgroundColor(int viewId, int color) {
        try {
            View view = getView(viewId);
            view.setBackgroundColor(color);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public IViewHolder setBackgroundResource(int viewId, @DrawableRes int resId) {
        try {
            View view = getView(viewId);
            view.setBackgroundResource(resId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public IViewHolder setText(int viewId, CharSequence text) {
        try {
            View view = getView(viewId);
            ((TextView) view).setText(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public IViewHolder setText(int viewId, @StringRes int resId) {
        try {
            View view = getView(viewId);
            ((TextView) view).setText(resId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }


    @Override
    public IViewHolder setTextColor(int viewId, int color) {
        try {
            View view = getView(viewId);
            ((TextView) view).setTextColor(color);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public IViewHolder setTextColor(int viewId, ColorStateList colors) {
        try {
            View view = getView(viewId);
            ((TextView) view).setTextColor(colors);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }


    @Override
    public IViewHolder setImage(int viewId, @DrawableRes int resId) {
        try {
            View view = getView(viewId);
            ((ImageView) view).setImageResource(resId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public IViewHolder setImage(int viewId, Bitmap bm) {
        try {
            View view = getView(viewId);
            ((ImageView) view).setImageBitmap(bm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public IViewHolder setImage(int viewId, Drawable drawable) {
        try {
            View view = getView(viewId);
            ((ImageView) view).setImageDrawable(drawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}
