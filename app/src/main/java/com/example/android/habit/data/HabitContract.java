package com.example.android.habit.data;

import android.provider.BaseColumns;

/**
 * Created by iyudhi on 7/9/2017.
 */

public class HabitContract {

    //so it's not accidentally called outside this class
    private HabitContract() {}

    public static final class HabitEntry implements BaseColumns {

        //name of table
        public final static String TABLE_NAME = "habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT_NAME = "name";
        public final static String COLUMN_HABIT_TIME = "time";

        //constants for (habit) activity time
        public final static int TIME_UNKNOWN = 0;
        public final static int TIME_MORNING = 1;
        public final static int TIME_AFTERNOON = 2;
        public final static int TIME_EVENING = 3;

    }

}
