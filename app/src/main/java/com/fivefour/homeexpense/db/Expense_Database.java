package com.fivefour.homeexpense.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import static androidx.room.Room.*;

@Database(entities = {Expense.class}, version = 1)
public abstract class Expense_Database extends RoomDatabase {


    // access database operations that we are added to dao class
    public abstract Expense_Dao expense_dao();

    private static volatile Expense_Database INSTANCE;
    private Context context;

    public static Expense_Database getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (Expense_Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Expense_Database.class, "Expense_Database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}
