package com.app.dialoglib;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;

class DialogButtonControl<T> implements IDialogText<T> {

    private TextView title;
    private TextView leftButton;
    private TextView middleButton;
    private TextView rightButton;

    public DialogButtonControl(TextView title, TextView leftButton, TextView middleButton, TextView rightButton) {
        this.title = title;
        this.leftButton = leftButton;
        this.middleButton = middleButton;
        this.rightButton = rightButton;
    }

    boolean isShowLeft() {
        return leftButton.getText().length() > 0;
    }

    boolean isShowRight() {
        return rightButton.getText().length() > 0;
    }

    boolean isShowMiddle() {
        return middleButton.getText().length() > 0;
    }

    boolean isShowTitle() {
        return title.getText().length() > 0;
    }

    @Override
    public T leftButton(CharSequence title) {
        leftButton.setText(title);
        leftButton.setVisibility(leftButton.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return null;
    }

    @Override
    public T middleButton(CharSequence title) {
        middleButton.setText(title);
        middleButton.setVisibility(middleButton.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return null;
    }

    @Override
    public T rightButton(CharSequence title) {
        rightButton.setText(title);
        rightButton.setVisibility(rightButton.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return null;
    }

    @Override
    public T leftButton(CharSequence title, int gravity) {
        leftButton.setText(title);
        leftButton.setGravity(gravity);
        return null;
    }

    @Override
    public T middleButton(CharSequence title, int gravity) {
        middleButton.setText(title);
        middleButton.setGravity(gravity);
        return null;
    }

    @Override
    public T rightButton(CharSequence title, int gravity) {
        rightButton.setText(title);
        rightButton.setGravity(gravity);
        return null;
    }

    @Override
    public T setButtonGravity(int gravity) {
        leftButton.setGravity(gravity);
        middleButton.setGravity(gravity);
        rightButton.setGravity(gravity);
        return null;
    }

    @Override
    public T leftButton(int res) {
        leftButton.setText(res);
        leftButton.setVisibility(leftButton.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return null;
    }

    @Override
    public T middleButton(int res) {
        middleButton.setText(res);
        middleButton.setVisibility(middleButton.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return null;
    }

    @Override
    public T rightButton(int res) {
        rightButton.setText(res);
        rightButton.setVisibility(rightButton.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return null;
    }

    @Override
    public T leftButtonTextColorRes(int res) {
        leftButton.setTextColor(leftButton.getResources().getColor(res));
        return null;
    }

    @Override
    public T middleButtonTextColorRes(int res) {
        middleButton.setTextColor(middleButton.getResources().getColor(res));
        return null;
    }

    @Override
    public T rightButtonTextColorRes(int res) {
        rightButton.setTextColor(rightButton.getResources().getColor(res));
        return null;
    }

    @Override
    public T setButtonTextColorRes(int res) {
        leftButtonTextColorRes(res);
        middleButtonTextColorRes(res);
        rightButtonTextColorRes(res);
        return null;
    }

    @Override
    public T leftButtonTextColor(int color) {
        leftButton.setTextColor(color);
        return null;
    }

    @Override
    public T middleButtonTextColor(int color) {
        middleButton.setTextColor(color);
        return null;
    }

    @Override
    public T rightButtonTextColor(int color) {
        rightButton.setTextColor(color);
        return null;
    }

    @Override
    public T setButtonTextColor(int color) {
        leftButtonTextColor(color);
        middleButtonTextColor(color);
        rightButtonTextColor(color);
        return null;
    }

    @Override
    public T leftButtonTextColor(ColorStateList color) {
        leftButton.setTextColor(color);
        return null;
    }

    @Override
    public T middleButtonTextColor(ColorStateList color) {
        middleButton.setTextColor(color);
        return null;
    }

    @Override
    public T rightButtonTextColor(ColorStateList color) {
        rightButton.setTextColor(color);
        return null;
    }

    @Override
    public T setButtonTextColor(ColorStateList color) {
        leftButtonTextColor(color);
        middleButtonTextColor(color);
        rightButtonTextColor(color);
        return null;
    }

    @Override
    public T leftButtonBackgroundResource(int color) {
        leftButton.setBackgroundResource(color);
        return null;
    }

    @Override
    public T middleButtonBackgroundResource(int color) {
        middleButton.setBackgroundResource(color);
        return null;
    }

    @Override
    public T rightButtonBackgroundResource(int color) {
        rightButton.setBackgroundResource(color);
        return null;
    }

    @Override
    public T leftButtonBackgroundColor(int color) {
        leftButton.setBackgroundColor(color);
        return null;
    }

    @Override
    public T middleButtonBackgroundColor(int color) {
        middleButton.setBackgroundColor(color);
        return null;
    }

    @Override
    public T rightButtonBackgroundColor(int color) {
        rightButton.setBackgroundColor(color);
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public T leftButtonBackground(Drawable background) {
        leftButton.setBackground(background);
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public T middleButtonBackground(Drawable background) {
        middleButton.setBackground(background);
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public T rightButtonBackground(Drawable background) {
        rightButton.setBackground(background);
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public T leftButtonBackgroundTintList(ColorStateList color) {
        leftButton.setBackgroundTintList(color);
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public T middleButtonBackgroundTintList(ColorStateList color) {
        middleButton.setBackgroundTintList(color);
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public T rightButtonBackgroundTintList(ColorStateList color) {
        rightButton.setBackgroundTintList(color);
        return null;
    }

    @Override
    public T leftButtonTextSize(float size) {
        leftButton.setTextSize(size);
        return null;
    }

    @Override
    public T leftButtonTextSize(int unit, float size) {
        leftButton.setTextSize(unit, size);
        return null;
    }

    @Override
    public T middleButtonTextSize(float size) {
        middleButton.setTextSize(size);
        return null;
    }

    @Override
    public T middleButtonTextSize(int unit, float size) {
        middleButton.setTextSize(unit, size);
        return null;
    }

    @Override
    public T rightButtonTextSize(float size) {
        rightButton.setTextSize(size);
        return null;
    }

    @Override
    public T rightButtonTextSize(int unit, float size) {
        rightButton.setTextSize(unit, size);
        return null;
    }

    @Override
    public T leftButtonPadding(int left, int top, int right, int bottom) {
        leftButton.setPadding(left, top, right, bottom);
        return null;
    }

    @Override
    public T leftButtonPadding(int padding) {
        leftButton.setPadding(padding, padding, padding, padding);
        return null;
    }

    @Override
    public T middleButtonPadding(int left, int top, int right, int bottom) {
        middleButton.setPadding(left, top, right, bottom);
        return null;
    }

    @Override
    public T middleButtonPadding(int padding) {
        middleButton.setPadding(padding, padding, padding, padding);
        return null;
    }

    @Override
    public T rightButtonPadding(int left, int top, int right, int bottom) {
        rightButton.setPadding(left, top, right, bottom);
        return null;
    }

    @Override
    public T rightButtonPadding(int padding) {
        rightButton.setPadding(padding, padding, padding, padding);
        return null;
    }

    @Override
    public T setButtonTextSize(int unit, float textSize) {
        leftButtonTextSize(unit, textSize);
        middleButtonTextSize(unit, textSize);
        rightButtonTextSize(unit, textSize);
        return null;
    }

    @Override
    public T setButtonTextSize(float size) {
        leftButtonTextSize(size);
        middleButtonTextSize(size);
        rightButtonTextSize(size);
        return null;
    }

    @Override
    public T title(@StringRes int res) {
        title.setText(res);
        title.setVisibility(title.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return null;
    }

    @Override
    public T title(CharSequence text) {
        title.setText(text);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setVisibility(title.getText().length() == 0 ? View.GONE : View.VISIBLE);
        return null;
    }

    @Override
    public T title(CharSequence text, int gravity) {
        title.setText(text);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(gravity);
        return null;
    }

    @Override
    public T titleTextSize(float size) {
        title.setTextSize(size);
        return null;
    }

    @Override
    public T titleTextSize(int unit, float size) {
        title.setTextSize(unit, size);
        return null;
    }

    @Override
    public T titleTextColorRes(int res) {
        title.setTextColor(title.getResources().getColor(res));
        return null;
    }

    @Override
    public T titleTextColor(int color) {
        title.setTextColor(color);
        return null;
    }

    @Override
    public T titleTextColor(ColorStateList color) {
        title.setTextColor(color);
        return null;
    }

    @Override
    public T titleBackgroundResource(int color) {
        title.setBackgroundResource(color);
        return null;
    }

    @Override
    public T titleBackgroundColor(int color) {
        title.setBackgroundColor(color);
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public T titleBackground(Drawable background) {
        title.setBackground(background);
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public T titleBackgroundTintList(ColorStateList color) {
        title.setBackgroundTintList(color);
        return null;
    }

    @Override
    public T titlePadding(int left, int top, int right, int bottom) {
        title.setPadding(left, top, right, bottom);
        return null;
    }

    @Override
    public T titlePadding(int padding) {
        title.setPadding(padding, padding, padding, padding);
        return null;
    }

    @Override
    public T titleGravity(int gravity) {
        title.setGravity(gravity);
        return null;
    }
}
