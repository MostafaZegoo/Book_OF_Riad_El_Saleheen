package com.mostafa.book_of_riad_el_saleheen.model;

import android.database.Cursor;


import com.mostafa.book_of_riad_el_saleheen.repository.DatabaseOpenHelper;

import java.io.Serializable;

public class Ahadith implements Serializable {

    private long Book_ID;
    private long Chapter_ID;
    private long Hadith_ID;
    private String En_Sanad;
    private String En_Text;
    private String Ar_Sanad_1;
    private String Ar_Text;
    private String Read_Column;
    private String Mark_Column;


    private Ahadith() {

    }

    public static Ahadith get(Cursor cursor) {

        Ahadith hadith = new Ahadith();

        hadith.setBook_ID(cursor.getLong(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_BOOK_ID)));
        hadith.setChapter_ID(cursor.getLong(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_CHAPTER_ID)));
        hadith.setHadith_ID(cursor.getLong(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_HADITH_ID)));
        hadith.setEn_Sanad(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_EN_SANAD)));
        hadith.setEn_Text(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_EN_TEXT)));
        hadith.setAr_Sanad_1(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_AR_SANAD)));
        hadith.setAr_Text(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_AR_TEXT)));
        hadith.setRead_Column(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_READ_COLUMN)));
        hadith.setMark_Column(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_MARK_COLUMN)));

        return hadith;
    }


    public long getBook_ID() {
        return Book_ID;
    }

    private void setBook_ID(long book_ID) {
        Book_ID = book_ID;
    }

    public long getChapter_ID() {
        return Chapter_ID;
    }

    private void setChapter_ID(long chapter_ID) {
        Chapter_ID = chapter_ID;
    }

    public long getHadith_ID() {
        return Hadith_ID;
    }

    private void setHadith_ID(long hadith_ID) {
        Hadith_ID = hadith_ID;
    }

    public String getEn_Sanad() {
        return En_Sanad;
    }

    private void setEn_Sanad(String en_Sanad) {
        En_Sanad = en_Sanad;
    }

    public String getEn_Text() {
        return En_Text;
    }

    private void setEn_Text(String en_Text) {
        En_Text = en_Text;
    }

    public String getAr_Sanad_1() {
        return Ar_Sanad_1;
    }

    private void setAr_Sanad_1(String ar_Sanad_1) {
        Ar_Sanad_1 = ar_Sanad_1;
    }

    public String getAr_Text() {
        return Ar_Text;
    }

    private void setAr_Text(String ar_Text) {
        Ar_Text = ar_Text;
    }

    public String getRead_Column() {
        return Read_Column;
    }

    private void setRead_Column(String read_Column) {
        Read_Column = read_Column;
    }

    public String getMark_Column() {
        return Mark_Column;
    }

    private void setMark_Column(String mark_Column) {
        Mark_Column = mark_Column;
    }
}
