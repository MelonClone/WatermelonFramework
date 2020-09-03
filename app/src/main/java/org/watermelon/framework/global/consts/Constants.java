package org.watermelon.framework.global.consts;

import org.watermelon.framework.global.model.application.Initializer;

public abstract class Constants {
    static {
        DB_NAME = Initializer.getDatabaseName();
        SP_NAME = Initializer.getSharedPreferenceName();
    }
    public static final String API_PROTOCOL = "http://";
    public static final String API_SERVER = "192.168.0.38:8099";

    public static final String DB_NAME;
    public static final String SP_NAME;

    public enum Theme { COLOR_LIGHT, COLOR_DARK }
}
