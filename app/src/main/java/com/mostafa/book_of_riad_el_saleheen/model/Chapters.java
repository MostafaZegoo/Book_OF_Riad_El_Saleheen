package com.mostafa.book_of_riad_el_saleheen.model;

import android.database.Cursor;

import com.mostafa.book_of_riad_el_saleheen.repository.DatabaseOpenHelper;

import java.io.Serializable;

public class Chapters implements Serializable {

    private long Book_ID;
    private long Chapter_ID;
    private String Ar_Name;
    private String En_Name;
    private String Chapter_Intro;


    private Chapters() {

    }

    public static Chapters get(Cursor cursor) {

        Chapters chapter = new Chapters();

        chapter.setAr_Name(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_AR_NAME)));
        chapter.setEn_Name(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_EN_NAME)));
        chapter.setBook_ID(cursor.getLong(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_BOOK_ID)));
        chapter.setChapter_ID(cursor.getLong(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_CHAPTER_ID)));
        chapter.setChapter_Intro(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_CHAPTER_INTRO)));

        return chapter;
    }

    public String getEn_Name() {
        return En_Name;
    }

    private void setEn_Name(String en_Name) {
        En_Name = en_Name;
    }

    public String getAr_Name() {
        return Ar_Name;
    }

    private void setAr_Name(String ar_Name) {
        Ar_Name = ar_Name;
    }

    public long getBook_ID() {
        return Book_ID;
    }

    private void setBook_ID(long book_ID) {
        Book_ID = book_ID;
    }

    public String getChapter_Intro() {
        return Chapter_Intro;
    }

    private void setChapter_Intro(String chapter_Intro) {
        Chapter_Intro = chapter_Intro;
    }

    public long getChapter_ID() {
        return Chapter_ID;
    }

    private void setChapter_ID(long chapter_ID) {
        Chapter_ID = chapter_ID;
    }

}
