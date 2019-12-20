package com.app.dialoglib;

import android.app.Dialog;

public abstract class OnInputResultListener implements OnDialogButtonClickListener {
    @Override
    public void onClickButton(Dialog dialog) {
        dialog.dismiss();
    }

    public abstract void onResult(CharSequence sequence);
}
