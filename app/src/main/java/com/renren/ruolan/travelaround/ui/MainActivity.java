package com.renren.ruolan.travelaround.ui;

import android.os.Build;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.FragmentCallback;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.Tab;
import com.renren.ruolan.travelaround.event.HomeLocationEvent;
import com.renren.ruolan.travelaround.fragment.HomeFragment;
import com.renren.ruolan.travelaround.fragment.MineFragment;
import com.renren.ruolan.travelaround.fragment.DestinationFragment;
import com.renren.ruolan.travelaround.fragment.DiscoveryFragment;
import com.renren.ruolan.travelaround.widget.FragmentTabHost;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements FragmentCallback {

    //底部tab
    private List<Tab> mTabs = new ArrayList<>(5);
    private FragmentTabHost mTabHost;
    private ImageView img;  //底部图片
    private TextView text;  //底部标题
    private LayoutInflater mInflater;

    private String cityName;
    private double latitude, longitude;


    //  private String cityName;
    //  double latitude,longitude;


    @Override
    protected int getResultId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {

    }


    @Override
    public void initView() {

        // EventBus.getDefault().register(this);

        cityName = getIntent().getStringExtra("cityname");
        latitude = getIntent().getDoubleExtra("latitude", 0.0);
        longitude = getIntent().getDoubleExtra("longitude", 0.0);
        //  Log.d("MainActivity", cityname);
        //  Log.d("MainActivity", "latitude:" + latitude);
        // Log.d("MainActivity", "longitude:" + longitude);
        // location();

//        initView();
        initTab();

        EventBus.getDefault().post(new HomeLocationEvent(cityName, latitude, longitude));

    }

    public String getCityName() {
        return cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    /**
     * 初始化底部的几个菜单栏
     */
    private void initTab() {
        Tab home = new Tab(R.string.home, R.drawable.selector_home, HomeFragment.class);
        Tab hot = new Tab(R.string.selef, R.drawable.selector_destination, DestinationFragment.class);
        Tab category = new Tab(R.string.discovery, R.drawable.selector_discovery, DiscoveryFragment.class);
        Tab cart = new Tab(R.string.mine, R.drawable.selector_mine, MineFragment.class);

        mTabs.add(home);
        mTabs.add(hot);
        mTabs.add(category);
        mTabs.add(cart);

        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        int i = -1;

        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(builderIndiator(tab));
            mTabHost.addTab(tabSpec, tab.getFragment(), null, ++i);
        }

        if (Build.VERSION.SDK_INT >= 11) {
            //去掉分割线
            mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        }
        //设置初始显示的是第几个tab
        mTabHost.setCurrentTab(0);

    }

    long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            int currentItem = mTabHost.getCurrentTab();
            if (currentItem == 0){
                //双击退出逻辑
                new MaterialDialog.Builder(MainActivity.this)
                        .title(getResources().getString(R.string.tip))
                        .content(getResources().getString(R.string.exit))
                        .negativeText(getResources().getString(R.string.cancel))
                        .onNegative((dialog, which) -> dialog.dismiss()).positiveText(getResources().getString(R.string.ok))
                        .onPositive((dialog, which) -> {
                            finish();
                            dialog.dismiss();
                        }).show();
                return true;
            } else {
                mTabHost.setCurrentTab(0);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 创建indiator
     *
     * @param tab tab
     * @return view
     */
    private View builderIndiator(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_indicator, null);

        img = (ImageView) view.findViewById(R.id.icon_tab);
        text = (TextView) view.findViewById(R.id.text_indicator);
        img.setBackgroundResource(tab.getImage());
        text.setText(tab.getTitle());

        return view;
    }

    @Override
    public void changeTabHost(int index) {
        mTabHost.setCurrentTab(1);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //EventBus.getDefault().unregister(this);
    }
}
