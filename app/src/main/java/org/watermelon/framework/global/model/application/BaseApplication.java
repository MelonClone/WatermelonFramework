package org.watermelon.framework.global.model.application;

import android.app.Application;

public abstract class BaseApplication extends Application {

    public abstract void initiate();

    @Override
    public void onCreate() {
        super.onCreate();
        initiate();

        Initializer.init(this);
    }


}
