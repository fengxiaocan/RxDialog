package com.app.dialoglib;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.app.lifedata.LifecycleData;

public class RxDialog implements IRxDialog, LifecycleData {
    protected Context context;
    protected int height = WindowManager.LayoutParams.WRAP_CONTENT;
    protected int width = WindowManager.LayoutParams.WRAP_CONTENT;
    protected Dialog dialog;

    public RxDialog(Context context) {
        this.context = context;
        dialog = new Dialog(context);
        width = (int) (getScreenWidth() * widthPercent());
    }

    public RxDialog(Context context, @LayoutRes int layoutId) {
        this(context);
        dialog.setContentView(layoutId);
        width = (int) (getScreenWidth() * widthPercent());
    }

    public RxDialog(View layout) {
        this(layout.getContext());
        dialog.setContentView(layout);
        width = (int) (getScreenWidth() * widthPercent());
    }

    public static RxDialog with(Context context, @LayoutRes int layoutId) {
        return new RxDialog(context, layoutId);
    }

    public static RxDialog with(View layout) {
        return new RxDialog(layout);
    }


    protected float widthPercent() {
        return 0.9f;
    }


    @Override
    public Dialog getDialog() {
        return dialog;
    }

    @Override
    public View getLayout() {
        return getWindow().getDecorView();
    }

    @Override
    public void show() {
        dialog.show();
        getWindow().setLayout(width, height);
    }

    @Override
    public void dismiss() {
        dialog.dismiss();
    }

    @Override
    public Window getWindow() {
        return dialog.getWindow();
    }

    @Override
    public Context getContext() {
        return context;
    }

    public RxDialog setContentView(int layoutId) {
        dialog.setContentView(layoutId);
        return this;
    }

    public RxDialog setContentView(@NonNull View view) {
        dialog.setContentView(view);
        return this;
    }

    public RxDialog setContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        dialog.setContentView(view, params);
        return this;
    }

    public RxDialog addContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        dialog.addContentView(view, params);
        return this;
    }

    public RxDialog findView(IFindView callback) {
        callback.findView(dialog);
        return this;
    }

    /**
     * 设置窗口透明度
     *
     * @param alpha the alpha
     * @return ios dialog
     */
    public RxDialog alpha(float alpha) {
        Window window = getWindow();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = alpha;
        window.setAttributes(params);
        return this;
    }

    /**
     * 设置背景黑暗度
     *
     * @param dimAmount the dim amount
     * @return ios dialog
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public RxDialog dimAmount(float dimAmount) {
        getWindow().setDimAmount(dimAmount);
        return this;
    }

    public RxDialog layout(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public RxDialog height(int height) {
        this.height = height;
        return this;
    }

    public RxDialog width(int width) {
        this.width = width;
        return this;
    }

    public RxDialog widthPercent(@FloatRange(from = 0.0f,
            to = 1.0) float percent) {
        this.width = (int) (getScreenWidth() * percent);
        return this;
    }

    public RxDialog heightPercent(@FloatRange(from = 0.0f,
            to = 1.0) float percent) {
        this.height = (int) (getScreenHeight() * percent);
        return this;
    }

    public RxDialog noBackground() {
        getWindow().setBackgroundDrawable(null);
        return this;
    }

    public RxDialog background(Drawable drawable) {
        getWindow().setBackgroundDrawable(drawable);
        return this;
    }

    public RxDialog background(@DrawableRes int resId) {
        getWindow().setBackgroundDrawable(getContext().getResources().getDrawable(resId));
        return this;
    }

    public RxDialog gravity(int gravity) {
        getWindow().setGravity(gravity);
        return this;
    }

    public RxDialog padding(int left, int top, int right, int bottom) {
        getWindow().getDecorView().setPadding(left, top, right, bottom);
        return this;
    }

    public RxDialog matchWidth() {
        this.width = getScreenWidth();
        background(null);
        return this;
    }

    public RxDialog matchHeight() {
        this.height = getScreenHeight();
        background(null);
        return this;
    }

    public RxDialog matchScreen() {
        this.width = getScreenWidth();
        this.height = getScreenHeight();
        background(null);
        return this;
    }


    /**
     * 是否设置点击dialog区域外，dialog消失
     *
     * @param cancel the cancel
     */
    public RxDialog canceledOnTouchOutside(boolean cancel) {
        dialog.setCanceledOnTouchOutside(cancel);
        return this;
    }

    /**
     * 设置标题
     *
     * @param title the title
     * @return ios dialog
     */
    public RxDialog title(CharSequence title) {
        dialog.setTitle(title);
        return this;
    }

    /**
     * Set title ios dialog.
     *
     * @param title the title
     * @return the ios dialog
     */
    public RxDialog title(int title) {
        dialog.setTitle(title);
        return this;
    }

    /**
     * 设置返回键弹框是否可消失
     *
     * @param cancel the cancel
     * @return ios dialog
     */
    public RxDialog cancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public RxDialog cancel(boolean cancel) {
        dialog.setCancelable(cancel);
        dialog.setCanceledOnTouchOutside(cancel);
        return this;
    }

    /**
     * Set on key listener ios dialog.
     *
     * @param onKeyListener the on key listener
     * @return the ios dialog
     */
    public RxDialog onKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        dialog.setOnKeyListener(onKeyListener);
        return this;
    }

    /**
     * Set on dismiss listener ios dialog.
     *
     * @param onDismissListener the on dismiss listener
     * @return the ios dialog
     */
    public RxDialog onDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        dialog.setOnDismissListener(onDismissListener);
        return this;
    }

    public RxDialog setOnCancelListener(DialogInterface.OnCancelListener listener) {
        dialog.setOnCancelListener(listener);
        return this;
    }

    public RxDialog setOnShowListener(DialogInterface.OnShowListener listener) {
        dialog.setOnShowListener(listener);
        return this;
    }

    public RxDialog setCancelMessage(Message msg) {
        dialog.setCancelMessage(msg);
        return this;
    }

    public RxDialog setDismissMessage(Message msg) {
        dialog.setDismissMessage(msg);
        return this;
    }

    /**
     * 获取屏幕的宽度（单位：px）
     *
     * @return 屏幕宽px
     */
    protected int getScreenWidth() {
        WindowManager windowManager = (WindowManager) context.getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();// 创建了一张白纸
        windowManager.getDefaultDisplay().getMetrics(dm);// 给白纸设置宽高
        return dm.widthPixels;
    }

    /**
     * 获取屏幕的高度（单位：px）
     *
     * @return 屏幕高px
     */
    protected int getScreenHeight() {
        WindowManager windowManager = (WindowManager) context.getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();// 创建了一张白纸
        windowManager.getDefaultDisplay().getMetrics(dm);// 给白纸设置宽高
        return dm.heightPixels;
    }

    @Override
    public void onDetach() {
        dismiss();
    }

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {

    }

    public interface IFindView {
        void findView(Dialog dialog);
    }
}
