package com.fastapputil.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fastapputil.R;
import com.fastapputil.util.CommonUtil;
import com.fastapputil.widget.dialog.MProgressDialog;
import com.fastapputil.widget.swipeback.app.SwipeBackActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * created by bcoly on 2017/7/21.
 */

public abstract class BaseActivity extends SwipeBackActivity {
    protected Context mContext;
    private View mTitleView;
    private MProgressDialog progressDialog;
    protected View mProgressView;

    private View mLeftAction;
    private ImageView mLeftImg;
    private TextView mLeftLabel;
    private TextView mMiddleLabel;
    private View mRightAction;
    private ImageView mRightImg;
    private TextView mRightLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initViewId());
        ButterKnife.bind(this);
        AppManager.getAppManager().addActivity(this);

        if (registerEventBus()) {
            EventBus.getDefault().register(mContext);
        }


        setSwipeBackEnable(enableSwipeBack());

        initProgressBar();

        initHeaderTitle();

        initView();

        initViewListener();

        process(savedInstanceState);



    }


    public void showProgressDialog() {
        try {
            View currentFocus = getCurrentFocus();
            CommonUtil.hideSoftInput(mContext, currentFocus);
        } catch (Exception ignored) {
        }
        if (progressDialog == null) {
            progressDialog = new MProgressDialog(mContext);
        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }


    public void showProgressDialog(String label) {
        View currentFocus = getCurrentFocus();
        CommonUtil.hideSoftInput(mContext, currentFocus);
        if (progressDialog == null) {
            progressDialog = new MProgressDialog(mContext);
        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }


    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            progressDialog.dismiss();
        }
    }


    protected abstract void process(Bundle savedInstanceState);


    protected void initViewListener() {

    }

    protected void initView() {

    }

    private void initHeaderTitle() {
        mTitleView = findViewById(R.id.mHeadTitle);

        if (mTitleView != null) {
            mLeftAction = findViewById(R.id.mLeftAction);
            mLeftImg = (ImageView) findViewById(R.id.mLeftImg);
            mLeftLabel = (TextView) findViewById(R.id.mLeftLabel);
            mMiddleLabel = (TextView) findViewById(R.id.mMiddleLabel);
            mRightAction = findViewById(R.id.mRightAction);
            mRightImg = (ImageView) findViewById(R.id.mRightImg);
            mRightLabel = (TextView) findViewById(R.id.mRightLabel);

            setLeftIcon(R.drawable.back, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            initTitleBar();
        }
    }
    protected void initTitleBar() {

    }
    public void setLeftIcon(int resource_id, View.OnClickListener onClickListener) {
        if (mLeftAction != null && mLeftImg != null) {
            mLeftImg.setVisibility(View.VISIBLE);
            mLeftImg.setImageResource(resource_id);
            mLeftAction.setOnClickListener(onClickListener);
        }
    }

    private void initProgressBar() {
        mProgressView = findViewById(R.id.mProgressView);
    }

    /**
     * @return // 可以调用该方法，设置是否允许滑动退出
     */
    public boolean enableSwipeBack() {
        return false;
    }

    /**
     * @return // 可以调用该方法，设置是否允许注册 EventBus
     */
    public boolean registerEventBus() {
        return false;
    }
    protected abstract int initViewId();

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
        if (registerEventBus()) {
            EventBus.getDefault().unregister(mContext);
        }
    }
}
