package com.example.pawsforperfection;

import android.provider.BaseColumns;

public class PetReaderContract {

    private PetReaderContract() {
    }

    public static class PetEntry implements BaseColumns {
        public static final String TABLE_NAME = "pets";
        public static final String COLUMN_NAME_PET_NAME = "pet_name";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_INSTRUCTIONS = "instructions";
        public static final String COLUMN_NAME_BREED = "breed";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PetEntry.TABLE_NAME + " (" +
                    PetEntry._ID + " INTEGER PRIMARY KEY," +
                    PetEntry.COLUMN_NAME_PET_NAME + " TEXT," +
                    PetEntry.COLUMN_NAME_WEIGHT + " DECIMAL," +
                    PetEntry.COLUMN_NAME_INSTRUCTIONS + " TEXT," +
                    PetEntry.COLUMN_NAME_BREED + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;

}
