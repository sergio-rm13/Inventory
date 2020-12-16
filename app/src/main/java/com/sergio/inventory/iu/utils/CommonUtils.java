package com.sergio.inventory.iu.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.sergio.inventory.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public final class CommonUtils {
    public static boolean isPasswordValid(String password){
        Pattern pattern = Pattern.compile("(^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,12}$)");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public static boolean isEmailValid(String email){
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static ProgressDialog showLoadingDialog(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context);
        //hay que visualizar prgress bar para posicionar la vista
        progressDialog.show();
        if(progressDialog.getWindow() != null){
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        return progressDialog;
    }
}
