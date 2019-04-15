package com.example.tmonet.naverlogintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import static com.nhn.android.naverlogin.OAuthLogin.mOAuthLoginHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNaverLogin();
    }

    private void initNaverLogin() {
        OAuthLoginButton naverLoginButton = findViewById(R.id.buttonOAuthLoginImg);

        //TODO 아래코드가 필요한지 확인하세요
        naverLoginButton.setOAuthLoginHandler(new OAuthLoginHandler() {
            @Override
            public void run(boolean success) {
                if (success) {
                    Toast.makeText(MainActivity.this, "네이버 로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();
            } else {
                    String errorCode = OAuthLogin.getInstance().getLastErrorCode(MainActivity.this).getCode();
                    String errorDesc = OAuthLogin.getInstance().getLastErrorDesc(MainActivity.this);
                    Toast.makeText(MainActivity.this, "errorCode:" + errorCode
                            + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
                }}});
        //mOAuthLoginButton.setBgResourceId(R.drawable.img_loginbtn_usercustom);
    }
}
