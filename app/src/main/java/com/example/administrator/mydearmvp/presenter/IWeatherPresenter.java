package com.example.administrator.mydearmvp.presenter;

import com.example.administrator.mydearmvp.model.IWeatherImp;
import com.example.administrator.mydearmvp.model.IWeatherModel;
import com.example.administrator.mydearmvp.view.IWeatherView;

/**
 * Created by Administrator on 2018\5\17 0017.
 * 具体业务逻辑处理
 */

public class IWeatherPresenter {
    IWeatherModel mModel;
    IWeatherView mView;

    public IWeatherPresenter(IWeatherView mView) {
        this.mView = mView;
        mModel = new IWeatherImp();
    }

    //显示加载框
    public void showDialog(){
        if (mView != null){
            mView.showWaitingDialog();
        }
    }

    //隐藏加载框
    public void dismissDialog(){
        if (mView != null){
            mView.dismissWaitingDialog();
        }
    }

    //显示数据
    public void updateWeatherInfo(String info){
        if (mView != null){
            mView.showInfo(info);
        }
    }

    //请求天气的数据信息供view层调用
    public void requestWeatherInfo(){
        getNetWorkInfo();
    }

    //与model层交互存储数据
    private void saveInfo(String info){
        mModel.setInfo(info);
    }

    //获取数据
    private String getInfo(){
        return mModel.getInfo();
    }

    public void getNetWorkInfo(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    showDialog();
                    Thread.sleep(3000);
                    String info = "15度,请转多云！";
                    saveInfo(info);
                    updateWeatherInfo(getInfo());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //取消加载框
                    dismissDialog();
                }
            }
        }).start();
    }
}
