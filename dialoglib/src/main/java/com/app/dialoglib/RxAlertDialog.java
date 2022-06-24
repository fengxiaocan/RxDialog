package com.app.dialoglib;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class RxAlertDialog extends RxDialog implements IDialogText<RxAlertDialog> {

    protected RxAlertViewHolder holder;
    protected DialogButtonControl control;

    public RxAlertDialog(Context context) {
        super(context, R.layout.layout_rx_alert_dialog);
        holder = new RxAlertViewHolder(dialog);
        control = new DialogButtonControl(holder.title, holder.leftButton
                , holder.middleButton, holder.rightButton);
        noBackground();
    }

    public static RxAlertDialog with(Context context) {
        return new RxAlertDialog(context);
    }

    @Override
    public RxAlertDialog setContentView(int layoutId) {
        return (RxAlertDialog) super.setContentView(layoutId);
    }

    @Override
    public RxAlertDialog setContentView(@NonNull View view) {
        return (RxAlertDialog) super.setContentView(view);
    }

    @Override
    public RxAlertDialog setContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        return (RxAlertDialog) super.setContentView(view, params);
    }

    @Override
    public RxAlertDialog addContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        return (RxAlertDialog) super.addContentView(view, params);
    }

    @Override
    public RxAlertDialog findView(IFindView callback) {
        return (RxAlertDialog) super.findView(callback);
    }

    @Override
    public RxAlertDialog alpha(float alpha) {
        return (RxAlertDialog) super.alpha(alpha);
    }

    @Override
    public RxAlertDialog dimAmount(float dimAmount) {
        return (RxAlertDialog) super.dimAmount(dimAmount);
    }

    @Override
    public RxAlertDialog layout(int width, int height) {
        return (RxAlertDialog) super.layout(width, height);
    }

    @Override
    public RxAlertDialog height(int height) {
        return (RxAlertDialog) super.height(height);
    }

    @Override
    public RxAlertDialog width(int width) {
        return (RxAlertDialog) super.width(width);
    }

    @Override
    public RxAlertDialog widthPercent(float percent) {
        return (RxAlertDialog) super.widthPercent(percent);
    }

    @Override
    public RxAlertDialog heightPercent(float percent) {
        return (RxAlertDialog) super.heightPercent(percent);
    }

    @Override
    public RxAlertDialog noBackground() {
        return (RxAlertDialog) super.noBackground();
    }

    @Override
    public RxAlertDialog background(Drawable drawable) {
        return (RxAlertDialog) super.background(drawable);
    }

    @Override
    public RxAlertDialog background(int resId) {
        return (RxAlertDialog) super.background(resId);
    }

    @Override
    public RxAlertDialog gravity(int gravity) {
        return (RxAlertDialog) super.gravity(gravity);
    }

    @Override
    public RxAlertDialog padding(int left, int top, int right, int bottom) {
        return (RxAlertDialog) super.padding(left, top, right, bottom);
    }

    @Override
    public RxAlertDialog matchWidth() {
        return (RxAlertDialog) super.matchWidth();
    }

    @Override
    public RxAlertDialog matchHeight() {
        return (RxAlertDialog) super.matchHeight();
    }

    @Override
    public RxAlertDialog matchScreen() {
        return (RxAlertDialog) super.matchScreen();
    }

    @Override
    public RxAlertDialog canceledOnTouchOutside(boolean cancel) {
        return (RxAlertDialog) super.canceledOnTouchOutside(cancel);
    }

    @Override
    public RxAlertDialog cancelable(boolean cancel) {
        return (RxAlertDialog) super.cancelable(cancel);
    }

    @Override
    public RxAlertDialog cancel(boolean cancel) {
        return (RxAlertDialog) super.cancel(cancel);
    }

    @Override
    public RxAlertDialog onKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        return (RxAlertDialog) super.onKeyListener(onKeyListener);
    }

    @Override
    public RxAlertDialog onDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return (RxAlertDialog) super.onDismissListener(onDismissListener);
    }

    @Override
    public RxAlertDialog setOnCancelListener(DialogInterface.OnCancelListener listener) {
        return (RxAlertDialog) super.setOnCancelListener(listener);
    }

    @Override
    public RxAlertDialog setOnShowListener(DialogInterface.OnShowListener listener) {
        return (RxAlertDialog) super.setOnShowListener(listener);
    }

    @Override
    public RxAlertDialog setCancelMessage(Message msg) {
        return (RxAlertDialog) super.setCancelMessage(msg);
    }

    @Override
    public RxDialog setDismissMessage(Message msg) {
        return (RxAlertDialog) super.setDismissMessage(msg);
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
    }


    public RxAlertDialog leftListener(final OnDialogButtonClickListener listener, final boolean isDismiss) {
        holder.leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClickButton(dialog);
                }
                if (isDismiss) {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxAlertDialog leftListener(final OnDialogButtonClickListener listener) {
        leftListener(listener, true);
        return this;
    }

    public RxAlertDialog middleListener(final OnDialogButtonClickListener listener, final boolean isDismiss) {
        holder.middleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClickButton(dialog);
                }
                if (isDismiss) {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxAlertDialog middleListener(final OnDialogButtonClickListener listener) {
        middleListener(listener, true);
        return this;
    }

    public RxAlertDialog rightListener(final OnDialogButtonClickListener listener, final boolean isDismiss) {
        holder.rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClickButton(dialog);
                }
                if (isDismiss) {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxAlertDialog rightListener(final OnDialogButtonClickListener listener) {
        rightListener(listener, true);
        return this;
    }


    public RxAlertDialog messageGravity(int gravity) {
        holder.message.setGravity(gravity);
        return this;
    }


    public RxAlertDialog message(CharSequence title) {
        holder.message.setText(title);
        return this;
    }

    public RxAlertDialog message(int title) {
        holder.message.setText(title);
        return this;
    }


    public RxAlertDialog messageTextColor(int color) {
        holder.message.setTextColor(color);
        return this;
    }

    public RxAlertDialog messageTextColorResource(@ColorRes int color) {
        holder.message.setTextColor(getContext().getResources().getColor(color));
        return this;
    }

    public RxAlertDialog messageTextColor(ColorStateList colors) {
        holder.message.setTextColor(colors);
        return this;
    }

    public RxAlertDialog layoutBackgroundColor(@ColorInt int color) {
        holder.alertContainer.setCardBackgroundColor(color);
        return this;
    }

    public RxAlertDialog bottomLayoutBackgroundColor(@ColorInt int color) {
        holder.alertBottom.setBackgroundColor(color);
        return this;
    }

    public RxAlertDialog bottomLayoutBackgroundResource(@DrawableRes int resid) {
        holder.alertBottom.setBackgroundResource(resid);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxAlertDialog bottomLayoutBackgroundTintList(@Nullable ColorStateList tint) {
        holder.alertBottom.setBackgroundTintList(tint);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxAlertDialog bottomLayoutBackground(Drawable background) {
        holder.alertBottom.setBackground(background);
        return this;
    }

    public RxAlertDialog lineColor(int color) {
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

    public RxAlertViewHolder getHolder() {
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
    public RxAlertDialog leftButton(CharSequence title) {
        control.leftButton(title);
        return this;
    }

    @Override
    public RxAlertDialog middleButton(CharSequence title) {
        control.middleButton(title);
        return this;
    }

    @Override
    public RxAlertDialog rightButton(CharSequence title) {
        control.rightButton(title);
        return this;
    }

    @Override
    public RxAlertDialog leftButton(CharSequence title, int gravity) {
        control.leftButton(title,gravity);
        return this;
    }

    @Override
    public RxAlertDialog middleButton(CharSequence title, int gravity) {
        control.middleButton(title, gravity);
        return this;
    }

    @Override
    public RxAlertDialog rightButton(CharSequence title, int gravity) {
        control.rightButton(title, gravity);
        return this;
    }

    @Override
    public RxAlertDialog setButtonGravity(int gravity) {
        control.setButtonGravity( gravity);
        return this;
    }

    @Override
    public RxAlertDialog leftButton(int res) {
        control.leftButton(res);
        return this;
    }

    @Override
    public RxAlertDialog middleButton(int res) {
        control.middleButton(res);
        return this;
    }

    @Override
    public RxAlertDialog rightButton(int res) {
        control.rightButton(res);
        return this;
    }

    @Override
    public RxAlertDialog leftButtonTextColorRes(int res) {
        control.leftButtonTextColorRes(res);
        return this;
    }

    @Override
    public RxAlertDialog middleButtonTextColorRes(int res) {
        control.middleButtonTextColorRes(res);
        return this;
    }

    @Override
    public RxAlertDialog rightButtonTextColorRes(int res) {
        control.rightButtonTextColorRes(res);
        return this;
    }

    @Override
    public RxAlertDialog setButtonTextColorRes(int res) {
        control.setButtonTextColorRes(res);
        return this;
    }

    @Override
    public RxAlertDialog leftButtonTextColor(int color) {
        control.leftButtonTextColor(color);
        return this;
    }

    @Override
    public RxAlertDialog middleButtonTextColor(int color) {
        control.middleButtonTextColor(color);
        return this;
    }

    @Override
    public RxAlertDialog rightButtonTextColor(int color) {
        control.rightButtonTextColor(color);
        return this;
    }

    @Override
    public RxAlertDialog setButtonTextColor(int color) {
        control.setButtonTextColor(color);
        return this;
    }

    @Override
    public RxAlertDialog leftButtonTextColor(ColorStateList color) {
        control.leftButtonTextColor(color);
        return this;
    }

    @Override
    public RxAlertDialog middleButtonTextColor(ColorStateList color) {
        control.middleButtonTextColor(color);
        return this;
    }

    @Override
    public RxAlertDialog rightButtonTextColor(ColorStateList color) {
        control.rightButtonTextColor(color);
        return this;
    }

    @Override
    public RxAlertDialog setButtonTextColor(ColorStateList color) {
        control.setButtonTextColor(color);
        return this;
    }

    @Override
    public RxAlertDialog leftButtonBackgroundResource(int color) {
        control.leftButtonBackgroundResource(color);
        return this;
    }

    @Override
    public RxAlertDialog middleButtonBackgroundResource(int color) {
        control.middleButtonBackgroundResource(color);
        return this;
    }

    @Override
    public RxAlertDialog rightButtonBackgroundResource(int color) {
        control.rightButtonBackgroundResource(color);
        return this;
    }

    @Override
    public RxAlertDialog leftButtonBackgroundColor(int color) {
        control.leftButtonBackgroundColor(color);
        return this;
    }

    @Override
    public RxAlertDialog middleButtonBackgroundColor(int color) {
        control.middleButtonBackgroundColor(color);
        return this;
    }

    @Override
    public RxAlertDialog rightButtonBackgroundColor(int color) {
        control.rightButtonBackgroundColor(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public RxAlertDialog leftButtonBackground(Drawable background) {
        control.leftButtonBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public RxAlertDialog middleButtonBackground(Drawable background) {
        control.middleButtonBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public RxAlertDialog rightButtonBackground(Drawable background) {
        control.rightButtonBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public RxAlertDialog leftButtonBackgroundTintList(ColorStateList color) {
        control.leftButtonBackgroundTintList(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public RxAlertDialog middleButtonBackgroundTintList(ColorStateList color) {
        control.middleButtonBackgroundTintList(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public RxAlertDialog rightButtonBackgroundTintList(ColorStateList color) {
        control.rightButtonBackgroundTintList(color);
        return this;
    }

    @Override
    public RxAlertDialog leftButtonTextSize(float size) {
        control.leftButtonTextSize(size);
        return this;
    }

    @Override
    public RxAlertDialog leftButtonTextSize(int unit, float size) {
        return this;
    }

    @Override
    public RxAlertDialog middleButtonTextSize(float size) {
        control.middleButtonTextSize(size);
        return this;
    }

    @Override
    public RxAlertDialog middleButtonTextSize(int unit, float size) {
        return this;
    }

    @Override
    public RxAlertDialog rightButtonTextSize(float size) {
        control.rightButtonTextSize(size);
        return this;
    }

    @Override
    public RxAlertDialog rightButtonTextSize(int unit, float size) {
        return this;
    }

    @Override
    public RxAlertDialog leftButtonPadding(int left, int top, int right, int bottom) {
        return this;
    }

    @Override
    public RxAlertDialog leftButtonPadding(int padding) {
        control.leftButtonPadding(padding);
        return this;
    }

    @Override
    public RxAlertDialog middleButtonPadding(int left, int top, int right, int bottom) {
        return this;
    }

    @Override
    public RxAlertDialog middleButtonPadding(int padding) {
        control.middleButtonPadding(padding);
        return this;
    }

    @Override
    public RxAlertDialog rightButtonPadding(int left, int top, int right, int bottom) {
        return this;
    }

    @Override
    public RxAlertDialog rightButtonPadding(int padding) {
        control.rightButtonPadding(padding);
        return this;
    }

    @Override
    public RxAlertDialog setButtonTextSize(int unit, float textSize) {
        control.setButtonTextSize(unit,textSize);
        return this;
    }

    @Override
    public RxAlertDialog setButtonTextSize(float size) {
        control.setButtonTextSize(size);
        return this;
    }

    @Override
    public RxAlertDialog titleTextSize(float size) {
        control.titleTextSize(size);
        return this;
    }

    @Override
    public RxAlertDialog titleTextSize(int unit, float size) {
        return this;
    }

    @Override
    public RxAlertDialog titleTextColorRes(int res) {
        control.titleTextColorRes(res);
        return this;
    }

    @Override
    public RxAlertDialog titleTextColor(int color) {
        control.titleTextColor(color);
        return this;
    }

    @Override
    public RxAlertDialog titleTextColor(ColorStateList color) {
        control.titleTextColor(color);
        return this;
    }

    @Override
    public RxAlertDialog titleBackgroundResource(int color) {
        control.titleBackgroundResource(color);
        return this;
    }

    @Override
    public RxAlertDialog titleBackgroundColor(int color) {
        control.titleBackgroundColor(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public RxAlertDialog titleBackground(Drawable background) {
        control.titleBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public RxAlertDialog titleBackgroundTintList(ColorStateList color) {
        control.titleBackgroundTintList(color);
        return this;
    }

    @Override
    public RxAlertDialog titlePadding(int left, int top, int right, int bottom) {
        return this;
    }

    @Override
    public RxAlertDialog titlePadding(int padding) {
        control.titlePadding(padding);
        return this;
    }

    @Override
    public RxAlertDialog titleGravity(int gravity) {
        control.titleGravity(gravity);
        return this;
    }

    @Override
    public RxAlertDialog title(CharSequence title) {
        control.title(title);
        return this;
    }

    @Override
    public RxAlertDialog title(CharSequence text, int gravity) {
        control.title(text,gravity);
        return this;
    }

    @Override
    public RxAlertDialog title(int title) {
        control.title(title);
        return this;
    }
}
