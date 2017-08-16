package com.fastapputil.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fastapputil.MainActivity;
import com.fastapputil.R;
import com.fastapputil.util.PreferenceHelper;
import com.fastapputil.widget.custom.StartPageTimerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * created by bcoly on 2017/7/20.
 */

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.mSplashImg)
    ImageView mSplashImg;
    @BindView(R.id.mTimeAction)
    StartPageTimerView mTimeAction;
    @BindView(R.id.mSkipAction)
    RelativeLayout mSkipAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        mTimeAction.startCountDown();
        mTimeAction.setOnTimeFinishListener(new StartPageTimerView.OnTimeFinishListener() {
            @Override
            public void onTimeFinish() {
                if (PreferenceHelper.isFirstIn()) {
                    gotoGuideActivity();
                } else {
                    gotoMainActivity();
                }
            }
        });
    }

    private void gotoMainActivity() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

    private void gotoGuideActivity() {
        startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        finish();
    }
}
