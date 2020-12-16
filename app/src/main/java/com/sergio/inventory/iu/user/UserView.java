package com.sergio.inventory.iu.user;

import com.sergio.inventory.iu.base.BaseView;

public interface UserView extends BaseView {
    void setUserEmptyError();

    void setPasswordEmptyError();

    void setPasswordFormatError();
}
