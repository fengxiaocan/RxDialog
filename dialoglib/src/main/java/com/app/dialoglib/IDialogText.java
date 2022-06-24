package com.app.dialoglib;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;

public interface IDialogText<T> {
    T leftButton(CharSequence title);

    T middleButton(CharSequence title);

    T rightButton(CharSequence title);

    T leftButton(CharSequence title, int gravity);

    T middleButton(CharSequence title, int gravity);

    T rightButton(CharSequence title, int gravity);

    T setButtonGravity(int gravity);


    T leftButton(@StringRes int res);

    T middleButton(@StringRes int res);

    T rightButton(@StringRes int res);


    T leftButtonTextColorRes(@ColorRes int res);

    T middleButtonTextColorRes(@ColorRes int res);

    T rightButtonTextColorRes(@ColorRes int res);

    T setButtonTextColorRes(@ColorRes int res);

    T leftButtonTextColor(int color);

    T middleButtonTextColor(int color);

    T rightButtonTextColor(int color);

    T setButtonTextColor(int color);


    T leftButtonTextColor(ColorStateList color);

    T middleButtonTextColor(ColorStateList color);

    T rightButtonTextColor(ColorStateList color);


    T setButtonTextColor(ColorStateList color);


    T leftButtonBackgroundResource(@DrawableRes int color);

    T middleButtonBackgroundResource(@DrawableRes int color);

    T rightButtonBackgroundResource(@DrawableRes int color);


    T leftButtonBackgroundColor(int color);

    T middleButtonBackgroundColor(int color);

    T rightButtonBackgroundColor(int color);


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    T leftButtonBackground(Drawable background);

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    T middleButtonBackground(Drawable background);

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    T rightButtonBackground(Drawable background);


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    T leftButtonBackgroundTintList(ColorStateList color);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    T middleButtonBackgroundTintList(ColorStateList color);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    T rightButtonBackgroundTintList(ColorStateList color);


    T leftButtonTextSize(float size);

    T leftButtonTextSize(int unit, float size);

    T middleButtonTextSize(float size);

    T middleButtonTextSize(int unit, float size);

    T rightButtonTextSize(float size);

    T rightButtonTextSize(int unit, float size);

    T leftButtonPadding(int left, int top, int right, int bottom);

    T leftButtonPadding(int padding);

    T middleButtonPadding(int left, int top, int right, int bottom);

    T middleButtonPadding(int padding);

    T rightButtonPadding(int left, int top, int right, int bottom);

    T rightButtonPadding(int padding);


    T setButtonTextSize(int unit, float textSize);

    T setButtonTextSize(float size);


    T title(@StringRes int res);

    T title(CharSequence text);

    T title(CharSequence text, int gravity);

    T titleTextSize(float size);

    T titleTextSize(int unit, float size);

    T titleTextColorRes(@ColorRes int res);

    T titleTextColor(int color);

    T titleTextColor(ColorStateList color);

    T titleBackgroundResource(@DrawableRes int color);

    T titleBackgroundColor(int color);

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    T titleBackground(Drawable background);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    T titleBackgroundTintList(ColorStateList color);

    T titlePadding(int left, int top, int right, int bottom);

    T titlePadding(int padding);

    T titleGravity(int gravity);
}
