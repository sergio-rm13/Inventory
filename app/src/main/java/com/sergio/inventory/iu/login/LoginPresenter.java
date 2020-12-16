package com.sergio.inventory.iu.login;

public class LoginPresenter implements LoginContract.Presenter, LoginInteractorImpl.LoginInteractor {
    private LoginContract.View view;
    private LoginInteractorImpl interactor;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.interactor = new LoginInteractorImpl(this);
    }

    @Override
    public void validateCredentials(String user, String password) {
        view.showProgress();
        interactor.validateCredentials(user, password);
    }

    @Override
    public void onUserEmptyError() {
        view.hideProgress();
        view.setUserEmptyError();
    }

    @Override
    public void onPasswordEmptyError() {
        view.hideProgress();
        view.setPasswordEmptyError();
    }

    @Override
    public void onPasswordFormatError() {
        view.hideProgress();
        view.setPasswordFormatError();
    }

    @Override
    public void onAuthenticationError() {
        view.hideProgress();
        view.setAuthenticationError();
    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        view.onSuccess();
    }

    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }
}
