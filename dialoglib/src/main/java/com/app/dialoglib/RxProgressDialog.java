package com.app.dialoglib;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.RequiresApi;

/**
 * Created: AriesHoo on 2017-01-19 14:16
 * Function: 自定义AlertDialog 弹出提示框
 * Desc:
 */

public class RxProgressDialog extends RxDialog {
    protected View layoutContent;
    protected TextView tvTitle;
    protected TextView tvMessage;
    protected ProgressBar progressBar;
    private int layoutId = -1;

    public RxProgressDialog(Context context) {
        super(context);
        width = WindowManager.LayoutParams.MATCH_PARENT;
        style1();
    }

    public static RxProgressDialog with(Context context) {
        return new RxProgressDialog(context);
    }

    private void findView() {
        tvTitle = dialog.findViewById(R.id.tv_title);
        tvMessage = dialog.findViewById(R.id.tv_message);
        progressBar = dialog.findViewById(R.id.loading_progress);
        layoutContent = dialog.findViewById(R.id.layout_container);
    }

    public RxProgressDialog style1() {
        if (layoutId != R.layout.layout_rx_dialog_progress_style1) {
            setContentView(R.layout.layout_rx_dialog_progress_style1);
            noBackground();
            width = WindowManager.LayoutParams.WRAP_CONTENT;
            findView();
        }
        return this;
    }

    public RxProgressDialog style2() {
        if (layoutId != R.layout.layout_rx_dialog_progress_style2) {
            setContentView(R.layout.layout_rx_dialog_progress_style2);
            noBackground();
            width = (int) (getScreenWidth() * widthPercent());
            findView();
        }
        return this;
    }

    public RxProgressDialog style3() {
        if (layoutId != R.layout.layout_rx_dialog_progress_style3) {
            setContentView(R.layout.layout_rx_dialog_progress_style3);
            noBackground();
            width = (int) (getScreenWidth() * widthPercent());
            findView();
        }
        return this;
    }

    public RxProgressDialog contentView(@LayoutRes int layoutRes, IFindView findView) {
        if (layoutId != layoutRes) {
            setContentView(layoutRes);
            tvTitle = findView.findViewTitle(dialog);
            tvMessage = findView.findViewMessage(dialog);
            progressBar = findView.findViewProgress(dialog);
            layoutContent = findView.findViewLayout(dialog);
        }
        return this;
    }

    public RxProgressDialog progressStyle(Drawable drawable) {
        progressBar.setIndeterminateDrawable(drawable);
        return this;
    }

