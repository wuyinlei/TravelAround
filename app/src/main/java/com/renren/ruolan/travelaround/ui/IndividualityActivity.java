package com.renren.ruolan.travelaround.ui;

import android.content.Intent;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.utils.KeyBoard;
import com.renren.ruolan.travelaround.utils.PreferencesUtils;


public class IndividualityActivity extends BaseActivity implements View.OnClickListener {

    private EditText mUsercenterSign;
    private TextView mUpdatesignTextnum;
    private ImageView mIcBack,mFinish;

    private static final String TAG  = "IndividualityActivity";

    @Override
    protected int getResultId() {
        return R.layout.activity_individuality;
    }

    @Override
    protected void initListener() {

        mIcBack.setOnClickListener(this);
        mFinish.setOnClickListener(this);

        mUsercenterSign.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = s.length();
                int lastNum = 150-length;
                mUpdatesignTextnum.setText(lastNum+"");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void initView() {
        mUsercenterSign = (EditText) findViewById(R.id.usercenter_sign);
        mUpdatesignTextnum = (TextView) findViewById(R.id.updatesign_textnum);
        mIcBack = (ImageView) findViewById(R.id.ic_back);
        mFinish = (ImageView) findViewById(R.id.iv_finish);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_finish:
                String slognName = mUsercenterSign.getText().toString();
                if (slognName != null && slognName.length() > 0) {
                    Toast.makeText(IndividualityActivity.this, slognName, Toast.LENGTH_SHORT).show();
                    KeyBoard.closeSoftKeyboard(IndividualityActivity.this);
                    PreferencesUtils.saveSlognName(IndividualityActivity.this, slognName);
                    Intent intent = new Intent();
                    setResult(100, intent);
                    new Handler().postDelayed(() -> finish(), 500);
                }
                break;
        }
    }
}
