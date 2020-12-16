package com.sergio.inventory.iu.login;

import com.sergio.inventory.iu.base.BasePresenter;
import com.sergio.inventory.iu.user.UserView;

public interface LoginContract {
    interface View extends UserView {
        void showProgress();
        void hideProgress();
        void setAuthenticationError();
    }

    interface Presenter extends BasePresenter {
        void validateCredentials(String user, String password);
    }
}