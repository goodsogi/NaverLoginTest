package com.example.tmonet.naverlogintest;

import android.app.Application;

import com.nhn.android.naverlogin.OAuthLogin;

public class GlobalApplication extends Application {

    private static final String OAUTH_CLIENT_ID = "5Ts6FXwE3XJIQcIANLPP";
    private static final String OAUTH_CLIENT_SECRET = "3VxJVmCamM";
    private static final String OAUTH_CLIENT_NAME = "부비캐시"; //네이버 앱의 로그인 화면에 표시할 애플리케이션 이름

    @Override

    public void onCreate() {

        super.onCreate();


        // 네이버 로그인 Sdk 초기화
        initNaverLoginModule();


    }

    private void initNaverLoginModule() {
        OAuthLogin naverLoginModule = OAuthLogin.getInstance();
        naverLoginModule.init(
                GlobalApplication.this
                , OAUTH_CLIENT_ID
                , OAUTH_CLIENT_SECRET
                , OAUTH_CLIENT_NAME
                //,OAUTH_CALLBACK_INTENT
                // SDK 4.1.4 버전부터는 OAUTH_CALLBACK_INTENT변수를 사용하지 않습니다.
        );
    }
}
