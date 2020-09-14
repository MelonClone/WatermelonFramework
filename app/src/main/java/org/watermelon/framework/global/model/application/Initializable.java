package org.watermelon.framework.global.model.application;

import android.content.Context;

public interface Initializable {
    void init(Context appContext);
    boolean isInit();
    String getTag();
}
