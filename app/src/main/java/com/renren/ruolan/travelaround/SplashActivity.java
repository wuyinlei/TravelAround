package com.renren.ruolan.travelaround;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;
import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.utils.PreferencesUtils;

import okhttp3.Call;
import okhttp3.Response;

public class SplashActivity extends BaseActivity {


    //http://icon.xinliji.me/start_img_1080.jpg
    private String splash_img_url = "http://icon.xinliji.me/start_img_1080.jpg";

    private RelativeLayout mReBg;

    @Override
    protected int getResultId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initView() {
      /*set it to be no title*/
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
       /*set it to be full screen*/
        /*全屏显示*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //mReBg = (RelativeLayout) findViewById(R.id.activity_splash);

        View target = findViewById(R.id.activity_splash);

        //请求数据
        OkGo.post(splash_img_url)
                .execute(new BitmapCallback(){

                    @Override
                    public void onSuccess(Bitmap bitmap, Call call, Response response) {
                       // target.setBackgroundDrawable(new BitmapDrawable(bitmap));
                    }
                });

        requestBitmap();

        ObjectAnimator animator = ObjectAnimator.ofFloat(target,"alpha",0.0f,1.0f);
        animator.setDuration(2000);//动画执行的时间

        animator.start();

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                SharedPreferences sp = getPreferences(MODE_PRIVATE);
                boolean isFirst = sp.getBoolean(Contants.IS_FIRST_RUNNING, true);

                String username = PreferencesUtils.getString(SplashActivity.this
                        , Contants.USER_NAME);
                String password = PreferencesUtils.getString(SplashActivity.this,
                        Contants.USER_PASSWORD);

//                //感觉不是最好的办法,Bmob官网说有个getCurrentUser()方法
//                //来判断是否之前登录过,但是我尝试了,获取到的User对象都是为空,就想到这个方法进行弥补
//                //这个方法也是可以进行登录的,但是貌似对其他登录有点影响,这个后期遇到更好的办法就在去优化
//                BmobUser.loginByAccount(username, password, new LogInListener<MyUser>() {
//
//                    @Override
//                    public void done(MyUser user, BmobException e) {
//                        if(user!=null){
//                            Log.i("smile","用户登陆成功");
//                            EventBus.getDefault().post(new LoginEvent(user));
//                            PreferencesUtils.putBoolean(SplashActivity.this
//                            ,Contants.IS_LOGIN,true);
//                        }
//                    }
//                });


                Intent intent = new Intent();
                if (isFirst) {
                    sp.edit().putBoolean(Contants.IS_FIRST_RUNNING, false).commit();
                    intent.setClass(SplashActivity.this, GuideActivity.class);
                } else {
                    intent.setClass(SplashActivity.this, MainActivity.class);
                }

                startActivity(intent);

                finish();
            }
        });

    }

    private Bitmap requestBitmap() {

        Bitmap splashBitmap = null ;


        return splashBitmap;

    }
}
