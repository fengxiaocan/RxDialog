package com.app.dialoglib;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;

public class RxInputDialog extends RxDialog {

    protected RxInputViewHolder viewHolder;
    protected boolean isShowLeft = false;
    protected boolean isShowRight = false;
    protected boolean isShowMiddle = false;

    public RxInputDialog(Context context) {
        super(context);
        layout = LayoutInflater.from(context).inflate(R.layout.layout_rx_input_dialog, null);
        dialog.setContentView(layout);
        viewHolder = new RxInputViewHolder(layout);
        noBackground();
    }

    @Override
    protected float widthPercent() {
        return 0.76f;
    }

    public static RxInputDialog with(Context context) {
        return new RxInputDialog(context);
    }

    @Override
    public void show() {
        if (isShowLeft) {
            if (isShowRight) {
                if (isShowMiddle) {
                    showView(viewHolder.line1);
                    showView(viewHolder.line2);
                } else {
                    showView(viewHolder.line1);
                    hideView(viewHolder.line2);
                    hideView(viewHolder.middleButton);
                }
            } else {
                if (isShowMiddle) {
                    showView(viewHolder.line1);
                    hideView(viewHolder.line2);
                } else {
                    hideView(viewHolder.line1);
                    hideView(viewHolder.line2);
                }
            }
        } else {
            if (isShowRight) {
                if (isShowMiddle) {
                    hideView(viewHolder.line1);
                    showView(viewHolder.line2);
                } else {
                    hideView(viewHolder.line1);
                    hideView(viewHolder.line2);
                }
            } else {
                if (isShowMiddle) {
                    hideView(viewHolder.line1);
                    hideView(viewHolder.line2);
                    hideView(viewHolder.leftButton);
                    hideView(viewHolder.rightButton);
                } else {
                    hideView(viewHolder.line1);
                    hideView(viewHolder.line2);
                }
            }
        }
        super.show();
        viewHolder.message.requestFocus();
    }

    public RxInputDialog leftButton(CharSequence title) {
        isShowLeft = true;
        viewHolder.leftButton.setVisibility(View.VISIBLE);
        viewHolder.leftButton.setText(title);
        return this;
    }

    public RxInputDialog middleButton(CharSequence title) {
        isShowMiddle = true;
        viewHolder.middleButton.setVisibility(View.VISIBLE);
        viewHolder.middleButton.setText(title);
        return this;
    }

    public RxInputDialog rightButton(CharSequence title) {
        isShowRight = true;
        viewHolder.rightButton.setVisibility(View.VISIBLE);
        viewHolder.rightButton.setText(title);
        return this;
    }

