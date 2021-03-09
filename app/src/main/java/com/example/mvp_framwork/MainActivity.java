package com.example.mvp_framwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mvp_framwork.base.BaseMVPActivity;
import com.example.mvp_framwork.bean.BaseObjectBean;
import com.example.mvp_framwork.contract.LoginContract;
import com.example.mvp_framwork.present.LoginPresenter;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends BaseMVPActivity<LoginPresenter> implements LoginContract.View {

    TextInputEditText etUsernameLogin;
    TextInputEditText etPasswordLogin;
    Button btnSigninLogin,btn_register;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        etUsernameLogin = findViewById(R.id.et_username_login);
        etPasswordLogin = findViewById(R.id.et_password_login);
        btnSigninLogin = findViewById(R.id.btn_signin_login);
        btn_register = findViewById(R.id.btn_register);

        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
        btnSigninLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getUsername().isEmpty() || getPassword().isEmpty()) {
                    Toast.makeText(MainActivity.this, "帐号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mPresenter.login(getUsername(),getPassword());
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)!=
                        PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
                } else {
                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    /**
     * @return 帐号
     */
    private String getUsername() {
        return etUsernameLogin.getText().toString().trim();
    }

    /**
     * @return 密码
     */
    private String getPassword() {
        return etPasswordLogin.getText().toString().trim();
    }

    @Override
    public void onSuccess(BaseObjectBean bean) {
//        startActivity(new Intent(MainActivity.this,SuccessActivity.class));
//        finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String errMessage) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"denied",Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }
}