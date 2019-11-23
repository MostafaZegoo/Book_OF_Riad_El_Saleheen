package com.mostafa.book_of_riad_el_saleheen.repository;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {

    DatabaseOpenHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    public class Constants {

        static final String DATABASE_NAME = "book.sqlite";

        static final int DATABASE_VERSION = 1;

        static final String BOOKS_TABLE = "Books";

        static final String CHAPTERS_TABLE = "Chapters";

        static final String AHADITH_TABLE = "Ahadith";

        public static final String COLUMN_BOOK_ID = "Book_ID";

        public static final String COLUMN_AR_NAME = "Ar_Name";

        public static final String COLUMN_EN_NAME = "En_Name";

        public static final String COLUMN_CHAPTER_ID = "Chapter_ID";

        public static final String COLUMN_CHAPTER_INTRO = "Chapter_Intro";

        public static final String COLUMN_HADITH_ID = "Hadith_ID";

        public static final String COLUMN_EN_SANAD = "En_Sanad";

        public static final String COLUMN_EN_TEXT = "En_Text";

        public static final String COLUMN_AR_SANAD = "Ar_Sanad_1";

        public static final String COLUMN_AR_TEXT = "Ar_Text";

        public static final String COLUMN_READ_COLUMN = "read_column";

        public static final String COLUMN_MARK_COLUMN = "mark_column";

    }

}
