package com.mostafa.book_of_riad_el_saleheen.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Message {

    public static void message (Context context, String message) {

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

        Log.e(message, "number = " + message);

    }

}
