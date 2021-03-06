package com.example.android.habit.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import com.example.android.habit.data.HabitContract.HabitEntry;

/**
 * Created by iyudhi on 7/9/2017.
 */

public class HabitDBHelper extends SQLiteOpenHelper {

    //make constants for database name and version
    private static final String DATABASE_NAME = "habits.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table habits
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + "("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_TIME + " INTEGER NOT NULL);";

        //execute the query
        db.execSQL(SQL_CREATE_HABITS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //reads all of the information from the database and returns a Cursor object.
    public Cursor readAllHabits() {
        //gets the repo in read mode
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = { HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_TIME };
        String selection = HabitEntry.COLUMN_HABIT_TIME + "=?";
        String [] selectionArgs = new String[] { String.valueOf(HabitEntry.TIME_MORNING) };

        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projection,
                selection, selectionArgs,
                null, null, null);

        return cursor;
    }
}
