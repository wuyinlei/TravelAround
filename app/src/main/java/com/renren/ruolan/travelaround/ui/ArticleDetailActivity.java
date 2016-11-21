package com.renren.ruolan.travelaround.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.constant.HttpUrlPath;

import rx.android.schedulers.AndroidSchedulers;

import static com.baidu.location.b.g.s;
import static com.baidu.location.b.g.u;
import static com.baidu.location.b.g.v;

public class ArticleDetailActivity extends BaseActivity {

    private LinearLayout mActivityArticleDetail;
    private ImageView mImgBack;
    private TextView mTvTitle;
    private WebView mWebView;

    private String id;
    private String url;
    private String title;


    @Override
    protected int getResultId() {
        return R.layout.activity_article_detail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initData() {
        super.initData();
//        OkGo.get(url)
//                .getCall(StringConvert.create(), RxAdapter.<String>create())
//                .doOnSubscribe(()->{})
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(s->{
//
//                },throwable -> {});
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setBlockNetworkImage(false);
        mWebView.loadUrl(url);
    }

    @Override
    public void initView() {
        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");
        if (id != null)
        url = HttpUrlPath.GET_ARTICLE_INFO+id;
        mActivityArticleDetail = (LinearLayout) findViewById(R.id.activity_article_detail);
        mImgBack = (ImageView) findViewById(R.id.img_back);
        mImgBack.setOnClickListener(v->{finish();});
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title))
            mTvTitle.setText(title);
        mWebView = (WebView) findViewById(R.id.web_view);
    }
}
