package com.renren.ruolan.travelaround.event;

import com.renren.ruolan.travelaround.entity.MyUser;

/**
 * Created by Administrator on 2016/10/26.
 */

public class LoginEvent {

    public MyUser mMyUser;

    public LoginEvent(MyUser myUser) {
        mMyUser = myUser;
    }
}
