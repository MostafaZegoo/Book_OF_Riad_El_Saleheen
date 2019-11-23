package com.mostafa.book_of_riad_el_saleheen.model;

import android.database.Cursor;


import com.mostafa.book_of_riad_el_saleheen.repository.DatabaseOpenHelper;

import java.io.Serializable;

public class Books implements Serializable {

    private long Book_ID;
    private String Ar_Name;
    private String En_Name;

    private Books() {

    }

    public static Books get(Cursor cursor) {

        Books book = new Books();

        book.setAr_Name(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_AR_NAME)));
        book.setEn_Name(cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_EN_NAME)));
        book.setBook_ID(cursor.getLong(cursor.getColumnIndex(DatabaseOpenHelper.Constants.COLUMN_BOOK_ID)));

        return book;
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

}
