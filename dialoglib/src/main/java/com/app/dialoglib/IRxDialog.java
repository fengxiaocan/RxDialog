package com.app.dialoglib;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;

interface IRxDialog {
    Dialog getDialog();

    View getLayout();

    void show();

    void dismiss();

    Window getWindow();

    Context getContext();
}
