package com.sergio.inventory.iu.signup;

import com.sergio.inventory.iu.base.BasePresenter;
import com.sergio.inventory.iu.user.UserView;

public interface SignupContract {
    interface View extends UserView {
        void showProgressDialog();
        void hideProgressDialog();
        void setUserExistsError();
        void setPasswordConfirmError();
        void setEmailEmptyError();
        void setEmailFormatError();
    }

    interface Presenter extends BasePresenter {
        void addUser(String user, String password, String confirmPassword, String email);
    }
}