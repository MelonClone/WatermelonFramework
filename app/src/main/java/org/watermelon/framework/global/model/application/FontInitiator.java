package org.watermelon.framework.global.model.application;

import android.content.Context;

import org.watermelon.framework.utils.TypefaceUtil;

public abstract class FontInitiator implements Initializable {
    private boolean isInit = false;

    public abstract String getFontLocation();

    @Override
    public void init(Context appContext) {
        TypefaceUtil.overrideFont(appContext,
                "SERIF",
                getFontLocation());
        isInit = true;
    }

    @Override
    public boolean isInit() {
        return isInit;
    }

    @Override
    public String getTag() {
        return "FONT";
    }

}
