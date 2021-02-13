package com.example.greendaomigration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OpenHelper extends DaoMaster.DevOpenHelper {

    private static final String TAG = "OpenHelper";

    public OpenHelper(Context context, String name) {
        super(context, name);
    }

    public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
            List<Migration> migrations = getMigrations();

            // Only run migrations past the old version
            for (Migration migration : migrations) {
                if (oldVersion < migration.getVersion()) {
                    migration.runMigration(db);
                }
            }
    }

    private List<Migration> getMigrations() {
        List<Migration> migrations = new ArrayList<>();

        // Sorting just to be safe, in case other people add migrations in the wrong order.
        Comparator<Migration> migrationComparator = new Comparator<Migration>() {
            @Override
            public int compare(Migration m1, Migration m2) {
                return m1.getVersion().compareTo(m2.getVersion());
            }
        };
        Collections.sort(migrations, migrationComparator);

        return migrations;
    }

    private interface Migration {
        Integer getVersion();

        void runMigration(Database db);
    }
}
