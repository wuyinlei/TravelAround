package com.renren.ruolan.travelaround.ui;

import android.content.Intent;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.renren.ruolan.travelaround.BaseActivity;
import com.renren.ruolan.travelaround.R;
import com.renren.ruolan.travelaround.constant.Contants;
import com.renren.ruolan.travelaround.entity.MyUser;
import com.renren.ruolan.travelaround.utils.CountTimerView;
import com.renren.ruolan.travelaround.utils.PreferencesUtils;
import com.renren.ruolan.travelaround.utils.RegularUtils;
import com.renren.ruolan.travelaround.utils.ToastUtils;
import com.renren.ruolan.travelaround.widget.ClearEditText;
import com.renren.ruolan.travelaround.widget.dialog.CustomPrograss;

import org.json.JSONObject;

import java.util.HashMap;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;

import static com.baidu.location.b.g.P;

public class RegisterSecondActivity extends BaseActivity implements View.OnClickListener {


    ImageView mIvBack;
    TextView mFinish;
    TextView mTxtTip;
    ClearEditText mEdittxtCode;
    Button mBtnReSend;
    ClearEditText mEditName;

    private String phone;
    private String pwd;
    private String countryCode;

    private CountTimerView countTimerView;

    @Override
    protected int getResultId() {
        return R.layout.activity_register_second;
    }

    @Override
    protected void initListener() {
        mBtnReSend.setOnClickListener(this);
        mIvBack.setOnClickListener(this);
        mFinish.setOnClickListener(this);
    }

    @Override
    public void initView() {
        mIvBack = (ImageView) findViewById(R.id.ic_back);
        mFinish = (TextView) findViewById(R.id.tv_finish);
        mTxtTip = (TextView) findViewById(R.id.txtTip);
        mEdittxtCode = (ClearEditText) findViewById(R.id.edittxt_code);
        mBtnReSend = (Button) findViewById(R.id.btn_reSend);
        mEditName = (ClearEditText) findViewById(R.id.edittxt_name);

    }

    @Override
    public void initData() {
        super.initData();

        phone = getIntent().getStringExtra("phone");
        pwd = getIntent().getStringExtra("pwd");
        countryCode = getIntent().getStringExtra("countryCode");

        String formatedPhone = "+" + countryCode + " " + splitPhoneNum(phone);


        String text = getString(R.string.smssdk_send_mobile_detail) + formatedPhone;
        mTxtTip.setText(Html.fromHtml(text));


        CountTimerView timerView = new CountTimerView(mBtnReSend);
        timerView.start();


//        SMSSDK.initSDK(this, ManifestUtil.getMetaDataValue(this, "mob_sms_appKey"),
//                ManifestUtil.getMetaDataValue(this, "mob_sms_appSecrect"));

        evenHanlder = new SMSEvenHanlder();
        SMSSDK.registerEventHandler(evenHanlder);

    }

    private SMSEvenHanlder evenHanlder;


    /**
     * 分割电话号码
     */
    private String splitPhoneNum(String phone) {
        StringBuilder builder = new StringBuilder(phone);
        builder.reverse();
        for (int i = 4, len = builder.length(); i < len; i += 5) {
            builder.insert(i, ' ');
        }
        builder.reverse();
        return builder.toString();
    }


    /**
     * 提交验证码验证
     */
    private void submitCode() {

        String vCode = mEdittxtCode.getText().toString().trim();

        if (TextUtils.isEmpty(vCode)) {
            ToastUtils.show(this, R.string.smssdk_write_identify_code);
            return;
        }
        SMSSDK.submitVerificationCode(countryCode, phone, vCode);
        //dialog.show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_back:
                finish();
                break;

            case R.id.tv_finish:
                submitCode();
                break;
            case R.id.btn_reSend:
                reSendCode();
                break;
            default:
                break;
        }
    }


    class SMSEvenHanlder extends EventHandler {


        @Override
        public void afterEvent(final int event, final int result,
                               final Object data) {

            runOnUiThread(() -> {

                if (result == SMSSDK.RESULT_COMPLETE) {
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {

                        HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                        String country = (String) phoneMap.get("country");
                        String phone1 = (String) phoneMap.get("phone");

                        doRegister();
                        // dialog.setMessage("正在提交注册信息");
                        // dialog.show();;
                    }
                } else {

                    // 根据服务器返回的网络错误，给toast提示
                    try {
                        ((Throwable) data).printStackTrace();
                        Throwable throwable = (Throwable) data;

                        JSONObject object = new JSONObject(
                                throwable.getMessage());
                        String des = object.optString("detail");
                        if (!TextUtils.isEmpty(des)) {
                                ToastUtils.show(RegisterSecondActivity.this, des);
                            return;
                        }
                    } catch (Exception e) {
                        SMSLog.getInstance().w(e);
                    }

                }
            });
        }
    }

    /**
     * 进行注册
     */
    private void doRegister() {

        String userName = mEditName.getText().toString().trim();
        final MyUser myUser = new MyUser();
            CustomPrograss.show(this,getResources()
                    .getString(R.string.register_loading),true,null);
            myUser.setUsername(userName);
            myUser.setPassword(pwd);
            myUser.setMobilePhoneNumber(phone);
            myUser.signUp(new SaveListener<MyUser>() {
                @Override
                public void done(MyUser myUser, BmobException e) {
                    if (e == null) {
                        Toast.makeText(RegisterSecondActivity.this,getResources().getString(R.string.register_success),
                                Toast.LENGTH_SHORT).show();
                        PreferencesUtils.putString(RegisterSecondActivity.this,
                                Contants.USER_NAME,userName);
                        PreferencesUtils.putString(RegisterSecondActivity.this,
                                Contants.USER_PASSWORD,pwd);
                        startActivity(new Intent(RegisterSecondActivity.this,
                                LoginActivity.class));
                        CustomPrograss.disMiss();
                    } else if (e.getErrorCode() == 209){

                        Toast.makeText(RegisterSecondActivity.this,
                                getResources().getString(R.string.this_phone_has_been_register),
                                Toast.LENGTH_SHORT).show();
                        CustomPrograss.disMiss();


                    } else {
                        //注册失败
                        Toast.makeText(RegisterSecondActivity.this,
                                getResources().getString(R.string.register_failed),
                                Toast.LENGTH_SHORT).show();
                        CustomPrograss.disMiss();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(RegisterSecondActivity.this,RegisterActivity.class));
                            }
                        },1000);
                    }
                }
            });

    }


    /**
     * 重新发送验证码
     */
    public void reSendCode() {

        SMSSDK.getVerificationCode("+" + countryCode, phone);
        countTimerView = new CountTimerView(mBtnReSend, R.string.smssdk_resend_identify_code);
        countTimerView.start();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(evenHanlder);
    }


}
