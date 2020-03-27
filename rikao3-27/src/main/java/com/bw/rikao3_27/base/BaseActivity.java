package com.bw.rikao3_27.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//创建activity基类
public abstract  class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //调用抽象方法
        setContentView(layoutid());
        initView(savedInstanceState);
        initData();
    }

    //创建抽象方法
    public abstract void initView(Bundle savedInstanceState);
    public abstract void initData();
    public abstract int layoutid();
}
