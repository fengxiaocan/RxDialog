package com.app.dialoglib;

import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class RxAlertViewHolder {
    public TextView title;
    public TextView message;
    public View line0;
    public TextView leftButton;
    public View line1;
    public TextView middleButton;
    public View line2;
    public TextView rightButton;
    public LinearLayout alertBottom;
    public LinearLayout alertLayout;
    public CardView alertContainer;

    public RxAlertViewHolder(Dialog rootView) {
        title = rootView.findViewById(R.id.alert_title);
        message = rootView.findViewById(R.id.alert_message);
        line0 = rootView.findViewById(R.id.line0);
        leftButton = rootView.findViewById(R.id.left_button);
        line1 = rootView.findViewById(R.id.line1);
        middleButton = rootView.findViewById(R.id.middle_button);
        line2 = rootView.findViewById(R.id.line2);
        rightButton = rootView.findViewById(R.id.right_button);
        alertBottom = rootView.findViewById(R.id.alert_bottom);
        alertLayout = rootView.findViewById(R.id.alert_layout);
        alertContainer = rootView.findViewById(R.id.alert_container);
    }
}
