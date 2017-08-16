package com.fastapputil.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fastapputil.R;
import com.fastapputil.widget.dialog.MProgressDialog;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by oyty on 11/4/16.
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    protected View mView;
    private View mTitleView;
    protected View mProgressView;
    private View mLeftAction;
    private ImageView mLeftImg;
    private TextView mLeftLabel;
    private TextView mMiddleLabel;
    private View mRightAction;
    private ImageView mRightImg;
    private TextView mRightLabel;

    private MProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        if (registerEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    public boolean registerEventBus() {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(initViewId(), null);
        ButterKnife.bind(this, mView);
        initProgressBar();
        initHeaderTitle();
        initView(mView);
        initViewListener();
        return mView;
    }

    private void initHeaderTitle() {
//        mTitleView = mView.findViewById(R.id.mHeadTitle);
        mTitleView = mView.findViewById(R.id.toolbar);
        if (mTitleView != null) {
            mLeftAction = mTitleView.findViewById(R.id.mLeftAction);
            mLeftImg = (ImageView) mTitleView.findViewById(R.id.mLeftImg);
            mLeftLabel = (TextView) mTitleView.findViewById(R.id.mLeftLabel);
            mMiddleLabel = (TextView) mTitleView.findViewById(R.id.mMiddleLabel);
            mRightAction = mTitleView.findViewById(R.id.mRightAction);
            mRightImg = (ImageView) mTitleView.findViewById(R.id.mRightImg);
            mRightLabel = (TextView) mTitleView.findViewById(R.id.mRightLabel);

            initTitleBar();
        }
    }

    private void initProgressBar() {
        mProgressView = mView.findViewById(R.id.mProgressView);
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


    public void setTitle(int resource_id) {
        if (mMiddleLabel != null) {
            mMiddleLabel.setVisibility(View.VISIBLE);
            mMiddleLabel.setText(resource_id);
        }
    }

    public void setTitle(int resource_id, int color) {
        if (mMiddleLabel != null) {
            mMiddleLabel.setVisibility(View.VISIBLE);
            mMiddleLabel.setText(resource_id);
            mMiddleLabel.setTextColor(mContext.getResources().getColor(color));
        }
    }

    public void setTitle(String resource) {
        if (mMiddleLabel != null) {
            mMiddleLabel.setVisibility(View.VISIBLE);
            mMiddleLabel.setText(resource);
        }
    }

    public void setRightIcon(int resource_id, View.OnClickListener onClickListener) {
        if (mRightAction != null && mRightImg != null) {
            mRightImg.setVisibility(View.VISIBLE);
            mRightImg.setImageResource(resource_id);
            mRightAction.setOnClickListener(onClickListener);
        }
    }

    public void setRightLabel(String resource, View.OnClickListener onClickListener) {
        if (mRightAction != null && mRightLabel != null) {
            mRightLabel.setVisibility(View.VISIBLE);
            mRightLabel.setText(resource);
            mRightAction.setOnClickListener(onClickListener);
        }
    }

    protected void initViewListener() {

    }

    protected void initView(View view) {
    }

    protected void dismissProgressBar() {
        if (mProgressView != null) {
            mProgressView.setVisibility(View.GONE);
        }
    }

    public void showProgressDialog() {
        ((BaseActivity)mContext).showProgressDialog();
    }

    public void dismissProgressDialog() {
        ((BaseActivity)mContext).dismissProgressDialog();
    }

    protected abstract int initViewId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        process();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*mContext = getActivity();
        process();*/
    }

    protected abstract void process();

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (registerEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }
}
