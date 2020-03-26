package com.bw.rikao3_25.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bw.rikao3_25.R;
import com.bw.rikao3_25.base.BaseActivity;

//继承activity基类
public class MainActivity extends BaseActivity {

    //重写抽象方法
    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }

    @Override
    public int layoutid() {
        return R.layout.activity_main;
    }
}
