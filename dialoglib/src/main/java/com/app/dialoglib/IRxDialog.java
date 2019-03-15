package com.app.dialoglib;

import android.content.Context;
import android.view.View;
import android.view.Window;

interface IRxDialog {
     View getLayout();

     void show();

     void dismiss();

     Window getWindow();

     Context getContext();
}