    public RxProgressDialog progressStyle(@DrawableRes int drawableRes) {
        progressBar.setIndeterminateDrawable(getContext().getResources().getDrawable(drawableRes));
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxProgressDialog progressTintList(ColorStateList tint) {
        progressBar.setIndeterminateTintList(tint);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxProgressDialog progressTintMode(PorterDuff.Mode mode) {
        progressBar.setIndeterminateTintMode(mode);
        return this;
    }

    public RxProgressDialog setMax(int value) {
        progressBar.setMax(value);
        return this;
    }

    public RxProgressDialog setProgress(int value) {
        progressBar.setProgress(value);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public RxProgressDialog setProgress(int value, boolean animate) {
        progressBar.setProgress(value, animate);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public RxProgressDialog setMin(int value) {
        progressBar.setMin(value);
        return this;
    }

    public RxProgressDialog setIndeterminate(boolean indeterminate) {
        progressBar.setIndeterminate(indeterminate);
        return this;
    }

    public RxProgressDialog setSecondaryProgress(int value) {
        progressBar.setSecondaryProgress(value);
        return this;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxProgressDialog layoutBackground(Drawable drawable) {
        layoutContent.setBackground(drawable);
        return this;
    }

    public RxProgressDialog layoutBackgroundColor(int color) {
        layoutContent.setBackgroundColor(color);
        return this;
    }

    public RxProgressDialog layoutBackgroundResource(@DrawableRes int resid) {
        layoutContent.setBackgroundResource(resid);
        return this;
    }

    public RxProgressDialog layoutBackgroundColorRes(int color) {
        layoutContent.setBackgroundColor(getContext().getResources().getColor(color));
        return this;
    }

    public RxProgressDialog layoutPadding(int left, int top, int right, int bottom) {
        layoutContent.setPadding(left, top, right, bottom);
        return this;
    }

    public RxProgressDialog layoutPadding(int padding) {
        layoutContent.setPadding(padding, padding, padding, padding);
        return this;
    }

    public RxProgressDialog messagePadding(int left, int top, int right, int bottom) {
        tvMessage.setPadding(left, top, right, bottom);
        return this;
    }

    public RxProgressDialog messagePadding(int padding) {
        tvMessage.setPadding(padding, padding, padding, padding);
        return this;
    }

    public RxProgressDialog titlePadding(int left, int top, int right, int bottom) {
        tvTitle.setPadding(left, top, right, bottom);
        return this;
    }

    public RxProgressDialog titlePadding(int padding) {
        tvTitle.setPadding(padding, padding, padding, padding);
        return this;
    }

    @Override
    public RxProgressDialog title(CharSequence title) {
        tvTitle.setText(title);
        tvTitle.setVisibility(tvTitle.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return this;
    }

    @Override
    public RxProgressDialog title(int title) {
        tvTitle.setText(title);
        tvTitle.setVisibility(tvTitle.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return this;
    }

    public RxProgressDialog titleGravity(int gravity) {
        tvTitle.setGravity(gravity);
        return this;
    }

    public RxProgressDialog titleVisibility(int visible) {
        tvTitle.setVisibility(visible);
        return this;
    }

    public RxProgressDialog titleTextSize(float size) {
        tvTitle.setTextSize(size);
        return this;
    }

    public RxProgressDialog titleTextSize(int unit, float size) {
        tvTitle.setTextSize(unit, size);
        return this;
    }

    public RxProgressDialog titleTextColor(int color) {
        tvTitle.setTextColor(color);
        return this;
    }

    public RxProgressDialog titleTextColor(ColorStateList color) {
        tvTitle.setTextColor(color);
        return this;
    }

    public RxProgressDialog titleTextColorRes(@ColorRes int res) {
        tvTitle.setTextColor(getContext().getResources().getColor(res));
        return this;
    }

    public RxProgressDialog message(CharSequence title) {
        tvMessage.setText(title);
        tvMessage.setVisibility(tvMessage.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return this;
    }

    public RxProgressDialog message(int title) {
        tvMessage.setText(title);
        tvMessage.setVisibility(tvMessage.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return this;
    }

    public RxProgressDialog messageGravity(int gravity) {
        tvMessage.setGravity(gravity);
        return this;
    }

    public RxProgressDialog messageVisibility(int visible) {
        tvMessage.setVisibility(visible);
        return this;
    }

    public RxProgressDialog messageTextSize(float size) {
        tvMessage.setTextSize(size);
        return this;
    }

    public RxProgressDialog messageTextSize(int unit, float size) {
        tvMessage.setTextSize(unit, size);
        return this;
    }

    public RxProgressDialog messageTextColor(int color) {
        tvMessage.setTextColor(color);
        return this;
    }

    public RxProgressDialog messageTextColor(ColorStateList color) {
        tvMessage.setTextColor(color);
        return this;
    }

    public RxProgressDialog messageTextColorRes(@ColorRes int res) {
        tvMessage.setTextColor(getContext().getResources().getColor(res));
        return this;
    }

    public View getLayoutContent() {
        return layoutContent;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvMessage() {
        return tvMessage;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    @Override
    public RxProgressDialog findView(RxDialog.IFindView callback) {
        return (RxProgressDialog) super.findView(callback);
    }

    @Override
    public RxProgressDialog alpha(float alpha) {
        return (RxProgressDialog) super.alpha(alpha);
    }

    @Override
    public RxProgressDialog dimAmount(float dimAmount) {
        return (RxProgressDialog) super.dimAmount(dimAmount);
    }

    @Override
    public RxProgressDialog layout(int width, int height) {
        return (RxProgressDialog) super.layout(width, height);
    }

    @Override
    public RxProgressDialog height(int height) {
        return (RxProgressDialog) super.height(height);
    }

    @Override
    public RxProgressDialog width(int width) {
        return (RxProgressDialog) super.width(width);
    }

    @Override
    public RxProgressDialog widthPercent(float percent) {
        return (RxProgressDialog) super.widthPercent(percent);
    }

    @Override
    public RxProgressDialog heightPercent(float percent) {
        return (RxProgressDialog) super.heightPercent(percent);
    }

    @Override
    public RxProgressDialog noBackground() {
        return (RxProgressDialog) super.noBackground();
    }

    @Override
    public RxProgressDialog background(Drawable drawable) {
        return (RxProgressDialog) super.background(drawable);
    }

    @Override
    public RxProgressDialog background(int resId) {
        return (RxProgressDialog) super.background(resId);
    }

    @Override
    public RxProgressDialog gravity(int gravity) {
        return (RxProgressDialog) super.gravity(gravity);
    }

    @Override
    public RxProgressDialog padding(int left, int top, int right, int bottom) {
        return (RxProgressDialog) super.padding(left, top, right, bottom);
    }

    @Override
    public RxProgressDialog matchWidth() {
        return (RxProgressDialog) super.matchWidth();
    }

    @Override
    public RxProgressDialog matchHeight() {
        return (RxProgressDialog) super.matchHeight();
    }

    @Override
    public RxProgressDialog matchScreen() {
        return (RxProgressDialog) super.matchScreen();
    }

    @Override
    public RxProgressDialog canceledOnTouchOutside(boolean cancel) {
        return (RxProgressDialog) super.canceledOnTouchOutside(cancel);
    }

    @Override
    public RxProgressDialog cancelable(boolean cancel) {
        return (RxProgressDialog) super.cancelable(cancel);
    }

    @Override
    public RxProgressDialog cancel(boolean cancel) {
        return (RxProgressDialog) super.cancel(cancel);
    }

    @Override
    public RxProgressDialog onKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        return (RxProgressDialog) super.onKeyListener(onKeyListener);
    }

    @Override
    public RxProgressDialog onDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return (RxProgressDialog) super.onDismissListener(onDismissListener);
    }

    @Override
    public RxProgressDialog setOnCancelListener(DialogInterface.OnCancelListener listener) {
        return (RxProgressDialog) super.setOnCancelListener(listener);
    }

    @Override
    public RxProgressDialog setOnDismissListener(DialogInterface.OnDismissListener listener) {
        return (RxProgressDialog) super.setOnDismissListener(listener);
    }

    @Override
    public RxProgressDialog setOnShowListener(DialogInterface.OnShowListener listener) {
        return (RxProgressDialog) super.setOnShowListener(listener);
    }

    @Override
    public RxProgressDialog setCancelMessage(Message msg) {
        return (RxProgressDialog) super.setCancelMessage(msg);
    }

    @Override
    public RxProgressDialog setDismissMessage(Message msg) {
        return (RxProgressDialog) super.setDismissMessage(msg);
    }

    public interface IFindView {
        TextView findViewTitle(Dialog dialog);

        TextView findViewMessage(Dialog dialog);

        ProgressBar findViewProgress(Dialog dialog);

        View findViewLayout(Dialog dialog);
    }
}
