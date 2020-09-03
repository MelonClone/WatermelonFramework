package org.watermelon.framework.global.model.application;

public class Initializer {
    private static String dbName = "";
    private static String spName = "";

    public static String getDatabaseName() {
        return dbName;
    }

    public static String getSharedPreferenceName() {
        return spName;
    }

    public static void init(String dbName, String spName) {
        Initializer.dbName = dbName;
        Initializer.spName = spName;
    }
}
