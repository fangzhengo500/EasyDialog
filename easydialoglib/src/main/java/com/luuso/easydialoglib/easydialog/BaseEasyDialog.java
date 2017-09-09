package com.luuso.easydialoglib.easydialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


import com.luuso.easydialoglib.R;

import java.io.Serializable;


/**
 * @project： NiceDialog
 * @package： com.timotech.watch.child.nicedialog
 * @class: BaseEasyDialog
 * @author: 陆伟
 * @Date: 2017/9/5 11:20
 * @desc： TODO
 */

public abstract class BaseEasyDialog extends DialogFragment implements IEasyDialog,
        IDialogContentListener {
    private static final String TAG = BaseEasyDialog.class.getSimpleName();

    private static final String KEY_CONFIG = "config";
    private static final String KEY_CONTENT_LISTENER = "content_listener";

    private Config mConfig;

    private IViewHolder mViewHolder;
    private IDialogContentListener contentListener;

    public BaseEasyDialog() {
        mConfig = new Config();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //Log.d(TAG, "onViewStateRestored: savedInstanceState = " + savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Log.d(TAG, "onSaveInstanceState: outState = " + outState);
        outState.putSerializable(KEY_CONFIG, mConfig);
        outState.putSerializable(KEY_CONTENT_LISTENER, contentListener);
    }

    protected abstract int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d(TAG, "onCreate: savedInstanceState = " + savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.EasyDialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //Log.d(TAG, "onCreateView: container = " + container + " savedInstanceState = " + savedInstanceState);
        if (savedInstanceState != null) {
            mConfig = (Config) savedInstanceState.getSerializable(KEY_CONFIG);
            contentListener = (IDialogContentListener) savedInstanceState.getSerializable(KEY_CONTENT_LISTENER);
        }
        View contentView = inflater.inflate(getLayoutId(), container, false);
        mViewHolder = new ViewHolder(contentView);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Log.d(TAG, "onViewCreated: view = " + view + " savedInstanceState = " + savedInstanceState);
        if (contentListener != null) {
            contentListener.bindView(this, mViewHolder);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }

        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = mConfig.width;
        layoutParams.height = mConfig.height;
        layoutParams.gravity = mConfig.gravity;
        layoutParams.dimAmount = mConfig.dimAmount;
//        layoutParams.verticalMargin = mConfig.verticalMargin;
//        layoutParams.horizontalMargin = mConfig.horizontalMargin;

        if (mConfig.windowAnimationStyleResId != Config.NULL_ANIMATION) {
            window.setWindowAnimations(mConfig.windowAnimationStyleResId);
        }
        window.setAttributes(layoutParams);
        window.setSoftInputMode(mConfig.softInputMode);
        getDialog().setCanceledOnTouchOutside(mConfig.outsideTouchCancel);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        dismiss();
    }

    @Override
    public void dismiss() {
        //当fragmentManager中没添加崩溃
        if (isAdded()) {
            return;
        }
        super.dismiss();
    }

    public void show(FragmentManager manager) {
        show(manager, null);
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        // 快速点击会直接崩溃
        if (isAdded()) {
            return;
        }
        super.show(manager, tag);
    }

    @Override
    public IEasyDialog setContentListener(IDialogContentListener contentListener) {
        this.contentListener = contentListener;
        return this;
    }

    @Override
    public IEasyDialog setOutsideTouchCancel(boolean outsideTouchCancel) {
        mConfig.outsideTouchCancel = outsideTouchCancel;
        return this;
    }

    @Override
    public IEasyDialog setWidth(int width) {
        mConfig.width = width;
        return this;
    }

    @Override
    public IEasyDialog setHeight(int height) {
        mConfig.height = height;
        return this;
    }

    @Override
    public IEasyDialog setGravity(int gravity) {
        mConfig.gravity = gravity;
        return this;
    }

    @Override
    public IEasyDialog setAnimationsStyle(@StyleRes int styleId) {
        mConfig.windowAnimationStyleResId = styleId;
        return this;
    }

    @Override
    public IEasyDialog setDimAmount(float dimAmount) {
        mConfig.dimAmount = dimAmount;
        return this;
    }

    @Override
    public IEasyDialog setSoftInputMode(int softInputMode) {
        mConfig.softInputMode = softInputMode;
        return this;
    }

//    @Override
//    public IEasyDialog setVerticalMargin(int verticalMargin) {
//        mConfig.verticalMargin = verticalMargin;
//        return this;
//    }
//
//    @Override
//    public IEasyDialog setHorizontalMargin(int horizontalMargin) {
//        mConfig.horizontalMargin = horizontalMargin;
//        return this;
//    }

    /**
     * Config 配置是在 {@link BaseEasyDialog#onStart()} 调用的，只有onStart后才生效
     */
    private static class Config implements Serializable {
        public static int NULL_ANIMATION = 0;

        //        public float verticalMargin;
//        public float horizontalMargin;
        int width = WindowManager.LayoutParams.WRAP_CONTENT;
        int height = WindowManager.LayoutParams.WRAP_CONTENT;

        /* 外部点击取消 */
        boolean outsideTouchCancel = true;

        /* gravity */
        int gravity = Gravity.CENTER;

        /* 动画 */
        @StyleRes
        int windowAnimationStyleResId = NULL_ANIMATION;

        /* 背景的不透明度 */
        float dimAmount = 0.5f;

        /**
         * @see {@link WindowManager.LayoutParams}
         */
        int softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
    }
}
