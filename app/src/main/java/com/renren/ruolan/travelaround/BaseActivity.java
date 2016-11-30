package com.renren.ruolan.travelaround;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.utils.TranslucentUtils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by Administrator on 2016/10/20.
 *
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
     * @param s  Subscription
     */
    protected void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }


    /**
     * 为子类提供一个权限的检查方法
     * @param permissions  需要的权限
     * @return  false  true
     */
    public boolean hasPermission(String... permissions){
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this,permission)
                    != PackageManager.PERMISSION_GRANTED){

                return false;
            }
        }
        return true;
    }


    /**
     * 为子类提供一个权限的请求方法
     * @param code  状态码
     * @param permissions  权限数组
     */
    public void requestPermission(int code ,String... permissions){
        ActivityCompat.requestPermissions(this,permissions,code);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
//            case Constants.WRITE_READ_EXTERNAL_CODE:
//                doSdCardPermission();
//                break;
//            case Constants.CALL_PHONE_CODE:
//                doCallPhone();
//                break;
            case Contants.ACCESS_COARSE_LOCATION:
                doLocation();
                break;
        }
    }

    public void doLocation() {

    }


}
