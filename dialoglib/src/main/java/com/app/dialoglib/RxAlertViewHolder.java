package com.app.dialoglib;

import android.view.View;
import android.widget.TextView;

import com.evil.rlayout.RoundLinearLayout;

class RxAlertViewHolder {
    public TextView title;
    public TextView message;
    public TextView leftButton;
    public View line1;
    public TextView middleButton;
    public View line2;
    public TextView rightButton;
    public RoundLinearLayout rlayoutBottom;
    public RoundLinearLayout llayoutAlert;

    RxAlertViewHolder(View rootView) {
        this.title = rootView.findViewById(R.id.title);
        this.message = rootView.findViewById(R.id.message);
        this.leftButton = rootView.findViewById(R.id.left_button);
        this.line1 = rootView.findViewById(R.id.line1);
        this.middleButton = rootView.findViewById(R.id.middle_button);
        this.line2 = rootView.findViewById(R.id.line2);
        this.rightButton = rootView.findViewById(R.id.right_button);
        this.rlayoutBottom = rootView.findViewById(R.id.rlayout_bottom);
        this.llayoutAlert = rootView.findViewById(R.id.llayout_alert);
    }
}
