package com.sergio.inventory.iu.signup;

import android.os.Handler;
import android.text.TextUtils;

import com.sergio.inventory.data.repository.UserRepository;
import com.sergio.inventory.iu.utils.CommonUtils;

public class SignupInteractorImpl {
    private SignupInteractor callback;

    interface SignupInteractor {
        void onUserEmptyError();
        void onUserExistsError();
        void onPasswordEmptyError();
        void onPasswordFormatError();
        void onPasswordConfirmError();
        void onEmailEmptyError();
        void onEmailFormatError();
        void onSuccess();
    }

    public SignupInteractorImpl(SignupInteractor callback) {
        this.callback = callback;
    }

    public void addUser(final String user, final String password, final String confirmPassword, final String email) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(user)) {
                    callback.onUserEmptyError();
                    return;
                }
                if (UserRepository.getInstance().userExists(user)) {
                    callback.onUserExistsError();
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
                if (!password.equals(confirmPassword)) {
                    callback.onPasswordConfirmError();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    callback.onEmailEmptyError();
                    return;
                }
                if (!CommonUtils.isEmailValid(email)) {
                    callback.onEmailFormatError();
                    return;
                }

                UserRepository.getInstance().add(user, password, email);
                callback.onSuccess();
            }
        }, 1000);
    }
}