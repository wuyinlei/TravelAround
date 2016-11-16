package com.renren.ruolan.travelaround;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.renren.ruolan.travelaround.fragment.HomeFragment;
import com.renren.ruolan.travelaround.fragment.MineFragment;
import com.renren.ruolan.travelaround.fragment.SelefFragment;
import com.renren.ruolan.travelaround.fragment.DiscoveryFragment;
import com.renren.ruolan.travelaround.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //底部tab
    private List<Tab> mTabs = new ArrayList<>(5);
    private FragmentTabHost mTabHost;
    private ImageView img;  //底部图片
    private TextView text;  //底部标题
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTab();
    }

    private void initView() {
    }


    /**
     * 初始化底部的几个菜单栏
     */
    private void initTab() {
        Tab home = new Tab(R.string.home, R.drawable.selector_home, HomeFragment.class);
        Tab hot = new Tab(R.string.selef, R.drawable.selector_selef, SelefFragment.class);
        Tab category = new Tab(R.string.discovery, R.drawable.selector_discovery, DiscoveryFragment.class);
        Tab cart = new Tab(R.string.mine, R.drawable.selector_mine, MineFragment.class);

        mTabs.add(home);
        mTabs.add(category);
        mTabs.add(hot);
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

}
