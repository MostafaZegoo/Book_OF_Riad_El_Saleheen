package com.mostafa.book_of_riad_el_saleheen.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mostafa.book_of_riad_el_saleheen.model.Ahadith;
import com.mostafa.book_of_riad_el_saleheen.model.Books;
import com.mostafa.book_of_riad_el_saleheen.model.Chapters;

import java.util.LinkedList;
import java.util.List;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context The context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of books
     */

    public List<Books> getBooks() {

        List<Books> books = new LinkedList<>();

        String[] Columns = {DatabaseOpenHelper.Constants.COLUMN_BOOK_ID,
                DatabaseOpenHelper.Constants.COLUMN_AR_NAME,
                DatabaseOpenHelper.Constants.COLUMN_EN_NAME};

        Cursor cursor = database.query(DatabaseOpenHelper.Constants.BOOKS_TABLE, Columns, null, null, null, null, null);


        if (cursor == null) return null;

        cursor.moveToFirst();

        do {

            books.add(Books.get(cursor));

        } while (cursor.moveToNext());

        cursor.close();

        return books;
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of chapters
     */
    public List<Chapters> getChapters(String book_id) {

        List<Chapters> chapters = new LinkedList<>();

        String[] Columns = {DatabaseOpenHelper.Constants.COLUMN_BOOK_ID,
                DatabaseOpenHelper.Constants.COLUMN_CHAPTER_ID,
                DatabaseOpenHelper.Constants.COLUMN_AR_NAME,
                DatabaseOpenHelper.Constants.COLUMN_EN_NAME,
                DatabaseOpenHelper.Constants.COLUMN_CHAPTER_INTRO};

        Cursor cursor = database.query(DatabaseOpenHelper.Constants.CHAPTERS_TABLE, Columns,
                DatabaseOpenHelper.Constants.COLUMN_BOOK_ID+" = '"+book_id+"'",
                null, null, null, null);


        if (cursor == null) return null;

        cursor.moveToFirst();

        do {

            chapters.add(Chapters.get(cursor));

        } while (cursor.moveToNext());

        cursor.close();

        return chapters;
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of Ahadith
     */
    public List<Ahadith> getAhadith() {

        List<Ahadith> ahadith = new LinkedList<>();

        String[] Columns = {DatabaseOpenHelper.Constants.COLUMN_BOOK_ID,
                DatabaseOpenHelper.Constants.COLUMN_CHAPTER_ID,
                DatabaseOpenHelper.Constants.COLUMN_HADITH_ID,
                DatabaseOpenHelper.Constants.COLUMN_EN_SANAD,
                DatabaseOpenHelper.Constants.COLUMN_EN_TEXT,
                DatabaseOpenHelper.Constants.COLUMN_AR_SANAD,
                DatabaseOpenHelper.Constants.COLUMN_AR_TEXT,
                DatabaseOpenHelper.Constants.COLUMN_READ_COLUMN,
                DatabaseOpenHelper.Constants.COLUMN_MARK_COLUMN};

        Cursor cursor = database.query(DatabaseOpenHelper.Constants.AHADITH_TABLE, Columns,
                null, null, null, null, null);


        if (cursor == null) return null;

        cursor.moveToFirst();

        do {

            ahadith.add(Ahadith.get(cursor));

        } while (cursor.moveToNext());

        cursor.close();

        return ahadith;
    }

    /**
     * Read all quotes from the database.
     *
     * @return Index of the first hadith in the chapter
     */
    public String getHadithIndex(String book_id, String chapter_id) {

        String[] Columns = {DatabaseOpenHelper.Constants.COLUMN_HADITH_ID};

        String[] selectionArgs = {book_id, chapter_id};

        String firstHadithIndex = "No_Index";

        try (Cursor cursor = database.query(DatabaseOpenHelper.Constants.AHADITH_TABLE, Columns,
                DatabaseOpenHelper.Constants.COLUMN_BOOK_ID + " =? AND " +
                        DatabaseOpenHelper.Constants.COLUMN_CHAPTER_ID + " =? ",
                selectionArgs, null, null, null)) {

            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                int index1 = cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_HADITH_ID);
                firstHadithIndex = cursor.getString(index1);
            }

            cursor.close();

            return firstHadithIndex;

        }

    }

}
