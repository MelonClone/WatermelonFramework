package org.watermelon.framework.utils.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;

import org.watermelon.framework.global.consts.Constants;
import org.watermelon.framework.global.db.version.VersionMigration;


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

    public <D extends RoomDatabase> void init(Context appContext, Class<D> database) {
        this.appContext = appContext;
        this.database = Room.databaseBuilder(appContext.getApplicationContext(),
                database, Constants.DB_NAME+".db")
                .addMigrations(VersionMigration.getInstance().getMigrationList().toArray(new Migration[0]))
                .build();
    }

    public RoomDatabase getDB() {
        return database;
    }
}
