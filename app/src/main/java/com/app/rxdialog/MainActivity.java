package com.app.rxdialog;

import android.os.Bundle;
import android.view.View;

import com.app.dialoglib.RxAlertDialog;
import com.app.dialoglib.RxInputDialog;
import com.app.dialoglib.RxProgressDialog;
import com.app.lifedata.LifeDataActivity;

public class MainActivity extends LifeDataActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.bt_click).setOnClickListener(this);
        findViewById(R.id.bt_click2).setOnClickListener(this);
        findViewById(R.id.bt_click3).setOnClickListener(this);
        findViewById(R.id.bt_click4).setOnClickListener(this);
        findViewById(R.id.bt_click5).setOnClickListener(this);
        findViewById(R.id.bt_click6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_click:
                getProvider(RxAlertDialog.class)
                        .title("标题")
                        .message(("松山湖自然环境优美，其清晨雨霁虹出时分的景色迷人，以“烟雨”闻名。沿湖岸及沿岸岛屿种植了桃花、梅花等15" +
                                "万株格式各样花卉，四季皆有美景。更为特别的是松湖烟雨萤火虫花园，可零距离接触到萤火虫，感受浪漫与梦幻交织。\n" +
                                "松山湖自然环境优美，其清晨雨霁虹出时分的景色迷人，以“烟雨”闻名。沿湖岸及沿岸岛屿种植了桃花、梅花等15万株格式各样花卉，" +
                                "四季皆有美景。更为特别的是松湖烟雨萤火虫花园，可零距离接触到萤火虫，感受浪漫与梦幻交织。"))
                        .middleButton("确定")
                        .middleListener(null)
                        .show();
                break;
            case R.id.bt_click2:
                getProvider(RxInputDialog.class)
                        .title("请输入描述")
                        .messageHint("50字以内")
                        .leftButton("确定")
                        .leftListener(null)
                        .rightButton("取消")
                        .rightListener(null)
                        .message("")
                        .show();
                break;
            case R.id.bt_click3:
                getProvider(RxProgressDialog.class)
                        .style1()
                        .title("标题")
                        .message("松山湖自然环境优美，其清晨雨霁虹出时分的景色迷人")
                        .show();
                break;
            case R.id.bt_click4:
                getProvider(RxProgressDialog.class)
                        .style2()
                        .title("标题")
                        .message("松山湖自然环境优美，其清晨雨霁虹出时分的景色迷人")
                        .show();
                break;
            case R.id.bt_click5:
                getProvider(RxProgressDialog.class)
                        .style3()
                        .setMax(100)
                        .setProgress(20)
                        .message("标题")
                        .show();
                break;
            case R.id.bt_click6:
                break;
        }
    }
}
