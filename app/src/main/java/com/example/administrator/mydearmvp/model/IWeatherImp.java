package com.example.administrator.mydearmvp.model;

import java.util.Random;

/**
 * Created by Administrator on 2018\5\17 0017.
 * MODEL层的具体实现
 */

public class IWeatherImp implements IWeatherModel {

    @Override
    public String getInfo() {
        Random r = new Random();
        int seed = r.nextInt(3);

        if (seed%2 == 0){
            return "21度,晴转多云";
        }else {
            return "10度,阴天";
        }
    }

    @Override
    public void setInfo(String info) {

    }
}
