package com.app.dialoglib;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class RxInputDialog extends RxDialog implements IDialogText<RxInputDialog>{

    protected RxInputViewHolder holder;
    protected DialogButtonControl control;

    public RxInputDialog(Context context) {
        super(context, R.layout.layout_rx_input_dialog);
        holder = new RxInputViewHolder(dialog);
        control = new DialogButtonControl(holder.title, holder.leftButton
                , holder.middleButton, holder.rightButton);
        noBackground();
    }

    public static RxInputDialog with(Context context) {
        return new RxInputDialog(context);
    }

    @Override
    protected float widthPercent() {
        return 0.76f;
    }

    @Override
    public void show() {
        if (control.isShowLeft()) {
            if (control.isShowRight()) {
                if (control.isShowMiddle()) {
                    showView(holder.line1);
                    showView(holder.line2);
                } else {
                    showView(holder.line1);
                    hideView(holder.line2);
                    hideView(holder.middleButton);
                }
            } else {
                if (control.isShowMiddle()) {
                    showView(holder.line1);
                } else {
                    hideView(holder.line1);
                }
                hideView(holder.line2);
            }
        } else {
            if (control.isShowRight()) {
                if (control.isShowMiddle()) {
                    hideView(holder.line1);
                    showView(holder.line2);
                } else {
                    hideView(holder.line1);
                    hideView(holder.line2);
                }
            } else {
                if (control.isShowMiddle()) {
                    hideView(holder.line1);
                    hideView(holder.line2);
                    hideView(holder.leftButton);
                    hideView(holder.rightButton);
                } else {
                    hideView(holder.line1);
                    hideView(holder.line2);
                }
            }
        }
        super.show();
        holder.message.requestFocus();
    }

    @Override
    public RxInputDialog setContentView(int layoutId) {
        return (RxInputDialog) super.setContentView(layoutId);
    }

    @Override
    public RxInputDialog setContentView(@NonNull View view) {
        return (RxInputDialog) super.setContentView(view);
    }

    @Override
    public RxInputDialog setContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        return (RxInputDialog) super.setContentView(view, params);
    }

    @Override
    public RxInputDialog addContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        return (RxInputDialog) super.addContentView(view, params);
    }

    @Override
    public RxInputDialog findView(IFindView callback) {
        return (RxInputDialog) super.findView(callback);
    }

    @Override
    public RxInputDialog alpha(float alpha) {
        return (RxInputDialog) super.alpha(alpha);
    }

    @Override
    public RxInputDialog dimAmount(float dimAmount) {
        return (RxInputDialog) super.dimAmount(dimAmount);
    }

    @Override
    public RxInputDialog layout(int width, int height) {
        return (RxInputDialog) super.layout(width, height);
    }

    @Override
    public RxInputDialog height(int height) {
        return (RxInputDialog) super.height(height);
    }

    @Override
    public RxInputDialog width(int width) {
        return (RxInputDialog) super.width(width);
    }

    @Override
    public RxInputDialog widthPercent(float percent) {
        return (RxInputDialog) super.widthPercent(percent);
    }

    @Override
    public RxInputDialog heightPercent(float percent) {
        return (RxInputDialog) super.heightPercent(percent);
    }

    @Override
    public RxInputDialog noBackground() {
        return (RxInputDialog) super.noBackground();
    }

    @Override
    public RxInputDialog background(Drawable drawable) {
        return (RxInputDialog) super.background(drawable);
    }

    @Override
    public RxInputDialog background(int resId) {
        return (RxInputDialog) super.background(resId);
    }

    @Override
    public RxInputDialog gravity(int gravity) {
        return (RxInputDialog) super.gravity(gravity);
    }

    @Override
    public RxInputDialog padding(int left, int top, int right, int bottom) {
        return (RxInputDialog) super.padding(left, top, right, bottom);
    }

    @Override
    public RxInputDialog matchWidth() {
        return (RxInputDialog) super.matchWidth();
    }

    @Override
    public RxInputDialog matchHeight() {
        return (RxInputDialog) super.matchHeight();
    }

    @Override
    public RxInputDialog matchScreen() {
        return (RxInputDialog) super.matchScreen();
    }

    @Override
    public RxInputDialog canceledOnTouchOutside(boolean cancel) {
        return (RxInputDialog) super.canceledOnTouchOutside(cancel);
    }

    @Override
    public RxInputDialog cancelable(boolean cancel) {
        return (RxInputDialog) super.cancelable(cancel);
    }

    @Override
    public RxInputDialog cancel(boolean cancel) {
        return (RxInputDialog) super.cancel(cancel);
    }

    @Override
    public RxInputDialog onKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        return (RxInputDialog) super.onKeyListener(onKeyListener);
    }

    @Override
    public RxInputDialog onDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return (RxInputDialog) super.onDismissListener(onDismissListener);
    }

    @Override
    public RxInputDialog setOnCancelListener(DialogInterface.OnCancelListener listener) {
        return (RxInputDialog) super.setOnCancelListener(listener);
    }

    @Override
    public RxInputDialog setOnShowListener(DialogInterface.OnShowListener listener) {
        return (RxInputDialog) super.setOnShowListener(listener);
    }

    @Override
    public RxInputDialog setCancelMessage(Message msg) {
        return (RxInputDialog) super.setCancelMessage(msg);
    }

    @Override
    public RxDialog setDismissMessage(Message msg) {
        return (RxInputDialog) super.setDismissMessage(msg);
    }

    public RxInputDialog leftListener(final OnDialogButtonClickListener listener, final boolean dismiss) {
        holder.leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (listener instanceof OnInputResultListener) {
                        ((OnInputResultListener) listener).onResult(holder.message.getText());
                    }
                    listener.onClickButton(dialog);
                }
                if (dismiss) {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxInputDialog leftListener(final OnDialogButtonClickListener listener) {
        return leftListener(listener, true);
    }

    public RxInputDialog middleListener(final OnDialogButtonClickListener listener, final boolean dismiss) {
        holder.middleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (listener instanceof OnInputResultListener) {
                        ((OnInputResultListener) listener).onResult(holder.message.getText());
                    }
                    listener.onClickButton(dialog);
                }
                if (dismiss) {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxInputDialog middleListener(final OnDialogButtonClickListener listener) {
        return middleListener(listener, true);
    }

    public RxInputDialog rightListener(final OnDialogButtonClickListener listener, final boolean dismiss) {
        holder.rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (listener instanceof OnInputResultListener) {
                        ((OnInputResultListener) listener).onResult(holder.message.getText());
                    }
                    listener.onClickButton(dialog);
                }
                if (dismiss) {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxInputDialog rightListener(final OnDialogButtonClickListener listener) {
        return rightListener(listener, true);
    }


    public RxInputDialog messageGravity(int gravity) {
        holder.message.setGravity(gravity);
        return this;
    }


    public RxInputDialog messageMaxLength(int maxLength) {
        holder.message.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        return this;
    }

    public RxInputDialog message(CharSequence title) {
        holder.message.setText(title);
        return this;
    }

    public RxInputDialog messageHint(CharSequence title) {
        holder.message.setHint(title);
        return this;
    }

    public RxInputDialog messageSelection(int start, int stop) {
        holder.message.setSelection(start,stop);
        return this;
    }

    public RxInputDialog messageSelection(int index) {
        holder.message.setSelection(index);
        return this;
    }

    public RxInputDialog messageSelectionEnd() {
        holder.message.setSelection(holder.message.length());
        return this;
    }

    public RxInputDialog message(int title) {
        holder.message.setText(title);
        return this;
    }

    public RxInputDialog messageHint(int title) {
        holder.message.setHint(title);
        return this;
    }

    public RxInputDialog messageInputType(int type) {
        holder.message.setInputType(type);
        return this;
    }

    public RxInputDialog messageTextColor(int color) {
        holder.message.setTextColor(color);
        return this;
    }

    public RxInputDialog messageTextSize(float size) {
        holder.message.setTextSize(size);
        return this;
    }

    public RxInputDialog messageTextSize(int unit, float size) {
        holder.message.setTextSize(unit, size);
        return this;
    }

    public RxInputDialog messageHintTextColor(int color) {
        holder.message.setHintTextColor(color);
        return this;
    }

    public RxInputDialog messageTextColorResource(@ColorRes int color) {
        holder.message.setTextColor(getContext().getResources().getColor(color));
        return this;
    }

    public RxInputDialog messageTextColor(ColorStateList colors) {
        holder.message.setTextColor(colors);
        return this;
    }

    public RxInputDialog messageHintTextColorResource(@ColorRes int color) {
        holder.message.setHintTextColor(getContext().getResources().getColor(color));
        return this;
    }

    public RxInputDialog messageHintTextColor(ColorStateList colors) {
        holder.message.setHintTextColor(colors);
        return this;
    }

    public RxInputDialog messagePadding(int left, int top, int right, int bottom) {
        holder.message.setPadding(left, top, right, bottom);
        return this;
    }

    public RxInputDialog messagePadding(int padding) {
        holder.message.setPadding(padding, padding, padding, padding);
        return this;
    }

    public RxInputDialog layoutBackgroundColor(@ColorInt int color) {
        holder.alertContainer.setCardBackgroundColor(color);
        return this;
    }

    public RxInputDialog layoutBackgroundRadius(float px) {
        holder.alertContainer.setRadius(px);
        return this;
    }

    public RxInputDialog bottomLayoutBackgroundColor(@ColorInt int color) {
        holder.alertBottom.setBackgroundColor(color);
        return this;
    }

    public RxInputDialog bottomLayoutBackgroundResource(@DrawableRes int resid) {
        holder.alertBottom.setBackgroundResource(resid);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxInputDialog bottomLayoutBackgroundTintList(@Nullable ColorStateList tint) {
        holder.alertBottom.setBackgroundTintList(tint);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxInputDialog bottomLayoutBackground(Drawable background) {
        holder.alertBottom.setBackground(background);
        return this;
    }

    public RxInputDialog lineColor(int color) {
        holder.line0.setBackgroundColor(color);
        holder.line1.setBackgroundColor(color);
        holder.line2.setBackgroundColor(color);
        return this;
    }

    private void hideView(View view) {
        view.setVisibility(View.GONE);
    }

    private void showView(View view) {
        view.setVisibility(View.VISIBLE);
    }

    public RxInputViewHolder getHolder() {
        return holder;
    }

    public TextView getTitleView() {
        return holder.title;
    }

    public TextView getMessageView() {
        return holder.message;
    }

    public TextView getLeftButton() {
        return holder.leftButton;
    }

    public TextView getRightButton() {
        return holder.rightButton;
    }

    public TextView getMiddleButton() {
        return holder.middleButton;
    }


    @Override
    public RxInputDialog leftButton(CharSequence title) {
        control.leftButton(title);
        return this;
    }

    @Override
    public RxInputDialog middleButton(CharSequence title) {
        control.middleButton(title);
        return this;
    }

    @Override
    public RxInputDialog leftButton(CharSequence title, int gravity) {
        control.leftButton(title, gravity);
        return this;
    }

    @Override
    public RxInputDialog middleButton(CharSequence title, int gravity) {
        control.middleButton(title, gravity);
        return this;
    }

    @Override
    public RxInputDialog rightButton(CharSequence title, int gravity) {
        control.rightButton(title, gravity);
        return this;
    }

    @Override
    public RxInputDialog setButtonGravity(int gravity) {
        control.setButtonGravity(gravity);
        return this;
    }


    @Override
    public RxInputDialog rightButton(CharSequence title) {
        control.rightButton(title);
        return this;
    }

    @Override
    public RxInputDialog leftButton(int res) {
        control.leftButton(res);
        return this;
    }

    @Override
    public RxInputDialog middleButton(int res) {
        control.middleButton(res);
        return this;
    }

    @Override
    public RxInputDialog rightButton(int res) {
        control.rightButton(res);
        return this;
    }

    @Override
    public RxInputDialog leftButtonTextColorRes(int res) {
        control.leftButtonTextColorRes(res);
        return this;
    }

    @Override
    public RxInputDialog middleButtonTextColorRes(int res) {
        control.middleButtonTextColorRes(res);
        return this;
    }

    @Override
    public RxInputDialog rightButtonTextColorRes(int res) {
        control.rightButtonTextColorRes(res);
        return this;
    }

    @Override
    public RxInputDialog setButtonTextColorRes(int res) {
        control.setButtonTextColorRes(res);
        return this;
    }

    @Override
    public RxInputDialog leftButtonTextColor(int color) {
        control.leftButtonTextColor(color);
        return this;
    }

    @Override
    public RxInputDialog middleButtonTextColor(int color) {
        control.middleButtonTextColor(color);
        return this;
    }

    @Override
    public RxInputDialog rightButtonTextColor(int color) {
        control.rightButtonTextColor(color);
        return this;
    }

    @Override
    public RxInputDialog setButtonTextColor(int color) {
        control.setButtonTextColor(color);
        return this;
    }

    @Override
    public RxInputDialog leftButtonTextColor(ColorStateList color) {
        control.leftButtonTextColor(color);
        return this;
    }

    @Override
    public RxInputDialog middleButtonTextColor(ColorStateList color) {
        control.middleButtonTextColor(color);
        return this;
    }

    @Override
    public RxInputDialog rightButtonTextColor(ColorStateList color) {
        control.rightButtonTextColor(color);
        return this;
    }

    @Override
    public RxInputDialog setButtonTextColor(ColorStateList color) {
        control.setButtonTextColor(color);
        return this;
    }

    @Override
    public RxInputDialog leftButtonBackgroundResource(int color) {
        control.leftButtonBackgroundResource(color);
        return this;
    }

    @Override
    public RxInputDialog middleButtonBackgroundResource(int color) {
        control.middleButtonBackgroundResource(color);
        return this;
    }

    @Override
    public RxInputDialog rightButtonBackgroundResource(int color) {
        control.rightButtonBackgroundResource(color);
        return this;
    }

    @Override
    public RxInputDialog leftButtonBackgroundColor(int color) {
        control.leftButtonBackgroundColor(color);
        return this;
    }

    @Override
    public RxInputDialog middleButtonBackgroundColor(int color) {
        control.middleButtonBackgroundColor(color);
        return this;
    }

    @Override
    public RxInputDialog rightButtonBackgroundColor(int color) {
        control.rightButtonBackgroundColor(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public RxInputDialog leftButtonBackground(Drawable background) {
        control.leftButtonBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public RxInputDialog middleButtonBackground(Drawable background) {
        control.middleButtonBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public RxInputDialog rightButtonBackground(Drawable background) {
        control.rightButtonBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public RxInputDialog leftButtonBackgroundTintList(ColorStateList color) {
        control.leftButtonBackgroundTintList(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public RxInputDialog middleButtonBackgroundTintList(ColorStateList color) {
        control.middleButtonBackgroundTintList(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public RxInputDialog rightButtonBackgroundTintList(ColorStateList color) {
        control.rightButtonBackgroundTintList(color);
        return this;
    }

    @Override
    public RxInputDialog leftButtonTextSize(float size) {
        control.leftButtonTextSize(size);
        return this;
    }

    @Override
    public RxInputDialog leftButtonTextSize(int unit, float size) {
        return this;
    }

    @Override
    public RxInputDialog middleButtonTextSize(float size) {
        control.middleButtonTextSize(size);
        return this;
    }

    @Override
    public RxInputDialog middleButtonTextSize(int unit, float size) {
        return this;
    }

    @Override
    public RxInputDialog rightButtonTextSize(float size) {
        control.rightButtonTextSize(size);
        return this;
    }

    @Override
    public RxInputDialog rightButtonTextSize(int unit, float size) {
        return this;
    }

    @Override
    public RxInputDialog leftButtonPadding(int left, int top, int right, int bottom) {
        return this;
    }

    @Override
    public RxInputDialog leftButtonPadding(int padding) {
        control.leftButtonPadding(padding);
        return this;
    }

    @Override
    public RxInputDialog middleButtonPadding(int left, int top, int right, int bottom) {
        return this;
    }

    @Override
    public RxInputDialog middleButtonPadding(int padding) {
        control.middleButtonPadding(padding);
        return this;
    }

    @Override
    public RxInputDialog rightButtonPadding(int left, int top, int right, int bottom) {
        return this;
    }

    @Override
    public RxInputDialog rightButtonPadding(int padding) {
        control.rightButtonPadding(padding);
        return this;
    }

    @Override
    public RxInputDialog setButtonTextSize(int unit, float textSize) {
        control.setButtonTextSize(unit,textSize);
        return this;
    }

    @Override
    public RxInputDialog setButtonTextSize(float size) {
        control.setButtonTextSize(size);
        return this;
    }

    @Override
    public RxInputDialog titleTextSize(float size) {
        control.titleTextSize(size);
        return this;
    }

    @Override
    public RxInputDialog titleTextSize(int unit, float size) {
        return this;
    }

    @Override
    public RxInputDialog titleTextColorRes(int res) {
        control.titleTextColorRes(res);
        return this;
    }

    @Override
    public RxInputDialog titleTextColor(int color) {
        control.titleTextColor(color);
        return this;
    }

    @Override
    public RxInputDialog titleTextColor(ColorStateList color) {
        control.titleTextColor(color);
        return this;
    }

    @Override
    public RxInputDialog titleBackgroundResource(int color) {
        control.titleBackgroundResource(color);
        return this;
    }

    @Override
    public RxInputDialog titleBackgroundColor(int color) {
        control.titleBackgroundColor(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public RxInputDialog titleBackground(Drawable background) {
        control.titleBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public RxInputDialog titleBackgroundTintList(ColorStateList color) {
        control.titleBackgroundTintList(color);
        return this;
    }

    @Override
    public RxInputDialog titlePadding(int left, int top, int right, int bottom) {
        return this;
    }

    @Override
    public RxInputDialog titlePadding(int padding) {
        control.titlePadding(padding);
        return this;
    }

    @Override
    public RxInputDialog titleGravity(int gravity) {
        control.titleGravity(gravity);
        return this;
    }

    @Override
    public RxInputDialog title(CharSequence title) {
        control.title(title);
        return this;
    }

    @Override
    public RxInputDialog title(CharSequence text, int gravity) {
        control.title(text,gravity);
        return this;
    }

    @Override
    public RxInputDialog title(int title) {
        control.title(title);
        return this;
    }
}