    public RxInputDialog leftListener(final OnDialogButtonClickListener listener) {
        viewHolder.leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (listener instanceof OnInputResultListener) {
                        ((OnInputResultListener) listener).onResult(viewHolder.message.getText());
                    }
                    listener.onClickButton(dialog);
                } else {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxInputDialog middleListener(final OnDialogButtonClickListener listener) {
        viewHolder.middleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (listener instanceof OnInputResultListener) {
                        ((OnInputResultListener) listener).onResult(viewHolder.message.getText());
                    }
                    listener.onClickButton(dialog);
                } else {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxInputDialog rightListener(final OnDialogButtonClickListener listener) {
        viewHolder.rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (listener instanceof OnInputResultListener) {
                        ((OnInputResultListener) listener).onResult(viewHolder.message.getText());
                    }
                    listener.onClickButton(dialog);
                } else {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxInputDialog leftButton(@StringRes int res) {
        isShowLeft = true;
        viewHolder.leftButton.setVisibility(View.VISIBLE);
        viewHolder.leftButton.setText(res);
        return this;
    }

    public RxInputDialog middleButton(@StringRes int res) {
        isShowMiddle = true;
        viewHolder.middleButton.setVisibility(View.VISIBLE);
        viewHolder.middleButton.setText(res);
        return this;
    }

    public RxInputDialog rightButton(@StringRes int res) {
        isShowRight = true;
        viewHolder.rightButton.setVisibility(View.VISIBLE);
        viewHolder.rightButton.setText(res);
        return this;
    }

    public RxInputDialog leftButtonTextColorRes(@ColorRes int res) {
        viewHolder.leftButton.setTextColor(layout.getResources().getColor(res));
        return this;
    }

    public RxInputDialog middleButtonTextColorRes(@ColorRes int res) {
        viewHolder.middleButton.setTextColor(layout.getResources().getColor(res));
        return this;
    }

    public RxInputDialog rightButtonTextColorRes(@ColorRes int res) {
        viewHolder.rightButton.setTextColor(layout.getResources().getColor(res));
        return this;
    }

    public RxInputDialog leftButtonTextColor(int color) {
        viewHolder.leftButton.setTextColor(color);
        return this;
    }

    public RxInputDialog middleButtonTextColor(int color) {
        viewHolder.middleButton.setTextColor(color);
        return this;
    }

    public RxInputDialog rightButtonTextColor(int color) {
        viewHolder.rightButton.setTextColor(color);
        return this;
    }

    public RxInputDialog leftButtonTextColor(ColorStateList color) {
        viewHolder.leftButton.setTextColor(color);
        return this;
    }

    public RxInputDialog middleButtonTextColor(ColorStateList color) {
        viewHolder.middleButton.setTextColor(color);
        return this;
    }

    public RxInputDialog rightButtonTextColor(ColorStateList color) {
        viewHolder.rightButton.setTextColor(color);
        return this;
    }

    public RxInputDialog leftButtonBackgroundResource(@DrawableRes int color) {
        viewHolder.leftButton.setBackgroundResource(color);
        return this;
    }

    public RxInputDialog middleButtonBackgroundResource(@DrawableRes int color) {
        viewHolder.middleButton.setBackgroundResource(color);
        return this;
    }

    public RxInputDialog rightButtonBackgroundResource(@DrawableRes int color) {
        viewHolder.rightButton.setBackgroundResource(color);
        return this;
    }

    public RxInputDialog leftButtonBackgroundColor(int color) {
        viewHolder.leftButton.setBackgroundColor(color);
        return this;
    }

    public RxInputDialog middleButtonBackgroundColor(int color) {
        viewHolder.middleButton.setBackgroundColor(color);
        return this;
    }

    public RxInputDialog rightButtonBackgroundColor(int color) {
        viewHolder.rightButton.setBackgroundColor(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxInputDialog leftButtonBackground(Drawable background) {
        viewHolder.leftButton.setBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxInputDialog middleButtonBackground(Drawable background) {
        viewHolder.middleButton.setBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxInputDialog rightButtonBackground(Drawable background) {
        viewHolder.rightButton.setBackground(background);
        return this;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxInputDialog leftButtonBackgroundTintList(ColorStateList color) {
        viewHolder.leftButton.setBackgroundTintList(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxInputDialog middleButtonBackgroundTintList(ColorStateList color) {
        viewHolder.middleButton.setBackgroundTintList(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxInputDialog rightButtonBackgroundTintList(ColorStateList color) {
        viewHolder.rightButton.setBackgroundTintList(color);
        return this;
    }

    public RxInputDialog titleGravity(int gravity) {
        viewHolder.title.setGravity(gravity);
        return this;
    }

    public RxInputDialog messageGravity(int gravity) {
        viewHolder.message.setGravity(gravity);
        return this;
    }

    @Override
    public RxInputDialog title(CharSequence title) {
        viewHolder.title.setVisibility(View.VISIBLE);
        viewHolder.title.setText(title);
        return this;
    }

    @Override
    public RxInputDialog title(int title) {
        viewHolder.title.setVisibility(View.VISIBLE);
        viewHolder.title.setText(title);
        return this;
    }

    public RxInputDialog titleTextColor(int color) {
        viewHolder.title.setTextColor(color);
        return this;
    }

    public RxInputDialog titleTextColorResource(@ColorRes int color) {
        viewHolder.title.setTextColor(layout.getResources().getColor(color));
        return this;
    }

    public RxInputDialog titleTextColor(ColorStateList colors) {
        viewHolder.title.setTextColor(colors);
        return this;
    }

    public RxInputDialog messageMaxLenght(int maxLenght) {
        viewHolder.message.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLenght)});
        return this;
    }

    public RxInputDialog message(CharSequence title) {
        viewHolder.message.setText(title);
        return this;
    }

    public RxInputDialog messageHint(CharSequence title) {
        viewHolder.message.setHint(title);
        return this;
    }

    public RxInputDialog messageSelection(int index) {
        viewHolder.message.setSelection(index);
        return this;
    }

    public RxInputDialog messageSelectionEnd() {
        viewHolder.message.setSelection(viewHolder.message.length());
        return this;
    }

    public RxInputDialog message(int title) {
        viewHolder.message.setText(title);
        return this;
    }

    public RxInputDialog messageHint(int title) {
        viewHolder.message.setHint(title);
        return this;
    }

    public RxInputDialog messageTextColor(int color) {
        viewHolder.message.setTextColor(color);
        return this;
    }

    public RxInputDialog messageHintTextColor(int color) {
        viewHolder.message.setHintTextColor(color);
        return this;
    }

    public RxInputDialog messageTextColorResource(@ColorRes int color) {
        viewHolder.message.setTextColor(layout.getResources().getColor(color));
        return this;
    }

    public RxInputDialog messageTextColor(ColorStateList colors) {
        viewHolder.message.setTextColor(colors);
        return this;
    }

    public RxInputDialog messageHintTextColorResource(@ColorRes int color) {
        viewHolder.message.setHintTextColor(layout.getResources().getColor(color));
        return this;
    }

    public RxInputDialog messageHintTextColor(ColorStateList colors) {
        viewHolder.message.setHintTextColor(colors);
        return this;
    }

    public RxInputDialog layoutBackgroundColor(@ColorInt int color) {
        viewHolder.alertContainer.setCardBackgroundColor(color);
        return this;
    }

    public RxInputDialog bottomLayoutBackgroundColor(@ColorInt int color) {
        viewHolder.alertBottom.setBackgroundColor(color);
        return this;
    }

    public RxInputDialog bottomLayoutBackgroundResource(@DrawableRes int resid) {
        viewHolder.alertBottom.setBackgroundResource(resid);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxInputDialog bottomLayoutBackgroundTintList(@Nullable ColorStateList tint) {
        viewHolder.alertBottom.setBackgroundTintList(tint);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxInputDialog bottomLayoutBackground(Drawable background) {
        viewHolder.alertBottom.setBackground(background);
        return this;
    }

    public RxInputDialog lineColor(int color) {
        viewHolder.line0.setBackgroundColor(color);
        viewHolder.line1.setBackgroundColor(color);
        viewHolder.line2.setBackgroundColor(color);
        return this;
    }

    private void hideView(View view) {
        view.setVisibility(View.GONE);
    }

    private void showView(View view) {
        view.setVisibility(View.VISIBLE);
    }

    public RxInputViewHolder getViewHolder() {
        return viewHolder;
    }

    public TextView getTitleView() {
        return viewHolder.title;
    }

    public TextView getMessageView() {
        return viewHolder.message;
    }

    public TextView getLeftButton() {
        return viewHolder.leftButton;
    }

    public TextView getRightButton() {
        return viewHolder.rightButton;
    }

    public TextView getMiddleButton() {
        return viewHolder.middleButton;
    }
}
