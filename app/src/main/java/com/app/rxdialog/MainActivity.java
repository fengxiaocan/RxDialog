package com.app.rxdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.app.dialoglib.RxAlertDialog;
import com.app.dialoglib.RxInputDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtClick;
    private Button mBtClick2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtClick = (Button) findViewById(R.id.bt_click);
        mBtClick2 = (Button) findViewById(R.id.bt_click2);

        mBtClick.setOnClickListener(this);
        mBtClick2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_click:
                RxAlertDialog.with(this)
                             .title("标题")
                             .message(("松山湖自然环境优美，其清晨雨霁虹出时分的景色迷人，以“烟雨”闻名。沿湖岸及沿岸岛屿种植了桃花、梅花等15" +
                                       "万株格式各样花卉，四季皆有美景。更为特别的是松湖烟雨萤火虫花园，可零距离接触到萤火虫，感受浪漫与梦幻交织。\n" +
                                       "松山湖自然环境优美，其清晨雨霁虹出时分的景色迷人，以“烟雨”闻名。沿湖岸及沿岸岛屿种植了桃花、梅花等15万株格式各样花卉，" +
                                       "四季皆有美景。更为特别的是松湖烟雨萤火虫花园，可零距离接触到萤火虫，感受浪漫与梦幻交织。"))
                             .leftButton("确定")
                             .leftListener(null)
                             .middleButton("中间")
                             .middleListener(null)
                             .rightButton("取消")
                             .rightListener(null)
                             .show();
                break;
            case R.id.bt_click2:
                RxInputDialog.with(this)
                             .title("请输入描述")
                             .messageHint("50字以内")
                             .leftButton("确定")
                             .leftListener(null)
                             .rightButton("取消")
                             .rightListener(null)
                             .show();
                break;
        }
    }
}
