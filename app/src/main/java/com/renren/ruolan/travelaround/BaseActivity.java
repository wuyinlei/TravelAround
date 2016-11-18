package com.renren.ruolan.travelaround;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.renren.ruolan.travelaround.utils.TranslucentUtils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by Administrator on 2016/10/20.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected static final String TAG = BaseActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getResultId());

        TranslucentUtils.setColor(this, getResources().getColor(R.color.home_bg_title), 1);

        initView();
        initListener();
        initData();
    }


    protected abstract int getResultId();

    public void initData() {

    }

    /** 初始化 Toolbar */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    protected abstract void initListener();

    public abstract void initView();

    public void startActivity(Intent intent, boolean isNeedLogin){

    }


    private CompositeSubscription mCompositeSubscription;

    /**
     * 解决Subscription内存泄露问题
     * @param s
     */
    protected void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }


}
