package com.luuso.easydialoglib.easydialog;

import java.io.Serializable;

/**
 * @project： NiceDialog
 * @package： com.timotech.watch.child.nicedialog.easydialog
 * @class: IDialogContentListener
 * @author: 陆伟
 * @Date: 2017/9/5 12:17
 * @desc： TODO
 */

public interface IDialogContentListener extends Serializable {

    public void bindView(IEasyDialog dialog, IViewHolder viewHolder);
}
