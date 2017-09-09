package com.luuso.easydialoglib.easydialog;

import android.support.annotation.StyleRes;
import android.support.v4.app.FragmentManager;

/**
 * @project： NiceDialog
 * @package： com.timotech.watch.child.nicedialog.easydialog
 * @class: IEasyDialog
 * @author: 陆伟
 * @Date: 2017/9/5 12:23
 * @desc： TODO
 */

public interface IEasyDialog {
    public IEasyDialog setContentListener(IDialogContentListener listener);

    public IEasyDialog setOutsideTouchCancel(boolean outsideTouchCancel);

    public IEasyDialog setWidth(int width);

    public IEasyDialog setHeight(int height);

//    public IEasyDialog setVerticalMargin(int verticalMargin);
//
//    public IEasyDialog setHorizontalMargin(int horizontalMargin);

    /**
     * @param gravity {@link android.view.Gravity}
     */
    public IEasyDialog setGravity(int gravity);

    /**
     * 设置现实和隐藏动画style
     *
     * @param styleId
     */
    public IEasyDialog setAnimationsStyle(@StyleRes int styleId);

    /**
     * 不透明度
     *
     * @param dimAmount 0~1 0 全透明, 1 全黑
     */
    public IEasyDialog setDimAmount(float dimAmount);

    /**
     * @param softInputMode {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_NOTHING}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_PAN}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_RESIZE}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_UNSPECIFIED}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_IS_FORWARD_NAVIGATION}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_MASK_ADJUST}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_MASK_STATE}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_MODE_CHANGED}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_HIDDEN}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_VISIBLE}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_HIDDEN}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_UNCHANGED}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_UNSPECIFIED}
     *                      {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_VISIBLE}
     */
    public IEasyDialog setSoftInputMode(int softInputMode);

    public void show(FragmentManager fm);

    public void show(FragmentManager fm, String tag);
}
