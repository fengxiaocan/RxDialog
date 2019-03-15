package com.app.dialoglib;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class RxAlertDialog extends RxDialog {

    protected RxAlertViewHolder viewHolder;
    protected boolean isShowLeft = false;
    protected boolean isShowRight = false;
    protected boolean isShowMiddle = false;

    public RxAlertDialog(Context context) {
        super(context);
        layout = LayoutInflater.from(context)
                               .inflate(R.layout.layout_rx_alert_dialog, null);
        dialog.setContentView(layout);
        viewHolder = new RxAlertViewHolder(layout);
        noBackground();
    }

    public static RxAlertDialog with(Context context) {
        return new RxAlertDialog(context);
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
    }

    public RxAlertDialog leftButton(CharSequence title) {
        isShowLeft = true;
        viewHolder.leftButton.setVisibility(View.VISIBLE);
        viewHolder.leftButton.setText(title);
        return this;
    }

    public RxAlertDialog middleButton(CharSequence title) {
        isShowMiddle = true;
        viewHolder.middleButton.setVisibility(View.VISIBLE);
        viewHolder.middleButton.setText(title);
        return this;
    }

    public RxAlertDialog rightButton(CharSequence title) {
        isShowRight = true;
        viewHolder.rightButton.setVisibility(View.VISIBLE);
        viewHolder.rightButton.setText(title);
        return this;
    }

    public RxAlertDialog leftListener(final OnDialogButtonClickListener listener) {
        viewHolder.leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClickButton(dialog);
                } else {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxAlertDialog middleListener(final OnDialogButtonClickListener listener) {
        viewHolder.middleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClickButton(dialog);
                } else {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxAlertDialog rightListener(final OnDialogButtonClickListener listener) {
        viewHolder.rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClickButton(dialog);
                } else {
                    dismiss();
                }
            }
        });
        return this;
    }

    public RxAlertDialog leftButton(@StringRes int res) {
        isShowLeft = true;
        viewHolder.leftButton.setVisibility(View.VISIBLE);
        viewHolder.leftButton.setText(res);
        return this;
    }

    public RxAlertDialog middleButton(@StringRes int res) {
        isShowMiddle = true;
        viewHolder.middleButton.setVisibility(View.VISIBLE);
        viewHolder.middleButton.setText(res);
        return this;
    }

    public RxAlertDialog rightButton(@StringRes int res) {
        isShowRight = true;
        viewHolder.rightButton.setVisibility(View.VISIBLE);
        viewHolder.rightButton.setText(res);
        return this;
    }

    public RxAlertDialog leftButtonTextColorRes(@ColorRes int res) {
        viewHolder.leftButton.setTextColor(layout.getResources()
                                                 .getColor(res));
        return this;
    }

    public RxAlertDialog middleButtonTextColorRes(@ColorRes int res) {
        viewHolder.middleButton.setTextColor(layout.getResources()
                                                   .getColor(res));
        return this;
    }

    public RxAlertDialog rightButtonTextColorRes(@ColorRes int res) {
        viewHolder.rightButton.setTextColor(layout.getResources()
                                                  .getColor(res));
        return this;
    }

    public RxAlertDialog leftButtonTextColor(int color) {
        viewHolder.leftButton.setTextColor(color);
        return this;
    }

    public RxAlertDialog middleButtonTextColor(int color) {
        viewHolder.middleButton.setTextColor(color);
        return this;
    }

    public RxAlertDialog rightButtonTextColor(int color) {
        viewHolder.rightButton.setTextColor(color);
        return this;
    }

    public RxAlertDialog leftButtonTextColor(ColorStateList color) {
        viewHolder.leftButton.setTextColor(color);
        return this;
    }

    public RxAlertDialog middleButtonTextColor(ColorStateList color) {
        viewHolder.middleButton.setTextColor(color);
        return this;
    }

    public RxAlertDialog rightButtonTextColor(ColorStateList color) {
        viewHolder.rightButton.setTextColor(color);
        return this;
    }

    public RxAlertDialog leftButtonBackgroundResource(@DrawableRes int color) {
        viewHolder.leftButton.setBackgroundResource(color);
        return this;
    }

    public RxAlertDialog middleButtonBackgroundResource(@DrawableRes int color) {
        viewHolder.middleButton.setBackgroundResource(color);
        return this;
    }

    public RxAlertDialog rightButtonBackgroundResource(@DrawableRes int color) {
        viewHolder.rightButton.setBackgroundResource(color);
        return this;
    }

    public RxAlertDialog leftButtonBackgroundColor(int color) {
        viewHolder.leftButton.setBackgroundColor(color);
        return this;
    }

    public RxAlertDialog middleButtonBackgroundColor(int color) {
        viewHolder.middleButton.setBackgroundColor(color);
        return this;
    }

    public RxAlertDialog rightButtonBackgroundColor(int color) {
        viewHolder.rightButton.setBackgroundColor(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxAlertDialog leftButtonBackground(Drawable background) {
        viewHolder.leftButton.setBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxAlertDialog middleButtonBackground(Drawable background) {
        viewHolder.middleButton.setBackground(background);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxAlertDialog rightButtonBackground(Drawable background) {
        viewHolder.rightButton.setBackground(background);
        return this;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxAlertDialog leftButtonBackgroundTintList(ColorStateList color) {
        viewHolder.leftButton.setBackgroundTintList(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxAlertDialog middleButtonBackgroundTintList(ColorStateList color) {
        viewHolder.middleButton.setBackgroundTintList(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxAlertDialog rightButtonBackgroundTintList(ColorStateList color) {
        viewHolder.rightButton.setBackgroundTintList(color);
        return this;
    }

    public RxAlertDialog titleGravity(int gravity) {
        viewHolder.title.setGravity(gravity);
        return this;
    }

    public RxAlertDialog messageGravity(int gravity) {
        viewHolder.message.setGravity(gravity);
        return this;
    }

    @Override
    public RxAlertDialog title(CharSequence title) {
        viewHolder.title.setVisibility(View.VISIBLE);
        viewHolder.title.setText(title);
        return this;
    }

    @Override
    public RxAlertDialog title(int title) {
        viewHolder.title.setVisibility(View.VISIBLE);
        viewHolder.title.setText(title);
        return this;
    }

    public RxAlertDialog titleTextColor(int color) {
        viewHolder.title.setTextColor(color);
        return this;
    }


    public RxAlertDialog titleTextColorResource(@ColorRes int color) {
        viewHolder.title.setTextColor(layout.getResources()
                                            .getColor(color));
        return this;
    }

    public RxAlertDialog titleTextColor(ColorStateList colors) {
        viewHolder.title.setTextColor(colors);
        return this;
    }

    public RxAlertDialog message(CharSequence title) {
        viewHolder.message.setText(title);
        return this;
    }

    public RxAlertDialog message(int title) {
        viewHolder.message.setText(title);
        return this;
    }

    public RxAlertDialog messageTextColor(int color) {
        viewHolder.message.setTextColor(color);
        return this;
    }

    public RxAlertDialog messageTextColorResource(@ColorRes int color) {
        viewHolder.message.setTextColor(layout.getResources()
                                              .getColor(color));
        return this;
    }

    public RxAlertDialog messageTextColor(ColorStateList colors) {
        viewHolder.message.setTextColor(colors);
        return this;
    }

    public RxAlertDialog layoutRadius(int radius) {
        viewHolder.llayoutAlert.setRadius(radius);
        viewHolder.rlayoutBottom.setBottomLeftRadius(radius);
        viewHolder.rlayoutBottom.setBottomRightRadius(radius);
        return this;
    }

    public RxAlertDialog layoutTopLeftRadius(int radius) {
        viewHolder.llayoutAlert.setTopLeftRadius(radius);
        return this;
    }

    public RxAlertDialog layoutTopRightRadius(int radius) {
        viewHolder.llayoutAlert.setBottomRightRadius(radius);
        return this;
    }

    public RxAlertDialog layoutBottomLeftRadius(int radius) {
        viewHolder.rlayoutBottom.setBottomLeftRadius(radius);
        viewHolder.llayoutAlert.setBottomLeftRadius(radius);
        return this;
    }

    public RxAlertDialog layoutBottomRightRadius(int radius) {
        viewHolder.rlayoutBottom.setBottomRightRadius(radius);
        viewHolder.llayoutAlert.setBottomRightRadius(radius);
        return this;
    }

    public RxAlertDialog layoutBackgroundColor(@ColorInt int color) {
        viewHolder.llayoutAlert.setBackgroundColor(color);
        return this;
    }

    public RxAlertDialog layoutBackgroundResource(@DrawableRes int resid) {
        viewHolder.llayoutAlert.setBackgroundResource(resid);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxAlertDialog layoutBackgroundTintList(@Nullable ColorStateList tint) {
        viewHolder.llayoutAlert.setBackgroundTintList(tint);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxAlertDialog layoutBackground(Drawable background) {
        viewHolder.llayoutAlert.setBackground(background);
        return this;
    }

    public RxAlertDialog bottomLayoutBackgroundColor(@ColorInt int color) {
        viewHolder.rlayoutBottom.setBackgroundColor(color);
        return this;
    }

    public RxAlertDialog bottomLayoutBackgroundResource(@DrawableRes int resid) {
        viewHolder.rlayoutBottom.setBackgroundResource(resid);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RxAlertDialog bottomLayoutBackgroundTintList(@Nullable ColorStateList tint) {
        viewHolder.rlayoutBottom.setBackgroundTintList(tint);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RxAlertDialog bottomLayoutBackground(Drawable background) {
        viewHolder.rlayoutBottom.setBackground(background);
        return this;
    }

    public RxAlertDialog lineColor(int color) {
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
