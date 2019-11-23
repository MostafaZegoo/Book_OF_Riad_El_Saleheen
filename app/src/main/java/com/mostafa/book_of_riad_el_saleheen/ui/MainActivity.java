package com.mostafa.book_of_riad_el_saleheen.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mostafa.book_of_riad_el_saleheen.R;
import com.mostafa.book_of_riad_el_saleheen.model.Books;
import com.mostafa.book_of_riad_el_saleheen.model.Chapters;
import com.mostafa.book_of_riad_el_saleheen.repository.DatabaseAccess;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    RecyclerViewAdapter adapter;

    DatabaseAccess databaseAccess;

    static int book_id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseAccess = DatabaseAccess.getInstance(this);

        List<String> name = new ArrayList<>();

        List<String> chapter_intro = new ArrayList<>();

        databaseAccess.open();

        if (book_id > 0) {

            List<Chapters> chapters = databaseAccess.getChapters(String.valueOf(book_id));

            //traverse elements of ArrayList object
            for (Chapters chapter : chapters) {

                name.add(chapter.getAr_Name());
                chapter_intro.add(chapter.getChapter_Intro());

            }

            adapter = new RecyclerViewAdapter(this, name, chapter_intro, "chapters");

        } else {

            List<Books> books = databaseAccess.getBooks();

            //traverse elements of ArrayList object
            for (Books book : books) {

                name.add(book.getAr_Name());

            }

            adapter = new RecyclerViewAdapter(this, name, "books");

        }

        // close database connection
        databaseAccess.close();

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position, String tag) {

        Intent intent;

        String index;

        databaseAccess = DatabaseAccess.getInstance(this);

        databaseAccess.open();

        switch (tag) {

            case "books":
                book_id = position + 1;
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case "chapters":
                intent = new Intent(this, HadithActivity.class);
                int chapter_id = position + 1;
                index = databaseAccess.getHadithIndex(String.valueOf(book_id), String.valueOf(chapter_id));
                intent.putExtra("first_hadith_index", index);
                startActivity(intent);
                break;

        }

        databaseAccess.close();

    }

}
