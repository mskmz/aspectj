package com.wzk.aspectj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.wzk.aspectj.annotation.TestJava;

public class MainJavaActivity extends Activity implements View.OnClickListener {
    //---------------DEBUG配置-------------------------------------------------------
    private static final String TAG = "MainJavaActivity";
    private static final boolean DEBUG = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_test).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        aspectj1();
    }

    @TestJava("我知道啦")
    private String aspectj1() {
        if (DEBUG) Log.d(TAG, "aspectj1: RUN ");
        return "我是返回值";
    }

}
