package com.sergio.inventory.iu.signup;

public class SignupPresenter implements SignupContract.Presenter, SignupInteractorImpl.SignupInteractor {
    private SignupContract.View view;
    private SignupInteractorImpl interactor;

    public SignupPresenter(SignupContract.View view) {
        this.view = view;
        this.interactor = new SignupInteractorImpl(this);
    }

    @Override
    public void addUser(String user, String password, String confirmPassword, String email) {
        view.showProgressDialog();
        interactor.addUser(user, password, confirmPassword, email);
    }

    @Override
    public void onUserEmptyError() {
        view.hideProgressDialog();
        view.setUserEmptyError();
    }

    @Override
    public void onPasswordEmptyError() {
        view.hideProgressDialog();
        view.setPasswordEmptyError();
    }

    @Override
    public void onPasswordFormatError() {
        view.hideProgressDialog();
        view.setPasswordFormatError();
    }

    @Override
    public void onPasswordConfirmError() {
        view.hideProgressDialog();
        view.setPasswordConfirmError();
    }

    @Override
    public void onUserExistsError() {
        view.hideProgressDialog();
        view.setUserExistsError();
    }

    @Override
    public void onEmailEmptyError() {
        view.hideProgressDialog();
        view.setEmailEmptyError();
    }

    @Override
    public void onEmailFormatError() {
        view.hideProgressDialog();
        view.setEmailFormatError();
    }

    @Override
    public void onSuccess() {
        view.hideProgressDialog();
        view.onSuccess();
    }

    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }
}