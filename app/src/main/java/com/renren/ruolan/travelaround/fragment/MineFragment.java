package com.renren.ruolan.travelaround.fragment;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.cn.sharesdk.onekeyshare.OnekeyShare;
import com.renren.ruolan.travelaround.utils.DataCleanManager;

import cn.sharesdk.framework.ShareSDK;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment implements View.OnClickListener {


    private RelativeLayout mRlLogined;
    private ImageView mIvUser;
    private LinearLayout mLoginLa;
    private TextView mTvName;
    private ImageView mIvNowLevel;
    private ImageView mIvArrowMore;
    private RelativeLayout mRlUnlogin;
    private TextView mTvUnloginNotice;
    private Button mBtnLogin;
    private TextView mTvTicket;
    private TextView mTvCollect;
    private TextView mTvRecentView;
    private RelativeLayout mRlBankcard;
    private ImageView mIvArrowRightBanck;
    private TextView mTvGotoMybank;
    private RelativeLayout mRlTuijian;
    private ImageView mIvTuijian;
    private ImageView mIvArrowRightFourth;
    private TextView mTvTuijian;
    private LinearLayout mClearCache;
    private TextView mCurrentCache;
    private LinearLayout mSettingOpinion;
    private LinearLayout mSettingGrade;
    private LinearLayout mSettingShare;
    private LinearLayout mVersionCheck;
    private TextView mVersionName;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        initView(view);
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        mSettingShare.setOnClickListener(this);
        mClearCache.setOnClickListener(this);
    }

    private void initData() {

        try {
            String versionName = getVersionName();
            mVersionName.setText(versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView(View view) {
        mRlLogined = (RelativeLayout) view.findViewById(R.id.rl_logined);
        mIvUser = (ImageView) view.findViewById(R.id.iv_user);
        mLoginLa = (LinearLayout) view.findViewById(R.id.login_la);
        mTvName = (TextView) view.findViewById(R.id.tv_name);
        mIvNowLevel = (ImageView) view.findViewById(R.id.iv_now_level);
        mIvArrowMore = (ImageView) view.findViewById(R.id.iv_arrow_more);
        mRlUnlogin = (RelativeLayout) view.findViewById(R.id.rl_unlogin);
        mTvUnloginNotice = (TextView) view.findViewById(R.id.tv_unlogin_notice);
        mBtnLogin = (Button) view.findViewById(R.id.btn_login);
        mTvTicket = (TextView) view.findViewById(R.id.tv_ticket);
        mTvCollect = (TextView) view.findViewById(R.id.tv_collect);
        mTvRecentView = (TextView) view.findViewById(R.id.tv_recent_view);
        mRlBankcard = (RelativeLayout) view.findViewById(R.id.rl_bankcard);
        mIvArrowRightBanck = (ImageView) view.findViewById(R.id.iv_arrow_right_banck);
        mTvGotoMybank = (TextView) view.findViewById(R.id.tv_goto_mybank);
        mRlTuijian = (RelativeLayout) view.findViewById(R.id.rl_tuijian);
        mIvTuijian = (ImageView) view.findViewById(R.id.iv_tuijian);
        mIvArrowRightFourth = (ImageView) view.findViewById(R.id.iv_arrow_right_fourth);
        mTvTuijian = (TextView) view.findViewById(R.id.tv_tuijian);
        mClearCache = (LinearLayout) view.findViewById(R.id.clear_cache);
        mCurrentCache = (TextView) view.findViewById(R.id.current_cache);
        mSettingOpinion = (LinearLayout) view.findViewById(R.id.setting_opinion);
        mSettingGrade = (LinearLayout) view.findViewById(R.id.setting_grade);
        mSettingShare = (LinearLayout) view.findViewById(R.id.setting_share);

        mVersionCheck = (LinearLayout) view.findViewById(R.id.version_check);
        mVersionName = (TextView) view.findViewById(R.id.version_name);

    }


    /**
     * 获取当前版本号码
     *
     * @return 当前版本号
     * @throws Exception
     */
    private String getVersionName() throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = getActivity().getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(getActivity().getPackageName(), 0);
        String version = packInfo.versionName;
        return version;
    }

    /**
     * 用户分享
     */
    private void showShare() {
        ShareSDK.initSDK(getActivity());
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("Welcome");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("https://github.com/wuyinlei/MyHearts");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("test");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("GitHub");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("https://github.com/wuyinlei/MyHearts");

// 启动分享GUI
        oks.show(getActivity());


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_share:

                showShare();

                break;

            case R.id.clear_cache:
                DataCleanManager.clearAllCache(getActivity());  //清理app缓存
                new MaterialDialog.Builder(this)
                        .title(getResources().getString(R.string.clear_tip))
                        .content(getResources().getString(R.string.clear_success))
                        .positiveText(getResources().getString(R.string.ok))
                        .onPositive((dialog, which) -> mCurrentCache.setText("0 KB")).show();
                break;
        }
    }
}
