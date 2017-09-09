package com.luuso.easydialoglib.easydialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @project： NiceDialog
 * @package： com.timotech.watch.child.nicedialog
 * @class: EasyDialog
 * @author: 陆伟
 * @Date: 2017/9/5 12:08
 * @desc： TODO
 */

public class EasyDialog extends BaseEasyDialog {
    private static final String KEY_LAYOUT_ID = "layoutId";

    private int mLayoutId;

    public static IEasyDialog newDialog(int layoutId) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_LAYOUT_ID, layoutId);
        BaseEasyDialog easyDialog = new EasyDialog();
        easyDialog.setArguments(bundle);
        return easyDialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            mLayoutId = getArguments().getInt(KEY_LAYOUT_ID);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return this.mLayoutId;
    }
}
