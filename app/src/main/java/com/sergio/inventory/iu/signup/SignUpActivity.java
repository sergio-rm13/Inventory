package com.sergio.inventory.iu.signup;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import com.sergio.inventory.iu.InventoryActivity;
import com.sergio.inventory.iu.utils.CommonUtils;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.sergio.inventory.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity implements SignupContract.View {
    private SignupContract.Presenter presenter;
    private ProgressDialog progressDialog;

    private String user;
    private String password;
    private String confirmPassword;
    private String email;

    private TextInputLayout tilUser;
    private TextInputLayout tilPassword;
    private TextInputLayout tilConfirmPassword;
    private TextInputLayout tilEmail;

    private TextInputEditText tieUser;
    private TextInputEditText tiePassword;
    private TextInputEditText tieConfirmPassword;
    private TextInputEditText tieEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        tilUser = findViewById(R.id.tilUser);
        tieUser = findViewById(R.id.tieUser);
        tilPassword = findViewById(R.id.tilPassword);
        tiePassword = findViewById(R.id.tiePassword);
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword);
        tieConfirmPassword = findViewById(R.id.tieConfirmPassword);
        tilEmail = findViewById(R.id.tilEmail);
        tieEmail = findViewById(R.id.tieEmail);

        tieUser.addTextChangedListener(new SignupTextWatcher(tieUser));
        tiePassword.addTextChangedListener(new SignupTextWatcher(tiePassword));
        tieConfirmPassword.addTextChangedListener(new SignupTextWatcher(tieConfirmPassword));
        tieEmail.addTextChangedListener(new SignupTextWatcher(tieEmail));

        presenter = new SignupPresenter(this);
    }

    public void signUp(View view) {
        user = tieUser.getText().toString();
        password = tiePassword.getText().toString();
        confirmPassword = tieConfirmPassword.getText().toString();
        email = tieEmail.getText().toString();

        presenter.addUser(user, password, confirmPassword, email);
    }

    @Override
    public void showProgressDialog() {
        progressDialog = CommonUtils.showLoadingDialog(this);
        //progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void setUserExistsError() {
        Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.err_user_exists), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordConfirmError() {
        tilConfirmPassword.setError(getString(R.string.err_confirm_password));
        showSoftKeyboard(tieConfirmPassword);
    }

    @Override
    public void setEmailEmptyError() {
        tilEmail.setError(getString(R.string.err_email_empty));
        showSoftKeyboard(tieEmail);
    }

    @Override
    public void setEmailFormatError() {
        tilEmail.setError(getString(R.string.err_email_format));
        showSoftKeyboard(tieEmail);
    }

    @Override
    public void setUserEmptyError() {
        tilUser.setError(getString(R.string.err_user_empty));
        showSoftKeyboard(tieUser);
    }

    @Override
    public void setPasswordEmptyError() {
        tilPassword.setError(getString(R.string.err_password_empty));
        showSoftKeyboard(tiePassword);
    }

    @Override
    public void setPasswordFormatError() {
        tilPassword.setError(getString(R.string.err_password_format));
        showSoftKeyboard(tiePassword);
    }

    @Override
    public void onSuccess() {
        Intent intent = new Intent(SignUpActivity.this, InventoryActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    class SignupTextWatcher implements TextWatcher {
        private View view;

        SignupTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.tieUser:
                    validateUser();
                    break;
                case R.id.tiePassword:
                    validatePassword();
                    break;
                case R.id.tieConfirmPassword:
                    validateConfirmPassword();
                    break;
                case R.id.tieEmail:
                    validateEmail();
                    break;
            }
        }
    }

    private void validateUser() {
        if (tieUser.getText().toString().trim().isEmpty()) {
            tilUser.setError(getString(R.string.err_user_empty));
            showSoftKeyboard(tieUser);
        } else {
            tilUser.setErrorEnabled(false);
        }
    }

    private void validatePassword() {
        if (tiePassword.getText().toString().trim().isEmpty()) {
            tilPassword.setError(getString(R.string.err_password_empty));
            showSoftKeyboard(tiePassword);

        } else if (tiePassword.getText().toString().length() < 8) {
            tilPassword.setError(getString(R.string.err_password_format));
            showSoftKeyboard(tiePassword);
        } else {
            tilPassword.setErrorEnabled(false);
        }
    }

    private void validateConfirmPassword() {
        if (!tiePassword.getText().toString().trim().equals(tieConfirmPassword.getText().toString())) {
            tilConfirmPassword.setError(getString(R.string.err_confirm_password));
            showSoftKeyboard(tieConfirmPassword);
        } else {
            tilConfirmPassword.setErrorEnabled(false);
        }
    }

    private void validateEmail() {
        if (tieEmail.getText().toString().trim().isEmpty()) {
            tilEmail.setError(getString(R.string.err_email_empty));
            showSoftKeyboard(tieEmail);
        } else {
            tilEmail.setErrorEnabled(false);
        }
    }

    public void showSoftKeyboard(View view) {
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public void hideSoftKeyboard(View view) {
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}