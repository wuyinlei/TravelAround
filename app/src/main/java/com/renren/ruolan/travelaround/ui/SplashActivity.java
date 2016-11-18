package com.renren.ruolan.travelaround.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;
import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.entity.MyUser;
import com.renren.ruolan.travelaround.event.LoginEvent;
import com.renren.ruolan.travelaround.utils.PreferencesUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
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

        location();

        //mReBg = (RelativeLayout) findViewById(R.id.activity_splash);

        View target = findViewById(R.id.activity_splash);

        //请求数据
        OkGo.post(splash_img_url)
                .execute(new BitmapCallback() {

                    @Override
                    public void onSuccess(Bitmap bitmap, Call call, Response response) {
                        // target.setBackgroundDrawable(new BitmapDrawable(bitmap));
                    }
                });

        requestBitmap();

        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "alpha", 0.0f, 1.0f);
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

                //感觉不是最好的办法,Bmob官网说有个getCurrentUser()方法
                //来判断是否之前登录过,但是我尝试了,获取到的User对象都是为空,就想到这个方法进行弥补
                //这个方法也是可以进行登录的,但是貌似对其他登录有点影响,这个后期遇到更好的办法就在去优化
//                BmobUser.loginByAccount(username, password, new LogInListener<MyUser>() {
//
//                    @Override
//                    public void done(MyUser user, BmobException e) {
//                        if (user != null) {
//                            Log.i("smile", "用户登陆成功");
//                            EventBus.getDefault().post(new LoginEvent(user));
//                            PreferencesUtils.putBoolean(SplashActivity.this
//                                    , Contants.IS_LOGIN, true);
//                        }
//                    }
//                });

                Intent intent = new Intent();
                if (isFirst) {
                    sp.edit().putBoolean(Contants.IS_FIRST_RUNNING, false).commit();
                    intent.setClass(SplashActivity.this, GuideActivity.class);
                } else {
                    intent.setClass(SplashActivity.this, MainActivity.class);
                    intent.putExtra("cityname",cityName);
                    intent.putExtra("latitude",latitude);
                    intent.putExtra("longitude",longitude);
                }

                startActivity(intent);

                finish();
            }
        });

    }

    private Bitmap requestBitmap() {

        Bitmap splashBitmap = null;


        return splashBitmap;

    }

    //第一步，初始化LocationClient类
    private LocationClient mLocationClient = null;

    private String cityName;
    double latitude,longitude;

    /**
     * 位置监听器
     * <p/>
     * BDLocationListener接口有1个方法需要实现： 1.接收异步返回的定位结果，参数是BDLocation类型参数。
     */
    class MyLocationListener implements BDLocationListener {

        /**
         * 接收位置的信息回调方法
         *
         * @param location
         */
        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location == null) {
                return;
            }
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");
                cityName = location.getCity();
                latitude = location.getLatitude();
                longitude = location.getLongitude();

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
                cityName = location.getCity();
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
                cityName = location.getCity();
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.d("BaiduLocationApiDem", sb.toString());
           // BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.icon_gcoding);
            //创建一个图层选项
            LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
         //   OverlayOptions options = new MarkerOptions().position(latlng).icon(bitmapDescriptor);
         //   mBaiduMap.addOverlay(options);
            MapStatus mMapStatus = new MapStatus.Builder()
                    .target(latlng)
                    .zoom(12)
                    .build();
//定义MapStatusUpdate对象，以便描述地图状态将要发生的变化

            MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
//改变地图状态
        //    mBaiduMap.setMapStatus(mMapStatusUpdate);


        }

    }

    public void location(){
        BDLocationListener listener = new MyLocationListener();

        //此处需要注意：LocationClient类必须在主线程中声明。需要Context类型的参数。
        //Context需要时全进程有效的context,推荐用getApplicationConext获取全进程有效的context
        mLocationClient = new LocationClient(getApplicationContext());

        //注册位置监听器
        mLocationClient.registerLocationListener(listener);


        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 5000; //5秒发送一次
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        option.setNeedDeviceDirect(true); //返回的定位结果包含手机机头方向
        mLocationClient.setLocOption(option);
        mLocationClient.start(); //启动位置请求
        mLocationClient.requestLocation();//发送请求
    }


}
