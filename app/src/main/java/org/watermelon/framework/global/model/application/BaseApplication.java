package org.watermelon.framework.global.model.application;

import android.app.Application;

import androidx.room.RoomDatabase;

import org.watermelon.framework.utils.TypefaceUtil;
import org.watermelon.framework.utils.db.DBHelper;
import org.watermelon.framework.utils.db.SPHelper;

public abstract class BaseApplication extends Application {

    public abstract String getDatabaseName();
    public abstract String getSharedPreferenceName();
    public abstract <D extends RoomDatabase> Class<D> getDatabaseClass();

    @Override
    public void onCreate() {
        super.onCreate();
        Initializer.init(
                getDatabaseName(),
                getSharedPreferenceName()
        );

        if (getDatabaseClass() != null) {
            DBHelper.getInstance().init(this, getDatabaseClass());
        }
        SPHelper.getInstance().init(this);

        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/NotoSans-Regular.ttf");
    }


}
