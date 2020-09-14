package org.watermelon.framework.global.model.application;

import android.content.Context;

import org.watermelon.framework.utils.db.SPHelper;

public abstract class SharedPreferenceInitiator implements Initializable {
    private boolean isInit = false;

    public abstract String getSharedPreferenceName();

    @Override
    public void init(Context appContext) {
        SPHelper.getInstance().init(appContext);
        isInit = true;
    }

    @Override
    public boolean isInit() {
        return isInit;
    }

    @Override
    public String getTag() {
        return "SP";
    }

}
