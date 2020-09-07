package org.watermelon.framework.utils.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import org.watermelon.framework.global.consts.Constants;
import org.watermelon.framework.global.db.version.MigrationContainer;


public class DBHelper {

    private static DBHelper INSTANCE;
    private RoomDatabase database;
    private Context appContext;

    private DBHelper() {
    }

    public static DBHelper getInstance() {
        if (INSTANCE == null) {
            synchronized (DBHelper.class) {
                INSTANCE = new DBHelper();
            }
        }

        return INSTANCE;
    }

    public <D extends RoomDatabase> void init(Context appContext, Class<D> database, MigrationContainer migrationContainer) {
        this.appContext = appContext;

        RoomDatabase.Builder<D> roomBuilder = Room.databaseBuilder(appContext.getApplicationContext(),
                database, Constants.DB_NAME+".db");
        if (migrationContainer.getMigrationListAsArray() != null) {
            roomBuilder.addMigrations(migrationContainer.getMigrationListAsArray());
        }
        this.database = roomBuilder.build();
    }

    public RoomDatabase getDB() {
        return database;
    }
}
