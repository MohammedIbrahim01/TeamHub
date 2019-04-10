package com.abdelazim.x.teamhub.repository.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {LocalAccount.class}, version = 1, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {

    private static final String LOCAL_DATABASE = "local-database";
    private static final Object LOCK = new Object();
    private static LocalDatabase sInstance;

    public static LocalDatabase getInstance(Context context) {

        if (sInstance == null) {
            synchronized (LOCK) {

                sInstance = Room.databaseBuilder(context, LocalDatabase.class, LOCAL_DATABASE)
                        .allowMainThreadQueries()   // remove this line
                        .build();
            }

        }
        return sInstance;
    }

    public abstract LocalAccountDao localAccountDao();
}
