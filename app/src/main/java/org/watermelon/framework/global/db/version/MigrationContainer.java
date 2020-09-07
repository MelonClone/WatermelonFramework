package org.watermelon.framework.global.db.version;

import androidx.room.migration.Migration;

import java.util.List;

public interface MigrationContainer {

    Migration[] getMigrationListAsArray();
    List<Migration> getMigrationList();
}
