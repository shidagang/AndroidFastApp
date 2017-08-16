package com.fastapputil.widget.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * created by bcoly on 2017/7/20.
 */

@SuppressLint("AppCompatCustomView")
public class StartPageTimerView extends TextView {
    private Context mContext;

    private OnTimeFinishListener listener;

    public StartPageTimerView(Context context) {
        this(context, null);
    }

    public StartPageTimerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StartPageTimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onTimeFinish();
                }
            }
        });

    }

    public void setOnTimeFinishListener(OnTimeFinishListener listener) {
        this.listener = listener;
    }

    public interface OnTimeFinishListener {
        void onTimeFinish();
    }



    public void startCountDown() {
        MyCountDownTimer timer = new MyCountDownTimer(4000, 1000);
        timer.start();
    }

    class MyCountDownTimer extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            setText((millisUntilFinished / 1000) + "s");
            if (listener != null && millisUntilFinished / 1000 == 1) {
                listener.onTimeFinish();
            }
        }

        @Override
        public void onFinish() {

        }
    }

}
