package com.young.offlinesearchmovies;

import android.app.Application;
import android.content.Context;

public class ForTraslate extends Application {
    private static ForTraslate instance;
    public static ForTraslate getInstance() {return instance;}
    public static Context getContext() {return instance;}

    @Override
    public void onCreate(){
        instance = this;
        super.onCreate();
    }
}
