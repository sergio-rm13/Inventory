package com.sergio.inventory.iu.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.sergio.inventory.R;
import com.sergio.inventory.iu.InventoryActivity;
import com.sergio.inventory.iu.signup.SignUpActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginContract.Presenter presenter;
    private ProgressBar progressBar;

    private TextInputLayout tilUser;
    private TextInputLayout tilPassword;

    private TextInputEditText tieUser;
    private TextInputEditText tiePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBar);
        tilUser = findViewById(R.id.tilUser);
        tilPassword = findViewById(R.id.tilPassword);
        tieUser = findViewById(R.id.tieUser);
        tiePassword = findViewById(R.id.tiePassword);

        tieUser.addTextChangedListener(new LoginTextWatcher(tieUser));
        tiePassword.addTextChangedListener(new LoginTextWatcher(tiePassword));

        presenter = new LoginPresenter(this);
    }

    public void showSignUp(View view) {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void validateUser(View view) {
        presenter.validateCredentials(tieUser.getText().toString(), tiePassword.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setAuthenticationError() {
        // Snackbar.make(findViewById(R.id.llcontainer), getResources().getString(R.string.err_authentication), Snackbar.LENGTH_SHORT).show();
        //Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.err_authentication), Snackbar.LENGTH_SHORT).show();
        showError(getResources().getString(R.string.err_authentication));
    }

    private void showError(String message) {
        //1. Inflar la vista snackBar_view.xml
        View view = ((LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.snackbar_view, null);
        TextView tvMessage = view.findViewById(R.id.tvMessage);
        tvMessage.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        tvMessage.setText(message);

        //2. Vamos acrear un objeto snackbar genérico
        //Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "", Snackbar.LENGTH_SHORT);
        Snackbar snackbar = Snackbar.make(findViewById(R.id.llcontainer), "", Snackbar.LENGTH_SHORT);

        //3. Vamos a personalizar el layout del snackbar
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        layout.setPadding(5,0,5, 0);
        layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));

        //4. añadimos nuestro objeto view al layout
        layout.addView(view);

        //5. se muestra el snackbar
        snackbar.show();

    }

    @Override
    public void setUserEmptyError() {
        tilUser.setError(getResources().getString(R.string.err_user_empty));
        showSoftKeyboard(tieUser);
    }

    @Override
    public void setPasswordEmptyError() {
        tilPassword.setError(getResources().getString(R.string.err_password_empty));
        showSoftKeyboard(tiePassword);
    }

    @Override
    public void setPasswordFormatError() {
        tilPassword.setError(getResources().getString(R.string.err_password_format));
        showSoftKeyboard(tiePassword);
    }

    @Override
    public void onSuccess() {
        Intent intent = new Intent(LoginActivity.this, InventoryActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    class LoginTextWatcher implements TextWatcher {
        private View view;

        LoginTextWatcher(View view) {
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
                    validateUser(tieUser.getText().toString());
                    break;
                case R.id.tiePassword:
                    validatePassword(tiePassword.getText().toString());
                    break;
            }
        }
    }

    private void validateUser(String password) {
        if (tieUser.getText().toString().trim().isEmpty()) {
            tilUser.setError(getString(R.string.err_user_empty));
            showSoftKeyboard(tieUser);
        } else {
            tilUser.setErrorEnabled(false);
        }

    }

    private void validatePassword(String password) {
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