package com.sergio.inventory.iu.login;

import android.os.Handler;
import android.text.TextUtils;

import com.sergio.inventory.data.repository.UserRepository;
import com.sergio.inventory.iu.utils.CommonUtils;

public class LoginInteractorImpl {
    private LoginInteractor callback;

    public interface LoginInteractor {
        void onUserEmptyError();
        void onPasswordEmptyError();
        void onPasswordFormatError();
        void onAuthenticationError();
        void onSuccess();
    }

    public LoginInteractorImpl(LoginInteractor callback) {
        this.callback = callback;
    }

    public void validateCredentials(final String user, final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(user)) {
                    callback.onUserEmptyError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    callback.onPasswordEmptyError();
                    return;
                }
                if (!CommonUtils.isPasswordValid(password)) {
                    callback.onPasswordFormatError();
                    return;
                }
                if (!UserRepository.getInstance().validateCredentials(user, password)) {
                    callback.onAuthenticationError();
                    return;
                }

                callback.onSuccess();
            }
        }, 1000);
    }
}