package com.example.administrator.mydearmvp.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mydearmvp.R;
import com.example.administrator.mydearmvp.presenter.IWeatherPresenter;

public class MainActivity extends AppCompatActivity implements IWeatherView{
    IWeatherPresenter mPresenter;
    private TextView mTvInfo;
    private Button mButton;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new IWeatherPresenter(this);
        mTvInfo = (TextView) findViewById(R.id.tv_info);
        mButton = (Button) findViewById(R.id.btn_request);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.requestWeatherInfo();
            }
        });
    }

    @Override
    public void showInfo(final String info) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvInfo.setText(info);
            }
        });
    }

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog !=null && mDialog.isShowing()){
                    mDialog.dismiss();
                }

                mDialog = ProgressDialog.show(MainActivity.this,"","正在加载中...");
            }
        });
    }

    @Override
    public void dismissWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isShowing()){
                    mDialog.dismiss();
                }
            }
        });
    }
}
