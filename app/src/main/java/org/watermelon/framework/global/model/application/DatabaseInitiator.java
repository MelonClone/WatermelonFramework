package org.watermelon.framework.global.model.application;

import android.content.Context;

import androidx.room.RoomDatabase;

import org.watermelon.framework.global.db.version.MigrationContainer;
import org.watermelon.framework.utils.db.DBHelper;

public abstract class DatabaseInitiator implements Initializable {
    private boolean isInit = false;

    public abstract String getDatabaseName();
    public abstract <D extends RoomDatabase> Class<D> getDatabaseClass();
    public abstract MigrationContainer getMigrationContainer();

    @Override
    public void init(Context appContext) {
        DBHelper.getInstance().init(appContext, getDatabaseClass(), getMigrationContainer());
        isInit = true;
    }

    @Override
    public boolean isInit() {
        return isInit;
    }

    @Override
    public String getTag() {
        return "DB";
    }
}
