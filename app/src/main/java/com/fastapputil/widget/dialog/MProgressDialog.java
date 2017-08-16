package com.fastapputil.widget.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.fastapputil.R;


/**
 * Created by oyty on 10/26/16.
 */

public class MProgressDialog extends ProgressDialog {

    private String label;

    public MProgressDialog(Context context) {
        this(context, R.style.ProgressDialogStyle);
    }

    public MProgressDialog(Context context, String label) {
        this(context, R.style.ProgressDialogStyle);
        this.label = label;
    }

    public MProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }

    private void init(Context context) {
        setCanceledOnTouchOutside(false);
        setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                }
                return false;
            }
        });
        View view = View.inflate(context, R.layout.loading_dialog, null);
        setContentView(view);
        TextView mLoadingLabel = (TextView) view.findViewById(R.id.mLoadingLabel);
        if(!TextUtils.isEmpty(label)) {
            mLoadingLabel.setText(label);
        }
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = context.getResources().getDimensionPixelOffset(R.dimen.x640);
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

}
